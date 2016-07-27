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

</head>
<body>
	<div class="content">
		 <form method="post" action="checklogin">
		 <div class="list-block">
    <ul>
      <!-- Text inputs -->
      <li>
        <div class="item-content">
          <div class="item-media"><i class="icon icon-form-name"></i></div>
          <div class="item-inner">
            <div class="item-title label">用户名</div>
            <div class="item-input">
              <input type="text" placeholder="Your name" name="username"/>
            </div>
          </div>
        </div>
      </li>
      <li>
        <div class="item-content">
          <div class="item-media"><i class="icon icon-form-password"></i></div>
          <div class="item-inner">
            <div class="item-title label">密码</div>
            <div class="item-input">
              <input type="password" placeholder="Password" name="password" />
            </div>
          </div>
        </div>
      </li>
      </ul>
      </div>
<div class="content-block">
			<div class="row">
					<input class="button button-big button-fill button-success" type="submit" value="登录">
			</div>
		</div>     
      </form>
	</div>
	<script src="js/sm.js"></script>
	<script src="js/sm-city-picker.js"></script>
	<script>

</script>
</body>

</html>