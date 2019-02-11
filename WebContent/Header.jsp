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
							<!-- /*-------------------------以下首頁選單-------------------------*/ -->
							<li class="active"><a class="waves-effect waves-dark"
								href="index.jsp">首頁</a></li>
							<!-- /*-------------------------以上首頁選單-------------------------*/ -->
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle waves-effect waves-dark">關於我們<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="waves-effect waves-dark" href="about.html">不需要</a></li>
									<li><a class="waves-effect waves-dark" href="#">不需要</a></li>
									<li><a class="waves-effect waves-dark" href="#">不需要</a></li>
									<li><a class="waves-effect waves-dark" href="#">不需要</a></li>
								</ul></li>
							<!-- /*-------------------------以上關於我們選單-------------------------*/ -->
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle waves-effect waves-dark">揪團<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="waves-effect waves-dark"
										href="GroupsServlet">瀏覽揪團</a></li>
									<li><a class="waves-effect waves-dark" href="#">發起揪團</a></li>
								</ul></li>
							<!-- /*-------------------------以上揪團選單-------------------------*/ -->
							<li class="dropdown"><a href="#" data-toggle="dropdown"
								class="dropdown-toggle waves-effect waves-dark">菜單<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="waves-effect waves-dark"
										href="readStore.jsp">瀏覽菜單</a></li>
									<li><a class="waves-effect waves-dark"
										href="ManageStore.jsp">管理店家</a></li>
									<li><a class="waves-effect waves-dark"
										href="SelectStoreToManageMenu.jsp">管理菜單</a></li>
								</ul></li>

							<!-- /*-------------------------以上店家、菜單選單-------------------------*/ -->
							<c:choose>

								<c:when test="${empty member_account}">
									<li><a class="waves-effect waves-dark" href="Register.jsp">註冊</a></li>
									<li><a class="waves-effect waves-dark" href="SignIn.jsp">登入</a></li>
								</c:when>
								<c:when test="${not empty member_account}">
									<li><a class="waves-effect waves-dark"
										href="MemberServlet">${member_name}</a></li>
									<li><a class="waves-effect waves-dark"
										href="MemberServlet">登出</a></li>
								</c:when>
								<c:otherwise>

								</c:otherwise>
							</c:choose>
							<!-- /*-------------------------以上會員選單-------------------------*/ -->
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