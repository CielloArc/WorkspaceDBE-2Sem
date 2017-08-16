<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de prato</title>
</head>
<body>
	<form action="cadastrar" method="post">
		<div>
			<label for="nomePrato">Nome:</label> <input name="nome" id="nomePrato"
				type="text">
		</div>
		<div>
			<label for="precoPrato">Preço:</label> <input name="preco" id="precoPrato"
				type="text">
		</div>
		<div>
			<label for="pesoPrato">Peso:</label> <input name="peso" id="pesoPrato"
				type="text">
		</div>
		<div>
			<input type="submit" value="Cadastrar">
		</div>
	</form>
</body>
</html>