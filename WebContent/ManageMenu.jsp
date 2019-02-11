<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
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

		<!--/*這邊是工作區開始*/ -->
<div class="container">
			<div class="row">

				<div class="col-md-4"></div>

				<div class="col-md-4">
					<FORM METHOD="post" ACTION="MenuServlet">
					
							<p>新增菜單</p>
						<h5 style="color: red">${errorMessage}</h5>
							<p>菜單名稱</p>
						<input type="text" name="menu_name" value="${menu_name}"> <br>
							<p>價格</p>
						<input type="text" name="menu_price" value="${menu_price}"> <br>
							
						<input type="hidden" name="action" value="newmenu">
						<input type="hidden" name="store_no" value="${store_no}">
						<input type="submit" value="送出">
						
					</FORM>
				</div>

				<div class="col-md-4"></div>
			</div>
		</div>

		<!--/*這邊是工作區結束*/ -->

	</div>

	<%@ include file="link2.file"%>

</body>
</html>