<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Page Content -->
<div class="container">

	<!-- Jumbotron Header -->
	<header class="jumbotron hero-spacer">
		<h1>Seja bem-vindo!</h1>
		<p>Esta loja foi construída para fins de estudo de Técnicas Ágeis
			em desenvolvimento java</p>
	</header>

	<hr>

	<!-- Title -->
	<div class="row">
		<div class="col-lg-12">
			<h3>Lista de Produtos</h3>
		</div>
	</div>
	<!-- /.row -->

	<!-- Page Features -->
	<div class="row text-center">
		<c:if test="${not empty produtos}">
			<c:forEach var="produto" items="${produtos}">
				<div class="col-md-3 col-sm-6 hero-feature">
					<div class="thumbnail">
						<img src="http://placehold.it/800x500" alt="">
						<div class="caption">
							<h3>${produto.descricao}</h3>
							<p>Ainda temos ${produto.quantidadeEstoque} unidades</p>
							<p>
                            	<a href="<c:url value='${produto.id}' />" class="btn btn-primary">Compre Agora!</a> 
                        	</p>							
						</div>
					</div>
				</div>
			</c:forEach>
	</c:if>
	<!-- /.row -->

	<hr>
</div>
<!-- /.container -->
