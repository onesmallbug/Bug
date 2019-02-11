<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="BIG5">
<title>登入</title>

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
                        <h5 style="color: red">${errorMessage}</h5>
						<div>帳號</div>
						<input type="text" name="member_account" value="${member_account}"> <br>
						<div>密碼</div>
						<input type="text" name="member_password"> 
						<input type="checkbox" name="action" value="signin" checked style='display: none'> 
						<input type="submit" value="確認">

					</FORM>
				</div>

				<div class="col-md-1"></div>
			</div>
		</div>

		<!--/*這邊是工作區結束*/ -->


		<jsp:include page="Footer.jsp" />
	</div>

	<%@ include file="link2.file"%>

</body>
</html>