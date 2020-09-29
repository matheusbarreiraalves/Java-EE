<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
	//recebimento do conteúdo JavaBeans encaminhado pelo Controller
	String idcliente = (String) request.getAttribute("idcliente");
	String nome = (String) request.getAttribute("nome");
	String cpf = (String) request.getAttribute("cpf");
	String telefone = (String) request.getAttribute("telefone");
	String sexo = (String) request.getAttribute("sexo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>agenda2</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="frmContato" action="update2">
		<h1>Editar cliente</h1>
		<table>
			<tr>
				<td><input type="text" name ="idcliente" value="<%=idcliente%>" readonly id="caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" value="<%=nome%>" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="number" name="cpf" value="<%=cpf%>" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="tel" name="telefone" value="<%=telefone%>" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="sexo" value="<%=sexo%>" class="Caixa1"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" onclick="validar()" class="Botao1">
	</form>
	<script src="validador.js"></script>
</body>
</html>