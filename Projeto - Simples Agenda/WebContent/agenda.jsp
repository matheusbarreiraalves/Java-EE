<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import= "java.sql.*"  %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
</head>
<body>

	<h1>Agenda de Contatos</h1>
	<p>
		<a href="novo.html"> Adicionar contato </a>
	</p>
	<%
	/****Informações para conexão com o DB *****/
	Connection con = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "";
	
	/**** CRUD - READ e Tratamento de exceções ****/
	try{
		Class.forName(driver);
		con = DriverManager .getConnection(url, user, password);
		String read = "select * from tbcontatos order by nome asc";
		ResultSet rs = con.createStatement().executeQuery(read);
		
		// Enquanto tiver usuários
		while(rs.next()){
			out.println("<p>");
			/* out.println(rs.getString(1)); // id
			out.println("|"); */
			out.println(rs.getString(2)); // nome
			out.println("|");
			out.println(rs.getString(3)); // fone
			out.println("|");
			out.println(rs.getString(4)); // email
			out.println("</p>");
		}
		
	}catch (Exception e) {
		out.print(e);
	} finally{
		//fechando conexão com o DB
		con.close();
	}
	%>
</body>
</html>