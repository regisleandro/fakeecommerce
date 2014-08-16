<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR"/>

		<!-- Title -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-${panel}">
						  <div class="panel-heading">
						    	<h3 class="panel-title">${titulo}</h3>
						  </div>
						  <div class="panel-body">
						  	<c:url var="actionPath" value='${action}' />
							<form:form method="post" action="${actionPath}" 
									  modelAttribute="produto" cssClass="form-horizontal">
									 <form:hidden path="id" />
							  <div class="form-group">
							      <label for="descricao" class="col-sm-2 control-label">Descrição </label>
							      <div class="col-sm-10">
							      		<form:input path="descricao" id="descricao" cssClass="form-control" placeholder="Descrição"/>							      	
								  </div>
							  </div>
							  <div class="form-group">
							      <label for="quantidade" class="col-sm-2 control-label">Quantidade</label>
							      <div class="col-sm-10">
							      	<form:input path="quantidadeEstoque" id="quantidade" cssClass="form-control" placeholder="Quantidade" />
								  </div>
							  </div>
							  <div class="form-group">
							      <label for="preco" class="col-sm-2 control-label">Preço</label>
							      <div class="col-sm-10">
							      	<form:input path="preco" id="preco" cssClass="form-control" placeholder="Preço em R$" />
								  </div>
							  </div>
							  <div class="form-group">
							      <label for="tipo" class="col-sm-2 control-label">Tipo de Produto</label>
							      <div class="col-sm-10">
							      		<form:select path="tipo" items="${tipos}" cssClass="form-control" />
								  </div>
							  </div>

							  <div class="form-group">
    							   <div class="col-sm-offset-2 col-sm-10">
      								 <button type="submit" class="btn btn-default">Salvar</button>
    							  </div>
  							  </div>
  							</form:form>
  							  <table class="table table-hover">
	  							  <thead>
							            <tr>
							                <th>Descrição do Produto</th>
							                <th>Unidades em estoque</th>
							                <th>Valor de Venda</th>
							                <th>Edição</th>
							            </tr>
							        </thead>
							        <tbody>
										<c:forEach items="${produtos}" var="p">
										    <tr>
										        <td>${p.descricao}</td>
										        <td>${p.quantidadeEstoque}</td>
										        <td>
													<fmt:formatNumber value="${p.preco}" type="currency"/>
												</td>
										        <td>
										        	<a href="<c:url value='/produtos/editar/${p.id}' />" class="btn btn-default">Editar</a>
										        	<a href="<c:url value='/produtos/excluir/${p.id}' />" class="btn btn-link">Excluir</a>
										        	<a href="<c:url value='/promocoes/adicionar/${p.id}/promocao/${p.idPromocao}' />" class="btn btn-primary">Adicionar Promoção</a>
										        </td>
										    </tr>
										</c:forEach>							           
							        </tbody>
							  </table> 							  						
						  </div>
					</div>
				</div>
			</div>
			
			<!-- /.row -->
		
			<!-- Page Features -->
		
			<hr>
		</div>
		<!-- /.container -->