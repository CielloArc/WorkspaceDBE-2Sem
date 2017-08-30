<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<tags:template titulo="Cadastro de Veículo">
	<jsp:attribute name="script">
	<p>Banana</p>
</jsp:attribute>
	<jsp:body>
	<h1>Cadastro</h1>
	<form action="cadastrar" method="post">
		<div class="form-group"> 
			<label for="id-marca">Marca</label>
			<input type="text" name="marca" id="id-marca" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-modelo">Modelo</label>
			<input type="text" name="modelo" id="id-modelo" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-ano">Ano</label>
			<input type="text" name="ano" id="id-ano" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-placa">Placa</label>
			<input type="text" name="placa" id="id-placa" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-cor">Cor</label>
			<input type="text" name="cor" id="id-cor" class="form-control">
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form>
	</jsp:body>
</tags:template>