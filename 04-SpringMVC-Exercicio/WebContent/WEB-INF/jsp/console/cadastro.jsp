<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<tags:template titulo="Cadastro de consoles">
<jsp:attribute name="script">	
</jsp:attribute>
<jsp:body>
	<h1>Cadastro</h1>
	<form action="cadastrar" method="post">
	
		<div class="form-group">
			<label for="idModelo">Modelo</label>
			<input type="text" name="modelo" id="idModelo" class="form-control">
		</div>		
		<div class="form-group">
			<label for="idMarca">Marca</label>
			<input type="text" name="marca" id="idMarca" class="form-control">
		</div>		
		<div class="form-group">
			<label for="idValor">Valor</label>
			<input type="text" name="valor" id="idValor" class="form-control">
		</div>
		<div class="form-group">
			<label for="idTravado">Travado</label>
			<input type="checkbox" name="travado" id="idTravado" class="">
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">		
	</form>	
</jsp:body>
</tags:template>