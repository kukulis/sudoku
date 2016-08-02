<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sudoku board</title>

<spring:url value="/"
	var="rootUrl" />

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />

<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/core/js/view.js" var="viewJs" />

<c:url var="root" value="/" scope="request" />
	

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${viewJs}"></script>
<script>
jQuery(document).ready(function($) {
	loadBoard("${root}", "${id}");
	clearMessage();
});
</script>

</head>
<body>
<a href="${rootUrl}/sudoku">Back to list</a>
 <p>Board id=${id}</p>
 <table class="table table-bordered" style="width:300px;">
 <c:forEach var="y" begin="0" end="8">
 	<tr>
	 	<c:forEach var="x" begin="0" end="8">
 		<td style="width:30px;" width="30px"><input type="text" id="cell${x}${y}" name="cell${x}${y}" size="1" maxlength="1" style="border: 0px solid;" /></td>
 		</c:forEach>
 	<tr>
 	</c:forEach>
 </table>
 <p><span id="message"> </span> <button onclick="clearMessage()" id="clearButton" >OK</button></p>	
 <p>Dont forget to save changes after editing!!!<button onclick="saveChanges(${root}, ${id})">Save changes </button>
 <p><button onclick="solveBoard(${root}, ${id})">Solve board</button></p>
</body>
</html>