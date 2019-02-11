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
							<h3>�@�_�ӭq�K��A�a��888!</h3>
							<p>�Χ����ꪺ�q�K��t��</p>

						</div></li>
					<li><img src="img/slides/2.jpg" alt="" />
						<div class="flex-caption">
							<h3>�@�_�ӭq�K��A�a��888!</h3>
							<p>�Χ����ꪺ�q�K��t��</p>

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
							<h2 class="aligncenter">�U�������ݰ_�ӫܦn�Y</h2>
							���O�o�䳣�S����A�K�K
						</div>
						<br />
					</div>
				</div>

				<div class="row service-v1 margin-bottom-40">
					<div class="col-md-4 md-margin-bottom-40">
						<div class="card small">
							<div class="card-image">
								<img class="img-responsive" src="img/service1.jpg" alt="">
								<span class="card-title">�ڤ����D�o�O�����</span>
							</div>
							<div class="card-content">
								<p>�n�h����A�ڭת��n��</p>
								<p>�n�h����A�ڭת��n��</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 md-margin-bottom-40">
						<div class="card small">
							<div class="card-image">
								<img class="img-responsive" src="img/service2.jpg" alt="">
								<span class="card-title">�ڤ����D�o�O�����A���O�׬ݰ_�ӫܦn�Y</span>
							</div>
							<div class="card-content">
								<p>�n�h����A�ڭת��n��</p>
								<p>�n�h����A�ڭת��n��</p>
							</div>
						</div>
					</div>
					<div class="col-md-4 md-margin-bottom-40">
						<div class="card small">
							<div class="card-image">
								<img class="img-responsive" src="img/service3.jpg" alt="">
								<span class="card-title">�o�@�D�ڨSԣ����</span>
							</div>
							<div class="card-content">
								<p>�n�h����A�ڭת��n��</p>
								<p>�n�h����A�ڭת��n��</p>
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