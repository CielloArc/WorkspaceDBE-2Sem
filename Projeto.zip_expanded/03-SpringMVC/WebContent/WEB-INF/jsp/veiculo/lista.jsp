<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"  %>

<tags:template titulo="Lista de Veículos">
	<h1>Lista de Veículos</h1>
	<table class="table">
		<tr>
			<th>Modelo</th>
			<th>Marca</th>
			<th>Placa</th>
		</tr>
		<c:forEach items="${veiculos }" var="v">
			<tr>
				<td>${v.modelo}</td>
				<td>${v.marca }</td>
				<td>${v.placa }</td>
			</tr>
		</c:forEach>
	</table>
</tags:template>