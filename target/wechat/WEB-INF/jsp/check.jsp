<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>我的审批</title>
<link rel="stylesheet" href="css/sm.css">
<link rel="stylesheet" href="css/sm-extend.css">
<script src="js/demos.js"></script>
<script src="js/zepto.js"></script>
<script src="js/config.js"></script>

</head>
<body>

	<div class="content">
		<div class="buttons-tab">
			<a href="#tab1" class="tab-link active button">审批中</a> 
			<a href="#tab2" class="tab-link button">已审批</a> 
			<a href="#tab3" class="tab-link button">已驳回</a>
		</div>
		<div class="tabs">
			<div id="tab1" class="tab active">
				<div class="content-block">
				<c:forEach var="item" items="${outlines}">
					<div class="list-block media-list">
						<ul>
							<li><a href="detail?id=${item.id }&type=${item.type}"
								class="item-link item-content">
									<div class="item-inner">
										<div class="item-title-row">
											<div class="item-title">${item.title }</div>
											
										</div>
										<div class="item-title-row">
											<div class="item-subtitle">${item.autor }</div>
										</div>
										<div class="item-title-row">
											<div class="item-subtitle">${item.state }</div>
											<div class="item-after">${item.date }</div>
										</div>
									</div>
							</a></li>
						</ul>
					</div>
				</c:forEach>

				</div>
			</div>
			<div id="tab2" class="tab">
				<div class="content-block"></div>
			</div>
			<div id="tab3" class="tab">
				<div class="content-block"></div>
			</div>
		</div>
	</div>
	<script src="js/sm.js"></script>
	<script src="js/sm-city-picker.js"></script>
	<script>

</script>
</body>

</html>