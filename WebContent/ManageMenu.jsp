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

		<!--/*�o��O�u�@�϶}�l*/ -->
<div class="container">
			<div class="row">

				<div class="col-md-4"></div>

				<div class="col-md-4">
					<FORM METHOD="post" ACTION="MenuServlet">
					
							<p>�s�W���</p>
						<h5 style="color: red">${errorMessage}</h5>
							<p>���W��</p>
						<input type="text" name="menu_name" value="${menu_name}"> <br>
							<p>����</p>
						<input type="text" name="menu_price" value="${menu_price}"> <br>
							
						<input type="hidden" name="action" value="newmenu">
						<input type="hidden" name="store_no" value="${store_no}">
						<input type="submit" value="�e�X">
						
					</FORM>
				</div>

				<div class="col-md-4"></div>
			</div>
		</div>

		<!--/*�o��O�u�@�ϵ���*/ -->

	</div>

	<%@ include file="link2.file"%>

</body>
</html>