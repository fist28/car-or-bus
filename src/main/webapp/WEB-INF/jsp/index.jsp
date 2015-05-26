<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

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
						<th>Distance</th>
						<th>Car or BUS</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${traces}" var="trace">
						<tr class="clickable-row text-left" data-href="<spring:url value="/traces/${trace.id}.html" />">
							<td>${trace.getDate("yyyy/MM/dd HH:mm:ss")}</td>
							<td>${trace.startAddress} </td>
							<td>${trace.endAddress} </td>
							<td>${trace.duration}</td>
							<td>${trace.distance}</td>
							<td><i
						class="${trace.getCarOrBusClass()}" title="${trace.getCarOrBus()}"></i></td>		
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>