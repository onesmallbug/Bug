<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.menu.model.MenuVO" import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="BIG5">
<title>Home</title>


</head>
<body>
	<div id="wrapper" class="home-page">
		<!--/*�o��O�u�@�϶}�l*/ -->
		<div class="container">
			<div class="row">

				<div class="col-md-4"></div>

				<div class="col-md-4">
					<table>
					<tr><th>���W��</th><th>����</th></tr>
					
						<c:forEach var="menuVO" items="${theMenuS}">
							<tr><td>${menuVO.menu_name}</td><td>${menuVO.menu_price}</td></tr>
						</c:forEach>

					</table>
				</div>

				<div class="col-md-4"></div>
			</div>
		</div>
		<!--/*�o��O�u�@�ϵ���*/ -->
	</div>


</body>
</html>