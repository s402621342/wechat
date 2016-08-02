<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>提交</title>
<link rel="stylesheet" href="css/sm.css">
<link rel="stylesheet" href="css/sm-extend.css">
<script src="js/demos.js"></script>
<script src="js/zepto.js"></script>
<script src="js/config.js"></script>
<script type="text/javascript">
$(function(){
	var length=${operations.size()};
	for(var i=0;i<length;i++){
		hide(i);
		
		
	}
	hideUser();
	
	
});
function next(i){
	document.getElementById("value"+i).innerHTML ="";
}


function dis(i)
{
	var obj=document.getElementById("checkbox"+i);
	var length=${operations.size()};
	for(var i=0;i<length;i++){
		try{
		if (!obj.checked){
			display(i);
			for(var j=0;j<length;j++){
				var temp=document.getElementById("checkbox"+j);
				if(temp!=obj){
					temp.checked=false;
					hide(j);
				}
			}
		}
		else {
			hide(i);
		}
		}catch(e){
			
		}
	}
}
function hide(i){
	try{
	document.getElementById("nextuser"+i).style.display="none";
	hideoptions(i);
	}catch(e){
		
	}
	try{
		document.getElementById("fieldapproval"+i).style.display="none";
	}catch(e){
	}
}

function display(i){
	try{
		document.getElementById("nextuser"+i).style.display="block";
	}catch(e){
			
	}
	try{
		document.getElementById("fieldapproval"+i).style.display="block";
	}catch(e){
	}
}
function hideoptions(i){
	try{
		<c:forEach var="item" items="${operations }" varStatus="status">
		var number=${status.index}
		if(i==number){
			var j;
			var length=${ item.options.size()};
			for(j=0;j<length;j++){
				document.getElementById("c"+i+"-"+j).style.display="none";
			}
		}
		</c:forEach>
		
	}catch(e){}
}

function displayoptions(i){
	try{
		<c:forEach var="item" items="${operations }" varStatus="status">
		var number=${status.index}
		if(i==number){
			var j;
			var length=${ item.options.size()};
			for(j=0;j<length;j++){
				if(document.getElementById("c"+i+"-"+j).style.display=="block"){
					document.getElementById("c"+i+"-"+j).style.display="none";
				}else if(document.getElementById("c"+i+"-"+j).style.display=="none"){
					document.getElementById("c"+i+"-"+j).style.display="block";
				}
			}
		}
		</c:forEach>
		
	}catch(e){}
	
	
}

function select(){
	 $.popup(".popup-services");
}


function hideUser(){
	try{
		<c:forEach var="item" items="${departments }" varStatus="status">
		var i=${status.index};
			var j;
			var length=${ item.usernames.size()};
			for(j=0;j<length;j++){
					document.getElementById("d"+i+"-"+j).style.display="none";
			}
		</c:forEach>
		
	}catch(e){}
}


function disUser(i){
	try{
		<c:forEach var="item" items="${departments }" varStatus="status">
		var number=${status.index}
		if(i==number){
			var j;
			var length=${ item.usernames.size()};
			for(j=0;j<length;j++){
				if(document.getElementById("d"+i+"-"+j).style.display=="block"){
					document.getElementById("d"+i+"-"+j).style.display="none";
				}else if(document.getElementById("d"+i+"-"+j).style.display=="none"){
					document.getElementById("d"+i+"-"+j).style.display="block";
				}
			}
		}
		</c:forEach>
		
	}catch(e){}
	
}
function closePop(){
	$.closeModal(".popup-services");
	
}


</script>
</head>
<body>

	<div class="content">
		<c:forEach var="item" items="${operations }" varStatus="status">
			<div class="list-block">
				<ul>
					<c:if test="${item.actionname.length()>=0 }">
						<li>
							<div class="item-content">
								<div class="item-inner">
									<div class="item-title label">${item.actionname }</div>
									<div class="item-input" onclick="dis(${status.index})">
										<label class="label-switch"> <input type="checkbox"
											id="checkbox${status.index }">
											<div class="checkbox"></div>
										</label>
									</div>
								</div>
							</div>

						</li>
						<!-- Text inputs -->
						<c:if test="${item.fieldapproval }">
							<li>

								<div class="item-content" id="fieldapproval${status.index }">
									<div class="item-inner">
										<div class="item-title label">审批意见</div>
										<div class="item-input">
											<textarea></textarea>
										</div>
									</div>
								</div>
							</li>
						</c:if>
					</c:if>
					<c:if test="${ item.hasOptions}">
						<c:if test="${item.options.size()>0 }">
							<li>
								<div class="item-content item-link"
									id="nextuser${status.index }">
									<div class="item-inner"
										onclick="displayoptions(${status.index})">
										<div class="item-title">下一环节处理人</div>
										<div class="item-after"></div>
									</div>
								</div>
							</li>
							<c:forEach var="name" items="${item.options }" varStatus="sta">
								<li id="c${status.index }-${sta.index}"><label
									class="label-checkbox item-content"> <c:if
											test="${item.multi==false}">
											<input type="radio" name="radio">
										</c:if> <c:if test="${item.multi==true}">
											<input type="checkbox" name="checkbox">
										</c:if>
										<div class="item-media">
											<i class="icon icon-form-checkbox"></i>
										</div>
										<div class="item-inner">
											<div class="item-title-row">
												<div class="item-title">${name }</div>
											</div>
										</div>
								</label></li>
							</c:forEach>
						</c:if>
						<!-- 自选 -->
						<c:if test="${item.options.size()==0 }">
							<li>
								<div class="item-content item-link"
									id="nextuser${status.index }" onclick="select()">
									<div class="item-inner">
										<div class="item-title">下一环节处理人</div>
										<div class="item-after"></div>
									</div>
								</div>
							</li>
						</c:if>
					</c:if>



				</ul>
			</div>
		</c:forEach>
		<div class="popup popup-services">
			<div class="content-block" id="popup">
				<c:forEach var="item" items="${departments }" varStatus="status">
					<div class="list-block">
						<ul>
							<li>
								<div class="item-content item-link" onclick="disUser(${status.index})">
									<div class="item-inner">
										<div class="item-title">${item.name }</div>
										<div class="item-after"></div>
									</div>
								</div>
							</li>
							<c:forEach var="username" items="${item.usernames }" varStatus="sta">
								<li id="d${status.index }-${sta.index}"><label class="label-checkbox item-content"> <input
										type="checkbox" name="checkbox">
										<div class="item-media">
											<i class="icon icon-form-checkbox"></i>
										</div>
										<div class="item-inner">
											<div class="item-title-row">
												<div class="item-title">${username }</div>
											</div>
										</div>
								</label></li>
							</c:forEach>
						</ul>
					</div>
				</c:forEach>
				<a onclick="closePop()">確認</a>
			</div>
		</div>
		<div class="content-block">
			<div class="row">
				<a href="#" class="button button-big button-fill button-success">确定</a>
			</div>
		</div>
	</div>
	<script src="js/sm.js"></script>
	<script src="js/sm-city-picker.js"></script>
	<script type="text/javascript">

</script>
</body>

</html>