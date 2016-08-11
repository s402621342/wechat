<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>个人设置</title>
<link rel="stylesheet" href="css/sm.css">
<link rel="stylesheet" href="css/sm-extend.css">
<script src="js/demos.js"></script>
<script src="js/zepto.js"></script>
<script src="js/config.js"></script>
<script type="text/javascript">
	function logout(){
		$.ajax({
			type:"POST",
			url:"logout",
			dataType:"json",
			success:function(data){
				if(data.success=="true"){
					window.location.href="settinglogin";
				}else{
				 $.alert('注销失败');
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
		<div class="content-block">
			<ul>
				<li>欢迎您！${username }</li>
			</ul>
		</div>

		<div class="content-block">
			<div class="row">
				<input class="button button-big button-fill button-warning"
					type="button" onclick="logout()" value="注销">
			</div>
		</div>
	</div>
	<script src="js/sm.js"></script>
	<script src="js/sm-city-picker.js"></script>
	<script>

</script>
</body>

</html>