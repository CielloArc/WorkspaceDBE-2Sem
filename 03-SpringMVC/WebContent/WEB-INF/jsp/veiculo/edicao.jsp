<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tag:template titulo="Editar Veículo">
	<h1>Atualização de Veículo</h1>
	
	<c:url value="/veiculo/editar" var="link"/>
	<form:form action="${link}" method="post" commandName="veiculo">
		<form:hidden path="codigo"/>
		<div class="form-group">
			<form:label path="marca">Marca</form:label>
			<form:input path="marca" cssClass="form-control"/>
			<form:errors path="marca" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="modelo">Modelo</form:label>
			<form:input path="modelo" cssClass="form-control"/>
			<form:errors path="modelo" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="ano">Ano</form:label>
			<form:input path="ano" cssClass="form-control" />
			<form:errors path="ano" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="dataFabricacao">Data de Fabricacao</form:label>
			<form:input path="dataFabricacao" cssClass="form-control"/>
			<form:errors path="dataFabricacao" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="placa">Placa</form:label>
			<form:input path="placa" cssClass="form-control"/>
			<form:errors path="placa" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="cor">Cor</form:label>
			<form:input path="cor" cssClass="form-control"/>
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary" >
		<c:url value="/veiculo/listar" var="listar"/>
		<a href="${listar}" class="btn btn-secondary">Cancelar</a>
	</form:form>
	
</tag:template>



