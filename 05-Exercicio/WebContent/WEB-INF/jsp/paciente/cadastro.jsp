<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:template titulo="Cadastro de Paciente">
	<jsp:body>
		<h1>Ficha do paciente</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-info">
				${msg}
			</div>
		</c:if>
		<c:url value="/paciente/cadastrar" var="action"/>
		<form:form action="${action}" method="post" commandName="paciente">
			<div class="form-group">
				<form:label path="nome">Nome</form:label>
				<form:input path="nome" cssClass="form-control"/>
				<form:errors path="nome" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="dataNascimento">Data de Nascimento</form:label>
				<form:input path="dataNascimento" cssClass="form-control"/>
				<form:errors path="dataNascimento" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="numeroQuarto">Numero do Quarto</form:label>
				<form:input path="numeroQuarto" cssClass="form-control"/>
				<form:errors path="numeroQuarto" cssClass="text-danger" />
			</div>
			
			<input type="submit" value="Salvar" class="btn btn-primary">
						
		</form:form>		
	</jsp:body>
</tags:template>>


