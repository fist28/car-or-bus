<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> -->



<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap Core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/css/agency.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


<!-- jQuery -->
<script src="/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/js/bootstrap.min.js"></script>


</head>

<body id="page-top" class="index">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="/">Car or BUS</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="/"></a></li>
					<li><a class="page-scroll" href="/#find">Find trace!</a></li>
					<li><a class="page-scroll" href="/#last">Last traces</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<%-- 
	<a href="<spring:url value="/traces.html" />">Wyznaczone trasy</a><br>
	
	<a href="<spring:url value="/traces/new.html" />">Nowa</a><br> --%>

	<%-- 
	<tiles:insertAttribute name="body" /> --%>
	<%-- <tiles:insertAttribute name="foozter" /> --%>


	<!-- Header -->
	<header>
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in">Car or BUS</div>
				<div class="intro-heading">It will be faster!</div>
				<a href="/#find" class="page-scroll btn btn-xl">Get started
					now!</a>
			</div>
		</div>
	</header>

	<tiles:insertAttribute name="body" />


<!-- Team Section -->
<section id="team" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">Our Amazing Team</h2>
				<!-- <h3 class="section-subheading text-muted">Lorem ipsum dolor sit
					amet consectetur.</h3> -->
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="team-member">
					<img
						src="https://s.gravatar.com/avatar/702d17f7cf3ff82ba18b51eea74cf47b?s=120"
						class="img-responsive img-circle" alt="">
					<h4>Filip Stybel</h4>
					<p class="text-muted">Developer</p>
					<ul class="list-inline social-buttons">
						<li><a href="https://github.com/fist28" target="_blank"><i
								class="fa fa-github"></i></a></li>
						<li><a href="https://pl.linkedin.com/in/filipstybel"
							target="_blank"><i class="fa fa-linkedin"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- <div class="row">
			<div class="col-lg-8 col-lg-offset-2 text-center">
				<p class="large text-muted">Lorem ipsum dolor sit amet,
					consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos
					non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>
			</div>
		</div> -->
	</div>
</section>

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">Copyright &copy; CarOrBus 2015</span>
				</div>
				<div class="col-md-4">
					
				</div>
				<div class="col-md-4">
					<ul class="list-inline quicklinks">
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Terms of Use</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>

	<!-- Custom Theme JavaScript -->
	<script src="/js/agency.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="/js/classie.js"></script>
	<script src="/js/cbpAnimatedHeader.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="/js/jqBootstrapValidation.js"></script>
</body>

</html>