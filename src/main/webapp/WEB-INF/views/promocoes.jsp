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
									 
							<div >
<div class="form-group row"> 


  <div class="col-xs-8">
    <label class="control-label">Effective Date</label>
    <div class="input-group date" id="dp3" data-date="12-02-2012" data-date-format="dd/mm/yyyy">
      <input class="form-control" type="text" readonly="" value="12-02-2012">
      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
    </div>
  </div>
</div>		
					<div class="input-append date">
    <input value="12-02-2012">
    <span class="add-on"><i class="icon-th"></i></span>
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
<script type="text/javascript">
$(document).ready(function() {
	$('.datepicker').datepicker();
});
</script>