package br.com.senai.fatesg.fabrica.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.ambientinformatica.util.UtilLog;

public class UsuarioService implements UserDetailsService{

   private DataSource dataSource;

   private void registrarHistoricoLogin(Connection con, String login) throws SQLException{
      Date agora = new Date();
      PreparedStatement pstmtUsuario = con.prepareStatement("update usuario set dataultimoacesso = ? where login = ?");
      pstmtUsuario.setTimestamp(1, new Timestamp(agora.getTime()));
      pstmtUsuario.setString(2, login);
      pstmtUsuario.execute();

      PreparedStatement pstmtHistorico = con.prepareStatement("insert into historicologin (id, data, usuario_login) values ((select nextval('historicologin_seq')), ?, ?)");
      pstmtHistorico.setTimestamp(1, new Timestamp(agora.getTime()));
      pstmtHistorico.setString(2, login);
      pstmtHistorico.execute();
   }

   @Override
   public UserDetails loadUserByUsername(String username) {
      try {
         Connection con = dataSource.getConnection();
         String sqlUsuario = "SELECT login AS username, senha as password, ativo AS enabled FROM usuario WHERE login = ?";

         String sqlPapeis = "select papel as authority from papelusuario where usuario_id = ?";
         try{
            PreparedStatement pstmt = con.prepareStatement(sqlUsuario);
            try {
               pstmt.setString(1, username);
               ResultSet rs = pstmt.executeQuery();

               try {
                  if (rs.next()) {
                     List<GrantedAuthority> papeis = new ArrayList<GrantedAuthority>();
                     PreparedStatement pstmtPapeis = con.prepareStatement(sqlPapeis);
                     try {
                        pstmtPapeis.setString(1, username);
                        ResultSet rsPapeis = pstmtPapeis.executeQuery();
                        try {
                           UserDetails user;
                           try {
                              papeis.add(new SimpleGrantedAuthority("USUARIO"));
                              while (rsPapeis.next()) {
                                 papeis.add(new SimpleGrantedAuthority(rsPapeis.getString("authority")));
                              }

                              user = new UsuarioImpl(username,
                                    rs.getString("password"),
                                    rs.getBoolean("enabled"), true, true, true,
                                    papeis);

                              registrarHistoricoLogin(con, username);
                           } finally {
                              rsPapeis.close();
                           }
                           return user;
                        } finally {
                           rsPapeis.close();
                        }
                     } finally {
                        pstmtPapeis.close();
                     }
                  } else {
                     throw new UsernameNotFoundException("Usuário " + username + " não encontrado");
                  }
               } finally {
                  rs.close();
               }
            } finally {
               pstmt.close();
            }
         }finally{
            con.close();
         }
      } catch (RuntimeException e) {
         UtilLog.getLog().error(e.getMessage(), e);
         throw new DataAccessExceptionImpl(e.getMessage(), e);
      } catch (SQLException e) {
         UtilLog.getLog().error(e.getMessage(), e);
         throw new DataAccessExceptionImpl(e.getMessage(), e);
      }
   }


   public DataSource getDataSource() {
      return dataSource;
   }


   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
   }

   private static class DataAccessExceptionImpl extends DataAccessException{

      private static final long serialVersionUID = 1L;

      public DataAccessExceptionImpl(String msg, Exception e) {
         super(msg, e);
      }

   }

}
