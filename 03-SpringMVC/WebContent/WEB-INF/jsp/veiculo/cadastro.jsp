<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:template titulo="Cadastro de Veículo">
	<jsp:attribute name="script">
		<p>Aqui entra os javascripts...</p>
	</jsp:attribute>
	<jsp:body>
		<h1>Cadastro</h1>
			<c:if test="${not empty msg }">
				<div class="alert alert-success">
					${msg}
				</div>
			</c:if>
		
		<c:url value="/veiculo/cadastrar" var="action"/>
		<form:form action="${action}" method="post" commandName="veiculo">
			<div class="form-group">
				<form:label path="marca">Marca</form:label>
				<form:input path="marca" cssClass="form-control"/>
				<form:errors path="marca" cssClass="text-danger"/>
			</div>	
			<div class="form-group">
				<form:label path="modelo">Modelo</form:label>
				<form:input path="modelo" cssClass="form-control"/>
				<form:errors path="modelo" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="ano">Ano</form:label>
				<form:input path="ano" cssClass="form-control"/>
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
			<input type="submit" value="Salvar" class="btn btn-primary">
		</form:form>
	</jsp:body>
</tags:template>