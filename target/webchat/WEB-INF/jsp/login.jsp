<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>登录</title>
<link rel="stylesheet" href="css/sm.css">
<link rel="stylesheet" href="css/sm-extend.css">
<script src="js/demos.js"></script>
<script src="js/zepto.js"></script>
<script src="js/config.js"></script>
<script type="text/javascript">
	function checkUser(){
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		$.ajax({
			type:"POST",
			url:"checklogin",
			data:{
				"username": username,
				"password": password
			},
			dataType:"json",
			success:function(data){
				if(data.success=="true"){
					window.location.href="getCheck";
				}else{
				 $.alert('用户名或密码错误');
				}
			},
			error:function(data){
			
			}
		})
		
	}

</script>
</head>
<body>
	<div class="content">
			<div class="list-block">
				<ul>
					<!-- Text inputs -->
					<li>
						<div class="item-content">
							<div class="item-media">
								<i class="icon icon-form-name"></i>
							</div>
							<div class="item-inner">
								<div class="item-title label">用户名</div>
								<div class="item-input">
									<input type="text" placeholder="Your name" id="username" />
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="item-content">
							<div class="item-media">
								<i class="icon icon-form-password"></i>
							</div>
							<div class="item-inner">
								<div class="item-title label">密码</div>
								<div class="item-input">
									<input type="password" placeholder="Password" id="password" />
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="content-block">
				<div class="row">
					<input class="button button-big button-fill button-success" type="button" onclick="checkUser()" value="登录">
				</div>
			</div>
	</div>
	<script src="js/sm.js"></script>
	<script src="js/sm-city-picker.js"></script>
	<script>

</script>
</body>

</html>