<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="BIG5">
<title>Home</title>

<%@ include file="link1.file" %>

</head>
<body>
	<div id="wrapper" class="home-page">
		<!-- start header -->
		
		<jsp:include page="Header.jsp" />
		
		<section id="banner">

			<!-- Slider -->
			<div id="main-slider" class="flexslider">
				<ul class="slides">
					<li><img src="img/slides/1.jpg" alt="" />
						<div class="flex-caption">
							<h3>一起來訂便當，吧啦888!</h3>
							<p>用我爛爛的訂便當系統</p>

						</div></li>
					<li><img src="img/slides/2.jpg" alt="" />
						<div class="flex-caption">
							<h3>一起來訂便當，吧啦888!</h3>
							<p>用我爛爛的訂便當系統</p>

						</div></li>
				</ul>
			</div>
			<!-- end slider -->
		</section>
		<section class="dishes">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aligncenter">
							<h2 class="aligncenter">下面的都看起來很好吃</h2>
							但是這邊都沒有賣，嘿嘿
						</div>
						<br />
					</div>
				</div>

				<div class="row service-v1 margin-bottom-40">
					<div class="col-md-4 md-margin-bottom-40">
						<div class="card small">
							<div class="card-image">
								<img class="img-responsive" src="img/service1.jpg" alt="">
								<span class="card-title">我不知道這是什麼菜</span>
							</div>
							<div class="card-content">
								<p>好多假文，我修的好累</p>
								<p>好多假文，我修的好累</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 md-margin-bottom-40">
						<div class="card small">
							<div class="card-image">
								<img class="img-responsive" src="img/service2.jpg" alt="">
								<span class="card-title">我不知道這是什麼菜，但是肉看起來很好吃</span>
							</div>
							<div class="card-content">
								<p>好多假文，我修的好累</p>
								<p>好多假文，我修的好累</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 md-margin-bottom-40">
						<div class="card small">
							<div class="card-image">
								<img class="img-responsive" src="img/service3.jpg" alt="">
								<span class="card-title">這一道我沒啥興趣</span>
							</div>
							<div class="card-content">
								<p>好多假文，我修的好累</p>
								<p>好多假文，我修的好累</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<jsp:include page="Footer.jsp" />

	</div>
	
	<%@ include file="link2.file" %>
	
</body>
</html>