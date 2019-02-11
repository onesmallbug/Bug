<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="BIG5">
<title>Home</title>

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

				<div class="col-md-4"></div>

				<div class="col-md-4">
					<FORM METHOD="post" ACTION="StoreServlet">
					
							<p>新增店家</p>
						<h5 style="color: red">${errorMessage}</h5>
							<p>店家名稱</p>
						<input type="text" name="store_name" value="${store_name}"> <br>
							<p>店家電話</p>
						<input type="text" name="store_phone" value="${store_phone}"> <br>
							<p>店家地址</p>
						<input type="text" name="store_address" value="${store_address}"> <br>
							<p>店家敘述</p>
						<input type="text" name="store_other" value="${store_other}"> <br>
						<input type="hidden" name="action" value="newStore">
						<input type="submit" value="送出">
						
					</FORM>
				</div>

				<div class="col-md-4"></div>
			</div>
		</div>

		<!--/*這邊是工作區結束*/ -->


		<jsp:include page="Footer.jsp" />
	</div>

	<%@ include file="link2.file"%>

</body>
</html>