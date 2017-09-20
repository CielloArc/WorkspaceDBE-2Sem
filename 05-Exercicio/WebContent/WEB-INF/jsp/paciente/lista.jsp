<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:template titulo="Lista de Pacientes">
	<h1>Lista de Pacientes</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-info">
			${msg }
		</div>
	</c:if>
	
	<table class="table table-hover">
		<tr>
			<th>Nome</th>
			<th>Data Nascimento</th>
			<th>Quarto</th>
			<th>Acoes</th>		
		</tr>
		<c:forEach items="${pacientes}" var="p">
			<tr>
				<td>${p.nome}</td>
				<td>								
					<fmt:formatDate value="	${p.dataNascimento.time}" pattern="dd/MM/yyyy" />
				</td>
				<td>${p.numeroQuarto}</td>
				<td>EDITAR		DELETAR</td>
			</tr>			
		</c:forEach>
			
	</table>	
		
</tags:template>
