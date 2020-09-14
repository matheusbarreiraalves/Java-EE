<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "java.sql . *"  %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%

	/**** Informações para conexão com o DB *****/
	Connection con = null;
	String driver = "com.mmysql.cj.jdbc..Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "";

	/**** CRUD - CREATE e Tratamento de exceções ****/
	try{
	Class.forName(driver);
	con = DriverManager.getConnection(url, user, password);
	//parâmetros capturados pelo formulário
	String nome=request.getParameter("nome");
	String fone=request.getParameter("fone");
	String email=request.getParameter("email");
	String create = "insert into tbcontatos (nome, fone, email) values ('" + nome + "','"+ fone + "','"+ email +"')";
	con.createStatement().executeUpdate(create);
	//após o insert, redirecionar para o arquivo agenda.jsp
	response.sendRedirect("agenda.jsp");
	} catch (Exception e){
		out.print(e);
	} finally{
		//Fechando conexão com o DB
		con.close();
	}
%>
</body>
</html>