<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="BIG5">
<title>註冊</title>

<%@ include file="link1.file"%>

</head>
<body>
	<div id="wrapper" class="home-page">
		<!-- start header -->
		<jsp:include page="Header.jsp" />
		<!-- end header -->


		<!--/*這邊是工作區開始*/ -->
		<div class="container">
			<div class="row">

				<div class="col-md-8"></div>

				<div class="col-md-3">
					<FORM action="MemberServlet" method=post>

						<h5>註冊</h5>
						<h5 style="color: red">${errorMessage}</h5>
						<div>帳號：中英文混合４到８碼</div>
						<input type="text" name="member_account" value="${member_account}"> <br>
						<div>密碼：中英文混合４到８碼</div>
						<input type="text" name="password1" value="${password1}">
						<div>再次輸入密碼</div>
						<input type="text" name="password2" value="${password2}"><br>
						<div>名稱</div>
						<input type="text" name="member_name" value="${member_name}"><br> 
						
						<input type="checkbox" name="action" value="new" checked
							style='display: none'> 
							
						<input type="submit" value="確認">
					</FORM>
				</div>

				<div class="col-md-1"></div>

			</div>
		</div>
		<!--/*這邊是工作區結束*/ -->

		<jsp:include page="Footer.jsp" />

	</div>

	<%@include file="link2.file"%>

</body>
</html>