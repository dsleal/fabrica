<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>
<body>
	<%
	   java.util.Enumeration values = session.getAttributeNames();
	   while (values.hasMoreElements()) {
	      session.removeAttribute(values.nextElement().toString());
	   }
	   session.invalidate();
	   response.sendRedirect("login.jsp");
	%>
	SAINDO DO SISTEMA ... AGUARDE ...
</body>
</html>