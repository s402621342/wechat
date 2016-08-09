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
<script type="text/javascript">
$(function(){
	<c:forEach var="basicInfo" items="${information.basicInfo }"  varStatus="status">
	<c:forEach var="info" items="${basicInfo.value }" varStatus="sta">
		var i=${status.index}
		var j=${sta.index}
		if(i==0){						//第一项展开
			document.getElementById("b"+i+"-"+j).style.display="block";
		}else{
			document.getElementById("b"+i+"-"+j).style.display="none";
		}
	</c:forEach>
	</c:forEach>
	
	<c:forEach var="attachment" items="${information.attachment }" varStatus="status">
	<c:forEach var="info" items="${attachment.value }" varStatus="sta">
		var i=${status.index}
		var j=${sta.index}
		document.getElementById("a"+i+"-"+j).style.display="none";
	</c:forEach>
	</c:forEach>
	
	<c:forEach var="otherInfo" items="${information.otherInfo }" varStatus="status">
	<c:forEach var="inf" items="${otherInfo.value }"  varStatus="sta">
		var i=${status.index}
		var j=${sta.index}
		document.getElementById("o"+i+"-"+j).style.display="none";
	</c:forEach>
	</c:forEach>
	
	
});

function disBasic(index){
	<c:forEach var="basicInfo" items="${information.basicInfo }"  varStatus="status">
	<c:forEach var="info" items="${basicInfo.value }" varStatus="sta">
		var i=${status.index}
		if(index==i){
			var j=${sta.index}
		if(document.getElementById("b"+i+"-"+j).style.display=="block"){
			document.getElementById("b"+i+"-"+j).style.display="none";
		}else if(document.getElementById("b"+i+"-"+j).style.display=="none"){
			document.getElementById("b"+i+"-"+j).style.display="block";
		}
		}
	</c:forEach>
	</c:forEach>
}

function disAttach(index){
	<c:forEach var="attachment" items="${information.attachment }" varStatus="status">
	<c:forEach var="info" items="${attachment.value }" varStatus="sta">
		var i=${status.index}
		if(index==i){
			var j=${sta.index}
		if(document.getElementById("a"+i+"-"+j).style.display=="block"){
			document.getElementById("a"+i+"-"+j).style.display="none";
		}else if(document.getElementById("a"+i+"-"+j).style.display=="none"){
			document.getElementById("a"+i+"-"+j).style.display="block";
		}
		}
	</c:forEach>
	</c:forEach>
}

function disOther(index){
	<c:forEach var="otherInfo" items="${information.otherInfo }" varStatus="status">
	<c:forEach var="inf" items="${otherInfo.value }"  varStatus="sta">
		var i=${status.index}
		if(index==i){
			var j=${sta.index}
		if(document.getElementById("o"+i+"-"+j).style.display=="block"){
			document.getElementById("o"+i+"-"+j).style.display="none";
		}else if(document.getElementById("o"+i+"-"+j).style.display=="none"){
			document.getElementById("o"+i+"-"+j).style.display="block";
		}
		}
	</c:forEach>
	</c:forEach>
}

</script>
</head>

<div class="content">
	<c:forEach var="basicInfo" items="${information.basicInfo }"  varStatus="status">
		<div class="list-block">
			<ul>
				<li>
					<div class="item-content">
						<div class="item-inner" onclick="disBasic(${status.index})">
							<h3 class="item-title label">${basicInfo.key }</h3>
							<div class="item-input"></div>
						</div>
					</div>

				</li>
				<c:forEach var="info" items="${basicInfo.value }" varStatus="sta">
					<li id="b${status.index }-${sta.index}">
						<div class="item-content">
							<div class="item-inner">
								<div class="item-title label">${info.key }</div>
								<div class="color-gray">${info.value }</div>
							</div>
						</div>

					</li>
				</c:forEach>
			</ul>
		</div>

	</c:forEach>

	<c:forEach var="attachment" items="${information.attachment }" varStatus="status">
		<div class="list-block media-list">
			<ul>
				<li>
					<div class="item-content">
						<div class="item-inner" onclick="disAttach(${status.index})">
							<h3 class="item-title label">${attachment.key }</h3>
							<div class="item-input"></div>
						</div>
					</div>

				</li>
				<c:forEach var="info" items="${attachment.value }" varStatus="sta">
					<li id="a${status.index }-${sta.index}">
					<a href="${info.value }" class="item-link item-content">
							<div class="item-inner">
								<div class="color-gray">${info.key }</div>
							</div>
					</a></li>
				</c:forEach>
			</ul>
		</div>

	</c:forEach>

	<c:forEach var="otherInfo" items="${information.otherInfo }" varStatus="status">
		<div class="list-block">
			<ul>
				<li>
					<div class="item-content">
						<div class="item-inner" onclick="disOther(${status.index})">
							<h3 class="item-title label">${otherInfo.key }</h3>
						</div>
					</div>

				</li>
			</ul>
		</div>
		<c:forEach var="inf" items="${otherInfo.value }"  varStatus="sta">
			<div class="list-block" >
				<ul id="o${status.index }-${sta.index}">
					<c:forEach var="in" items="${inf.info }">
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">${in.key }</div>
									<c:forEach var="i" items="${in.value }">
										<c:if test="${i.value }">
											<div class="item-media">
												<img src="${i.key }" width="100">
											</div>
										</c:if>
										<c:if test="${i.value==false }">
											<div class="color-gray">${i.key }</div>
										</c:if>

									</c:forEach>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>


	</c:forEach>
	<br>
</div>

<nav class="bar bar-tab">
	<c:if test="${information.canOperate }">
		<a href="submit?type=${information.type }&id=${information.id}"
			class="button button-big button-fill button-success">提交</a>
	</c:if>
	<c:if test="${information.canOperate==false }">
	<div class="color-gray">请在电脑端处理</div>
			
		</c:if>
</nav>
<script src="js/sm.js"></script>
<script src="js/sm-extend.js"></script>
<script src="js/sm-city-picker.js"></script>
</html>