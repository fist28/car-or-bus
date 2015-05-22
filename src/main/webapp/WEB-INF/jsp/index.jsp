<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<!-- Header -->
<header>
	<div class="container">
		<div class="intro-text">
			<div class="intro-lead-in">Car or BUS</div>
			<div class="intro-heading">It will be faster!</div>
			<a href="#services" class="page-scroll btn btn-xl">Get started
				now!</a>
		</div>
	</div>
</header>

<!-- Services Section -->
<section id="find">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">Find trace</h2>
				<h3 class="section-subheading text-muted">Fill form and check
					what will be better today!</h3>
			</div>
		</div>
		<div class="row text-center">
			<form:form commandName="trace">
				<div class="col-md-5">
					<p class="lead">Source</p>
					<div class="col-md-12">
						<form:input path="sourceCity"
							class="form-group form-control input-lg" placeholder="City *"
							required="true" />
					</div>
					<div class="col-md-8">
						<form:input path="sourceStreet"
							class="form-group form-control input-lg "
							placeholder="Street name *" required="true" />
					</div>
					<div class="col-md-4">
						<form:input path="sourceStreetNumber"
							class="form-group form-control input-lg col-md-4"
							placeholder="Number *" required="true" />
					</div>
				</div>

				<div class="col-md-2" style="top: 80px; font-size: 40px;">
					<i class="glyphicon glyphicon-random"></i>
				</div>

				<div class="col-md-5">
					<p class="lead">Destination</p>
					<div class="col-md-12">
						<form:input path="destinationCity"
							class="form-group form-control input-lg" placeholder="City *"
							required="true" />
					</div>
					<div class="col-md-8">
						<form:input path="destinationStreet"
							class="form-group form-control input-lg "
							placeholder="Street name *" required="true" />
					</div>
					<div class="col-md-4">
						<form:input path="destinationStreetNumber"
							class="form-group form-control input-lg col-md-4"
							placeholder="Number *" required="true" />
					</div>
				</div>
				<input type="submit" value="Check!" class="btn btn-warning btn-lg" />
			</form:form>
		</div>
	</div>
</section>

<!-- Services Section -->
<section id="last">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">Last traces</h2>
				<!-- <h3 class="section-subheading text-muted">Fill form and check what will be better today!</h3 -->
			</div>
		</div>
		<div class="row text-center">
			<table class="table table-hover ">
				<thead>
					<tr>
						<th>Data</th>
						<th>From</th>
						<th>To</th>
						<th>Time</th>
						<th>Car or BUS</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${traces}" var="trace">
						<tr class="clickable-row text-left" data-href="<spring:url value="/traces/${trace.id}.html" />">
							<td></td>
							<td>${trace.sourceCity}, ${trace.sourceStreet} ${trace.sourceStreetNumber} </td>
							<td>${trace.destinationCity}, ${trace.destinationStreet} ${trace.destinationStreetNumber} </td>
							<td>${trace.time}</td>
							<td>${trace.carOrBus}</td>		
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>

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