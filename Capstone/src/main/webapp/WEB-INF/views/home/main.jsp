<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&display=swap" rel="stylesheet">
<title>main page</title>
<style>
	body{
		text-align : center;
	}
	.box01{
		text-align : center;
		background-image : url("https://ipsi.kcce.or.kr/file/UNIV_LOGO/2016_73099000_1462958020861.jpg");
		background-repeat:no-repeat;
		background-position: center;
		background-size: contain;
	}
	div{
		text-align : right;
		margin-top : 8px;
		margin-right : 7px;
	}
	button{
		margin-left : 10px;
		margin-right: 10px;
		padding : 20px;
	}
	#bb{
		margin-left : 0px;
		margin-right: 0px;
		padding : 0px;
	}
	h3{
		font-family: 'Noto Serif KR', serif;
	}

</style>
</head>
<body>

<div>
<!-- 톱니바퀴 -->
<button id ="bb" type="button" style="width:20px; height:20px;"onClick="location.href='${pageContext.request.contextPath}/admin/adminLogin'">
<img src="https://cdn.iconscout.com/icon/free/png-256/gear-363-866275.png" alt=""width="15px" height="15px" style="margin-left:auto; margin-right:auto; display:block;">
</button>
</div>
<!-- 택배 아이콘 -->
<!-- 
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-truck" viewBox="0 0 16 16">
  <path d="M0 3.5A1.5 1.5 0 0 1 1.5 2h9A1.5 1.5 0 0 1 12 3.5V5h1.02a1.5 1.5 0 0 1 1.17.563l1.481 1.85a1.5 1.5 0 0 1 .329.938V10.5a1.5 1.5 0 0 1-1.5 1.5H14a2 2 0 1 1-4 0H5a2 2 0 1 1-3.998-.085A1.5 1.5 0 0 1 0 10.5v-7zm1.294 7.456A1.999 1.999 0 0 1 4.732 11h5.536a2.01 2.01 0 0 1 .732-.732V3.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5v7a.5.5 0 0 0 .294.456zM12 10a2 2 0 0 1 1.732 1h.768a.5.5 0 0 0 .5-.5V8.35a.5.5 0 0 0-.11-.312l-1.48-1.85A.5.5 0 0 0 13.02 6H12v4zm-9 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm9 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
</svg>
 -->
<!-- 사람 모양 아이콘 -->
<img src="https://cdn-icons-png.flaticon.com/512/1802/1802979.png" width="60" height="60" alt ="" style="margin-left:auto; margin-right:auto; display:block;">
<h4>자동 물품 분류 관리</h4>
<div class="box01">
<br><br><br><br><br><br><br><br><br>
<br>
<br>
<br>
<br>
<!-- 로그인 버튼 -->
<button type="button" class="btn btn-primary btn-lg" onClick="location.href='${pageContext.request.contextPath}/admin/adminLogin'">관리</button>

</div>
</body>
</html>