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


		<!--/*�o��O�u�@�϶}�l*/ -->

		<div class="container">
			<div class="row">

				<div class="col-md-4"></div>

				<div class="col-md-4">
					<FORM METHOD="post" ACTION="StoreServlet">
					
							<p>�s�W���a</p>
						<h5 style="color: red">${errorMessage}</h5>
							<p>���a�W��</p>
						<input type="text" name="store_name" value="${store_name}"> <br>
							<p>���a�q��</p>
						<input type="text" name="store_phone" value="${store_phone}"> <br>
							<p>���a�a�}</p>
						<input type="text" name="store_address" value="${store_address}"> <br>
							<p>���a�ԭz</p>
						<input type="text" name="store_other" value="${store_other}"> <br>
						<input type="hidden" name="action" value="newStore">
						<input type="submit" value="�e�X">
						
					</FORM>
				</div>

				<div class="col-md-4"></div>
			</div>
		</div>

		<!--/*�o��O�u�@�ϵ���*/ -->


		<jsp:include page="Footer.jsp" />
	</div>

	<%@ include file="link2.file"%>

</body>
</html>