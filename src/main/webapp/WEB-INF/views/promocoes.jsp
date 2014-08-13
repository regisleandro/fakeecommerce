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
									  modelAttribute="promocao" cssClass="form-horizontal">
							  <form:hidden path="id" />
							  <div class="form-group">
							      <label for="dataInicio" class="col-sm-2 control-label">Início</label>
							      <div class="col-sm-10">
							      	<form:input path="dataInicio" id="dataInicio" cssClass="form-control datepicker" placeholder="Data de Início (dd/mm/yyyy)" />
								  </div>
							  </div>							  
							  <div class="form-group">
							      <label for="dataFim" class="col-sm-2 control-label">Término</label>
							      <div class="col-sm-10">
							      	<form:input path="dataFim" id="dataFim" cssClass="form-control datepicker" placeholder="Data de Término (dd/mm/yyyy)" />
								  </div>
							  </div>							  
							  <div class="form-group">
							      <label for="percentualDesconto" class="col-sm-2 control-label">% de Desconto</label>
							      <div class="col-sm-10">
							      	<form:input path="percentualDesconto" id="percentualDesconto" cssClass="form-control" placeholder="% de Desconto" />
								  </div>
							  </div>							  
							  <div class="form-group">
    							   <div class="col-sm-offset-2 col-sm-10">
      								 <button type="submit" class="btn btn-default">Salvar</button>
    							  </div>
  							  </div>
  							</form:form>
						  </div>
					</div>
				</div>
			</div>
			
			<!-- /.row -->
		
			<!-- Page Features -->
		
			<hr>
		</div>
		<!-- /.container -->
<script>
  $(function() {
    $( ".datepicker" ).datepicker({
        dateFormat: 'dd/mm/yy',
        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
    });
  });
  </script>