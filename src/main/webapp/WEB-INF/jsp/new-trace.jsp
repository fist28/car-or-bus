<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp" %>

<h1>Nowa trasa</h1>

<form:form commandName="trace">
	<form:input path="sourceCity" />
	<form:input path="sourceStreet" />
	<form:input path="sourceStreetNumber" />
	
	<form:input path="destinationCity" />
	<form:input path="destinationStreet" />
	<form:input path="destinationStreetNumber" />
	
	<input type="submit" value="Save"/>
	
</form:form>