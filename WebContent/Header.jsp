<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="BIG5">
<title>Home</title>

<style>
header{
position:fixed;
z-index:999;

}


</style>

 
</head>
<body>
		<!-- start header -->
		<header id="wrapper" class="home-page">
			<div class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.jsp"><img
							src='img/logo.png' width=40 height=40>BandonCome</a>
					</div>
					<div class="navbar-collapse collapse ">
						<ul class="nav navbar-nav">
							<!-- /*-------------------------�H�U�������-------------------------*/ -->
							<li class="active"><a class="waves-effect waves-dark"
								href="index.jsp">����</a></li>
							<!-- /*-------------------------�H�W�������-------------------------*/ -->
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle waves-effect waves-dark">����ڭ�<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="waves-effect waves-dark" href="about.html">���ݭn</a></li>
									<li><a class="waves-effect waves-dark" href="#">���ݭn</a></li>
									<li><a class="waves-effect waves-dark" href="#">���ݭn</a></li>
									<li><a class="waves-effect waves-dark" href="#">���ݭn</a></li>
								</ul></li>
							<!-- /*-------------------------�H�W����ڭ̿��-------------------------*/ -->
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle waves-effect waves-dark">����<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="waves-effect waves-dark"
										href="GroupsServlet">�s������</a></li>
									<li><a class="waves-effect waves-dark" href="#">�o�_����</a></li>
								</ul></li>
							<!-- /*-------------------------�H�W���ο��-------------------------*/ -->
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle waves-effect waves-dark">���<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="waves-effect waves-dark"
										href="readStore.jsp">�s�����</a></li>
									<li><a class="waves-effect waves-dark"
										href="ManageStore.jsp">�޲z���a</a></li>
									<li><a class="waves-effect waves-dark"
										href="SelectStoreToManageMenu.jsp">�޲z���</a></li>
								</ul></li>

							<!-- /*-------------------------�H�W���a�B�����-------------------------*/ -->
							<c:choose>

								<c:when test="${empty member_account}">
									<li><a class="waves-effect waves-dark" href="Register.jsp">���U</a></li>
									<li><a class="waves-effect waves-dark" href="SignIn.jsp">�n�J</a></li>
								</c:when>
								<c:when test="${not empty member_account}">
									<li><a class="waves-effect waves-dark"
										href="MemberServlet">${member_name}</a></li>
									<li><a class="waves-effect waves-dark"
										href="MemberServlet">�n�X</a></li>
								</c:when>
								<c:otherwise>

								</c:otherwise>
							</c:choose>
							<!-- /*-------------------------�H�W�|�����-------------------------*/ -->
						</ul>
					</div>
				</div>
			</div>
		</header>
		<!-- end header -->
	<div class="navbar navbar-static-top" style="z-index:998;">
	</div>


</body>
</html>