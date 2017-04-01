<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="decorator" content="login"/>
<title>登录</title>
</head>
<body>
	<div class="login"> 
		<form action="${pageContext.request.contextPath }/security/login" method="post" name="loginForm" id="loginForm">
			<div class="login_userid">
				用户名：<input class="username" type="text" id="username" name="username"  value='100000'/>
			</div>
			<div class="login_passwd">
				密码：
				<input class="password" type="password" id="password" name="passwd" value="111111"/>
			</div>
			<div class="loginMessage">${errMsg}</div>
			<div class="operate"><a href="javascript:login()" class="login_btn"></a></div>
		</form> 
	</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#username").focus();
});
	//登录
	function login(){
		var username = $("#username").val();
		var password = $("#password").val();
		if(username == '' || password == ''){
			 $(".loginMessage").html("不能为空");
			 return;
		}
		$("#loginForm").submit();
	}

	// 处理回车键，点击回车提交登陆信息
	document.onkeydown=function(event){ 
        e = event ? event :(window.event ? window.event : null); 
        if(e.keyCode==13){ 
            //执行的方法  
        	login();
        } 
    } 
</script>

</body>
</html>