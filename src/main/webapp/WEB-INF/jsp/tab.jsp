<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>待办信息</title>
<link rel="stylesheet" href="css/sm.css">
<link rel="stylesheet" href="css/sm-extend.css">
<script src="js/demos.js"></script>
<script src="js/zepto.js"></script>
<script src="js/config.js"></script>

</head>
<body>

	<div class="content">

		<div class="list-block media-list">
			<c:forEach var="item" items="${tabs}">
				<ul>
					<li><a href="getCheck?type=${item.type }"
						class="item-link item-content">
							<div class="item-inner">
								<div class="item-title-row">
									<div class="item-title">${item.name }</div>
									<c:if test="${item.number==0 }">
										<div class="color-gray">${item.number }</div>
									</c:if>
									<c:if test="${item.number!=0 }">
										<div class="color-warning">${item.number }</div>
									</c:if>
								</div>
							</div>
					</a></li>
				</ul>
			</c:forEach>
		</div>

	</div>
	<script src="js/sm.js"></script>
	<script src="js/sm-city-picker.js"></script>
	<script>

</script>
</body>

</html>