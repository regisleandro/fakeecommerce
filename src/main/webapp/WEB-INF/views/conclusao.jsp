<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
		<!-- Title -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel ${panel} }">
						  <div class="panel-heading">
						  		<h2>${mensagem}</h2>
						    	<h3 class="panel-title">Detalhes do Produto: <strong> ${produto.descricao} </strong></h3>
						    	<p>Valor: 
						    		<fmt:setLocale value="pt_BR"/>
									<fmt:formatNumber value="${precoFinal}" type="currency"/>
								</p>
						  </div>
						  <div class="panel-body">
								
						  </div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		
			<!-- Page Features -->
		
			<hr>
		</div>
		<!-- /.container -->