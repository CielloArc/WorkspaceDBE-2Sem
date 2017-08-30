<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="titulo" required="true" %>
<%@ attribute name="script" fragment="true" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${titulo }</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">FIAP</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="cadastrar">Cadastrar <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="listar">Listar</a>
      </li>      
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
	<div class="container">	
		<jsp:doBody/>
	</div>
	<p style="text-align: center;">Todos os Direitos Reservados &copy; - 2017</p>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	
	<jsp:invoke fragment="script"></jsp:invoke>
</body>
</html>