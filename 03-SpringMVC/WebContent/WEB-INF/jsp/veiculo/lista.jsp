<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"  %>

<tags:template titulo="Lista de Veículos">
	<h1>Lista de Veículos</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>
	
	<table class="table">
		<tr>
			<th>Modelo</th>
			<th>Marca</th>			
			<th>Placa</th>
			<th>Ano</th>
			<th>Data de Fabricao</th>
			<th>Ações</th>
		</tr>
		<c:forEach items="${veiculos }" var="v">
			<tr>
				<td>${v.modelo}</td>
				<td>${v.marca }</td>				
				<td>${v.placa }</td>
				<td>${v.ano }</td>
				<td>
					<fmt:formatDate value="${v.dataFabricacao.time }" pattern="dd/MM/yyyy" /> 
				</td>
				<td>
					<c:url value="/veiculo/editar/${v.codigo}" var="link"/>
					<a href="${link}" class="btn btn-primary btn-sm">Editar</a>
					<button onclick="idCodigo.value = ${v.codigo}" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#exampleModal">
 						Excluir
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Excluir</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Deseja realmente excluir?
      </div>
      <div class="modal-footer">
      	<c:url value="/veiculo/excluir" var="excluir"/>
      	<form:form action="${excluir }" method="post">
      		<input type="hidden" name="codigo" id="idCodigo">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
	        <button type="submit" class="btn btn-danger">Sim</button>
	    </form:form>
      </div>
    </div>
  </div>
</div>
	
</tags:template>



