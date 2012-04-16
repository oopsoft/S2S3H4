<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/json.js"></script>
<title>Json Test</title>
</head>
<body>

	<input id="getMessage" type="button" value="获取单个值" /> &nbsp;&nbsp;
	<input id="getUserInfo" type="button" value="获取UserInfo对象" />
	&nbsp;&nbsp;
	<input id="getList" type="button" value="获取List对象" /> &nbsp;&nbsp;
	<input id="getMap" type="button" value="获取Map对象" /> &nbsp;&nbsp;
	<br>
	<br>
	<br>
	<!-- 要显示信息的层 -->
	<div id="message"></div>
	<form>
		用户ID： <input name="userInfo.userId" type="text" /> <br /> 用户名： <input
			name="userInfo.userName" type="text" /> <br />
		密&nbsp;&nbsp;&nbsp;码： <input name="userInfo.password" type="text" />
		<br> <input id="regRe" type="button" value="注册" />
	</form>

</body>
</html>