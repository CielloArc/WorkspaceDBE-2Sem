<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"  %>

<tags:template titulo="Lista de Veículos">
	<h1>Lista de Veículos</h1>
	<table class="table">
		<tr>
			<th>Modelo</th>
			<th>Marca</th>
			<th>Valor</th>
			<th>Travado</th>
		</tr>
		<c:forEach items="${consoles }" var="c">
			<tr>
				<td>${c.modelo}</td>
				<td>${c.marca }</td>
				<td>${c.valor }</td>
				<td>${c.travado }</td>
			</tr>
		</c:forEach>
	</table>
</tags:template>