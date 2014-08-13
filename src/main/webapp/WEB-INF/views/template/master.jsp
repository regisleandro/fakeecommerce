<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Fake Ecommerce</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<!-- DateTimePicker CSS-->
<link href="<c:url value='/resources/jquery-ui/jquery-ui.css'/>" rel="stylesheet">
<!-- Custom CSS -->
<link href="<c:url value='/resources/css/heroic-features.css'/>" rel="stylesheet">

<!-- JQuery -->
<script src="<c:url value='/resources/js/jquery-1.11.1.js'/>" > </script>

<script src="<c:url value='/resources/js/moment.js'/>" > </script>

<!--[if IE]>
   <script src="<c:url value='/resources/js/bootstrap.min.ie.js'/>"></script>
<![endif]-->
<!--[if !IE]><!-->
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<!--<![endif]-->

<!-- DateTimePicker JS -->
<script src="<c:url value='/resources/jquery-ui/jquery-ui.js'/>"></script>

</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header" />

		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />