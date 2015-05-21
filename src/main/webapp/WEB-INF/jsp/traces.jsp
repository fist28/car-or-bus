<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1>Wyznaczone trasy</h1>
<table>
	<tbody>
		<c:forEach items="${traces}" var="trace">
			<tr>
				<td><a href="<spring:url value="/traces/${trace.id}.html" />">
						${trace.id} </a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>