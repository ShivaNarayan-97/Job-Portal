<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- this is used for code reusibility -->
<%@include file="all_components/all_css.jsp" %>

<style type="text/css">
	.back-img{
		background-image: linear-gradient(rgba(9, 5, 54, 0.3), rgba(5, 4, 46, 0.1)),
    url(img/background.jpg);
		width: 100%;
		height: 90vh;
		background-repeat: no-repeat;
		background-size: cover;
	}
	
	.text-center{
		display: flex;
		justify-content: center;
		align-items: center;
		text-align: center;
	}
	
	
</style>
</head>
<body>
	<%@include file="all_components/navbar.jsp" %>
	
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-4">
				<i class="fa fa-book"></i> ONLINE JOB PORTAL
			</h1>
		</div>
	</div>
	
	
	<%@include file="all_components/footer.jsp" %>
</body>
</html>