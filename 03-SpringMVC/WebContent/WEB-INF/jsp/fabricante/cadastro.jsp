<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template titulo="Cadastro de Fabricante">
	<jsp:body>
		<h1>Cadastro de Fabricante</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-info">
				${msg }
			</div>
		</c:if>
		<c:url value="/fabricante/cadastrar" var="action" />
		<form:form action="${action }" method="post" commandName="fabricante">
			<div class="form-group">
				<form:label path="nome">Nome</form:label>
				<form:input path="nome" cssClass="form-control"/>
				<form:errors path="nome" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="dataFundacao">Data de Fundação</form:label>
				<form:input path="dataFundacao" cssClass="form-control"/>
				<form:errors path="dataFundacao" cssClass="text-danger"/>
			</div>
		
			<input type="submit" class="btn btn-primary" value="Salvar">
		
		</form:form>	
	</jsp:body>
</tags:template>