<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.store.model.StoreVO" import="java.util.ArrayList"%>

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
					<FORM METHOD="post" ACTION="MenuServlet">
						<b>選擇餐廳:</b><br> 
						<select class="waves-effect waves-dark" size="1" name="store_no">

							<c:forEach var="storeVO" items="${storeList}">
								<option value="${storeVO.store_no}">${storeVO.store_name}</option>
							</c:forEach>

						</select> 
						<br> <input type="hidden" name="action" value="readMenu">
						<input type="submit" value="送出">
					</FORM>
				</div>

				<div class="col-md-4"></div>
			</div>
		</div>

		<jsp:include page="readMenu.jsp" />
		<!--/*這邊是工作區結束*/ -->


		<jsp:include page="Footer.jsp" />
	</div>

	<%@ include file="link2.file"%>

</body>
</html>