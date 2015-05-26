<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<script>
	$(document).ready(function() {
		$('html, body').stop().animate({
			scrollTop : 770
		}, 1500);
		
		// Disable scroll zooming and bind back the click event
		  var onMapMouseleaveHandler = function (event) {
		    var that = $(this);

		    that.on('click', onMapClickHandler);
		    that.off('mouseleave', onMapMouseleaveHandler);
		    that.find('iframe').css("pointer-events", "none");
		  }

		  var onMapClickHandler = function (event) {
		    var that = $(this);

		    // Disable the click handler until the user leaves the map area
		    that.off('click', onMapClickHandler);

		    // Enable scrolling zoom
		    that.find('iframe').css("pointer-events", "auto");

		    // Handle the mouse leave event
		    that.on('mouseleave', onMapMouseleaveHandler);
		  }

		  // Enable map zooming with mouse scroll when the user clicks the map
		  $('.maps.embed-container').on('click', onMapClickHandler);
	});
</script>
<section class="details">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">Trace details</h2>
				<h3 class="section-subheading text-muted">${trace.getStartAddress()}
					<i class="glyphicon glyphicon-menu-right"></i>
					${trace.getEndAddress()}
				</h3>
			</div>
		</div>

		<div class="row">
			<table style="margin: 0 auto; width: auto;" class="table">
				<tr>
					<td style="text-align: center; vertical-align: middle; border: 0"><i
						class="${trace.getCarOrBusClass()}" style="font-size: 130px;" title="${trace.getCarOrBus()}"></i></td>
					<td style="border: 0"><p>
							<i class="glyphicon glyphicon-calendar">
								${trace.getDate("yyyy/MM/dd HH:mm:ss") }</i>
						</p>
						<p>
							<i class="glyphicon glyphicon-log-out">
								${trace.getStartAddress()}</i>
						</p>
						<p>
							<i class="glyphicon glyphicon-log-in">
								${trace.getEndAddress()}</i>
						</p>
						<p>
							<i class="glyphicon glyphicon-time"> ${trace.getDuration()}</i>
						</p>
						<p>
							<i class="glyphicon glyphicon-resize-horizontal">
								${trace.getDistance()}</i>
						</p></td>
				</tr>
			</table>

		</div>
		<hr>
		<div class="row  text-center">
			<p class="lead">The same trace in this moment.</p>
			<div class='content-container  embed-container  maps'>
				<iframe class="map-top" width="100%" height="450" frameborder="0"
					style="border: 0; pointer-events: none;"
					src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyCPFbpY3mLqwrOaamzM2mQN0gw3zHboNVE
    &amp;origin=${trace.getEncodeStartAddress()}&amp;destination=${trace.getEncodeEndAddress()}&amp;avoid=tolls|highways&amp"></iframe>
			</div>
		</div>
	</div>
</section>