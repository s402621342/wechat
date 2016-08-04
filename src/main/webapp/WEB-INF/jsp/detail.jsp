<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>详细信息</title>
<link rel="stylesheet" href="css/sm.css">
<link rel="stylesheet" href="css/sm-extend.css">
<script src="js/demos.js"></script>
<script src="js/zepto.js"></script>
<script src="js/config.js"></script>

</head>

<div class="content">
	<div class="content-block">
		<div class="buttons-row">
			<a href="#tab1" class="tab-link active button">概要</a> <a href="#tab2"
				class="tab-link button">流程</a> <a href="#tab3"
				class="tab-link button">意见</a>
		</div>
	</div>
	<div class="tabs">
		<div id="tab1" class="tab active">
			<!-- 概要 -->
			<div class="content-block-title">概要</div>
			<div class="list-block">
				<ul>
					<c:forEach var="item" items="${information.outline }">
						<!-- Text inputs -->
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">${item.key }</div>
									<div class="color-gray">${item.value }</div>
								</div>
							</div>
						</li>
					</c:forEach>

				</ul>

			</div>
			<div class="content-block-title">其他信息</div>
			<div class="list-block">
				<ul>
					<c:forEach var="item" items="${information.otherInfo }">
						<!-- Text inputs -->
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">${item.key }</div>
									<div class="color-gray">${item.value }</div>
								</div>
							</div>
						</li>
					</c:forEach>

				</ul>

			</div>


			<!-- 是否有正文 -->
			<c:if test="${information.hasText}">
				<div class="content-block-title">正文</div>
				<div class="list-block media-list">
					<c:forEach var="item" items="${information.text }">
						<ul>
							<li><a href="${item.value }" class="item-link item-content">
									<div class="item-inner">
										<div class="color-gray">${item.key }</div>
									</div>
							</a></li>
						</ul>
					</c:forEach>
				</div>
			</c:if>

			<div class="content-block-title">附件</div>
			<div class="list-block media-list">
				<c:forEach var="item" items="${information.attachment }">
					<ul>
						<li><a href="${item.value }" class="item-link item-content">
								<div class="item-inner">
									<div class="color-gray">${item.key }</div>
								</div>
						</a></li>
					</ul>
				</c:forEach>
			</div>




		</div>


	<div id="tab2" class="tab">
		<!-- 流程 -->
		<div class="content-block">
				<c:forEach var="item" items="${information.procedures }">
		<div class="list-block">
					<ul>
						<!-- Text inputs -->
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">序号</div>
									<div class="color-gray">${item.number }</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">传递时间</div>
									<div class="color-gray">${item.date }</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">姓 名</div>
									<div class="color-gray">${item.name }</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">部 门</div>
									<div class="color-gray">${item.department }</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">流程操作</div>
									<div class="color-gray">${item.action }</div>
								</div>
							</div>
						</li>

					</ul>
				</div>
					</c:forEach>
		</div>
	</div>
	<div id="tab3" class="tab">
		<!-- 意见 -->
		<div class="content-block">
		<c:forEach var="view" items="${information.views }">
			<div class="content-block-title">${view.key.title }</div>
				<c:if test="${view.value.size() ==0}">
					
					<div class="color-gray">    没有${view.key.title}！</div>
				</c:if>
				<c:forEach var="item" items="${view.value }">
				<div class="list-block">
					<ul>
						<!-- Text inputs -->
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">${view.key.col1 }</div>
									<div class="color-gray">${item.name }</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">${view.key.col2 }</div>
									<div class="color-gray">${item.date }</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">${view.key.col3 }</div>
									<div class="color-gray">${item.opinion }</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">${view.key.col4 }</div>
									<div class="item-media">
										<img
											src="${item.sign }"
											width="100">
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
					</c:forEach>
					</c:forEach>
		</div>


	</div>
		</div>
	<div class="content-block">
		<c:if test="${information.canOperate }">
			<div class="row">
		 		<a href="submit?type=${information.type }&id=${information.id}" class="button button-big button-fill button-success">提交</a>
			</div>
		</c:if>
		<c:if test="${information.canOperate==false }">
			请在电脑端处理
		</c:if>
		
	</div>
</div>
<script src="js/sm.js"></script>
<script src="js/sm-extend.js"></script>
<script src="js/sm-city-picker.js"></script>
</html>