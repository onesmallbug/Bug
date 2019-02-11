<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*" import="java.util.List"
	import="com.groups.model.*" import="com.store.model.*"%>

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

				<%
					for(GroupsVO groupsVO : (List<GroupsVO>)application.getAttribute("effectGroupsList")){
						
					int index = ((List<String>)application.getAttribute("memberAccountList")).lastIndexOf(groupsVO.getMember_account());
					String member_name = ((List<String>)application.getAttribute("memberNameList")).get(index);
					
					String store_name = null;
					for(StoreVO storeVO : (List<StoreVO>)application.getAttribute("storeList")){
						if(storeVO.getStore_no().equals(groupsVO.getStore_no())){
							store_name = storeVO.getStore_name();
						}
					}
					
					%>
				<div class="col-md-4">
					<div class="card small">
						<div class="card-content">
							<FORM METHOD="post" ACTION="OrdersServlet">
								<p>團名：</p>
								<p><%=groupsVO.getGroups_name()%></p>
								<br>
								<p>截止時間：</p>
								<p><%=groupsVO.getGroups_expire()%></p>
								<br>
								<p>團主：</p>
								<p><%=member_name %></p>
								<br>
								<p>店家：</p>
								<p><%=store_name %></p>
								<br> <input type="hidden" name="action" value="joingroups">
								<input type="hidden" name="groups_no" value="<%=groupsVO.getGroups_no() %>">
								<input type="hidden" name="store_no" value="<%=groupsVO.getStore_no() %>">
								<input type="submit" value="加入">
							</FORM>
						</div>
					</div>
				</div>
				<% }%> 

			</div>
		</div>

		<!--/*這邊是工作區結束*/ -->


		<jsp:include page="Footer.jsp" />
	</div>

	<%@ include file="link2.file"%>

</body>
</html>