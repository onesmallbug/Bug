<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="BIG5">
<title>���U</title>

<%@ include file="link1.file"%>

</head>
<body>
	<div id="wrapper" class="home-page">
		<!-- start header -->
		<jsp:include page="Header.jsp" />
		<!-- end header -->


		<!--/*�o��O�u�@�϶}�l*/ -->
		<div class="container">
			<div class="row">

				<div class="col-md-8"></div>

				<div class="col-md-3">
					<FORM action="MemberServlet" method=post>

						<h5>���U</h5>
						<h5 style="color: red">${errorMessage}</h5>
						<div>�b���G���^��V�X���좷�X</div>
						<input type="text" name="member_account" value="${member_account}"> <br>
						<div>�K�X�G���^��V�X���좷�X</div>
						<input type="text" name="password1" value="${password1}">
						<div>�A����J�K�X</div>
						<input type="text" name="password2" value="${password2}"><br>
						<div>�W��</div>
						<input type="text" name="member_name" value="${member_name}"><br> 
						
						<input type="checkbox" name="action" value="new" checked
							style='display: none'> 
							
						<input type="submit" value="�T�{">
					</FORM>
				</div>

				<div class="col-md-1"></div>

			</div>
		</div>
		<!--/*�o��O�u�@�ϵ���*/ -->

		<jsp:include page="Footer.jsp" />

	</div>

	<%@include file="link2.file"%>

</body>
</html>