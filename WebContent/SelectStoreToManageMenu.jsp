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
		<!-- start header -->
		<jsp:include page="Header.jsp" />
		<!-- end header -->


		<!--/*�o��O�u�@�϶}�l*/ -->
<div class="container">
			<div class="row">

				<div class="col-md-4"></div>

				<div class="col-md-4">
					<FORM METHOD="post" ACTION="MenuServlet">
					
						<b>����\�U:</b><br> <select class="waves-effect waves-dark" size="1"
							name="store_no">

							<c:forEach var="storeVO" items="${storeList}">
								<option class="waves-effect waves-dark" value="${storeVO.store_no}">${storeVO.store_name}</option>
							</c:forEach>

						</select> <br> <input type="hidden" name="action" value="managemenu">
						<input type="submit" value="�e�X">
					</FORM>
				</div>

				<div class="col-md-4"></div>
			</div>
		</div>
<c:if test="${not empty store_no}">
		<jsp:include page="ManageMenu.jsp" />
</c:if>
		<!--/*�o��O�u�@�ϵ���*/ -->


		<jsp:include page="Footer.jsp" />
	</div>

	<%@ include file="link2.file"%>

</body>
</html>