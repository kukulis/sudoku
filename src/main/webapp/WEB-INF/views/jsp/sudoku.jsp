<%-- 
***** This is the start page ****** 
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sudoku</title>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />

<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/core/js/sudoku.js" var="sudokuJs" />

<c:url var="root" value="/" scope="request" />

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${sudokuJs}"></script>
<script>
jQuery(document).ready(function($) {
	fillBoardsList("${root}");
});
</script>
</head>
<body>
	Boards list:
	<div id="boardsList"></div>
	<p><button onclick="createNew(${root})">create new</button></p>
</body>