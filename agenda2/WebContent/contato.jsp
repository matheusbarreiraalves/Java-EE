<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>agenda2</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="frmContato" action="insert">
	<h1>Novo cliente</h1>
		<table>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="number" name="cpf" placeholder="Cpf" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="number" name="telefone" placeholder="Telefone" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="sexo" placeholder="Sexo"  class="Caixa1"></td>
			</tr>
		</table>
		<input type="button" value="Adicionar" onclick="validar()" class="Botao1">		
	</form>
	<script src="validador.js"></script>
</body>
</html>