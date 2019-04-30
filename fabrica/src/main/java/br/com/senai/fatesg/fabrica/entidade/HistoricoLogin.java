package br.com.senai.fatesg.fabrica.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HistoricoLogin {

   @Id
   @GeneratedValue(generator="historicologin_seq", strategy=GenerationType.SEQUENCE)
   @SequenceGenerator(name="historicologin_seq", sequenceName="historicologin_seq", allocationSize=1, initialValue=1)
   private Long id;
   
   @ManyToOne
   private Usuario usuario;
   
   @Temporal(TemporalType.TIMESTAMP)
   private Date data;

   public Usuario getUsuario() {
      return usuario;
   }

   public void setUsuario(Usuario usuario) {
      this.usuario = usuario;
   }

   public Date getData() {
      return data;
   }

   public void setData(Date data) {
      this.data = data;
   }

   public Long getId() {
      return id;
   }
   
}
