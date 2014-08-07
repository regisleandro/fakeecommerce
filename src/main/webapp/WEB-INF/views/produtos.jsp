<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
	
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
					<div class="panel panel-default">
						  <div class="panel-heading">
						    	<h3 class="panel-title">Cadastro de Produtos</h3>
						  </div>
						  <div class="panel-body">
							<form name="formulario" class="form-horizontal" role="form">
							  <div class="form-group">
							      <label for="descricao" class="col-sm-2 control-label">Descrição</label>
							      <div class="col-sm-10">
							      	<input type="text" class="form-control" id="descricao" placeholder="Descrição">
								  </div>
							  </div>
							  <div class="form-group">
							      <label for="quantidade" class="col-sm-2 control-label">Quantidade</label>
							      <div class="col-sm-10">
							      	<input type="text" class="form-control" id="quantidade" placeholder="Quantidade">
								  </div>
							  </div>
							  <div class="form-group">
							      <label for="preco" class="col-sm-2 control-label">Preço</label>
							      <div class="col-sm-10">
							      	<input type="text" class="form-control" id="preco" placeholder="Valor em R$">
								  </div>
							  </div>
							  <div class="form-group">
							      <label for="tipo" class="col-sm-2 control-label">Tipo de Produto</label>
							      <div class="col-sm-10">
							      		<select class="form-control">
							      		<c:forEach var="tipo" items="${tipos}">
									        <option>
									          <c:out value="${tipo}"/>
									        </option>
									      </c:forEach>

										</select>
								  </div>
							  </div>

							  <div class="form-group">
    							   <div class="col-sm-offset-2 col-sm-10">
      								 <button type="submit" class="btn btn-default">Cadastrar</button>
    							  </div>
  							  </div>
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