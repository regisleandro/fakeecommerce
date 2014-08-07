<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
		<!-- Title -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						  <div class="panel-heading">
						    	<h3 class="panel-title">Detalhes do Produto: <strong> ${produto.descricao} </strong></h3>
						    	<p>Valor: 
						    		<fmt:setLocale value="pt_BR"/>
									<fmt:formatNumber value="${produto.preco}" type="currency"/>
								</p>
						    	<p>Em estoque: ${produto.quantidadeEstoque}</p>
						  </div>
						  <div class="panel-body">
								<form name="formulario" method="POST" action="<c:url value="/carrinho/concluirCompra/${produto.id}" />"
										  class="navbar-form navbar-left">
								  <div class="form-group">
								    <input type="text" name="quantidade" class="form-control" placeholder="Quantidade">
								  </div>
								  <button type="submit" class="btn btn-default">Concluir compra!</button>
								</form>
						  </div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		
			<!-- Page Features -->
		
			<hr>
		</div>
		<!-- /.container -->