<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.JavaBeans"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>agenda2</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>agenda2</h1>
	<a href="contato.jsp" class="Botao1">Novo Cliente</a>
	<table id="estilo">
		<thead>
			<th>Id</th>
			<th>Nome</th>
			<th>Cpf</th>
			<th>Telefone</th>
			<th>Sexo</th>
			<th>Ações</th>
		</thead>
		<tbody>
			<%
			//objeto dao criado para acessar os métodos da classe DAO
			DAO dao = new DAO();
			ArrayList<JavaBeans> contatos = dao.listarContatos(); // 1 e 5
			for (int i = 0; i < contatos.size(); i++) {
			%>
			<tr>
				<td><%=contatos.get(i).getIdcliente() %></td>
				<td><%=contatos.get(i).getNomecliente() %></td>
				<td><%=contatos.get(i).getCpf() %></td>
				<td><%=contatos.get(i).getTelefone() %></td>
				<td><%=contatos.get(i).getSexo() %></td>
				<!--  update -> requisisão ao Controller update(path) ?id(parametro)-->
				<td><a href="update1?id=<%=contatos.get(i).getIdcliente() %>" class="Botao1">Editar</a><a href="delete?id=<%=contatos.get(i).getIdcliente() %>" id="botao2">Excluir</a></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>


</body>
</html>
