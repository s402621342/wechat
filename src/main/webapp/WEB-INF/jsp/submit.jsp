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
		try{
		document.getElementById("nextuser"+i).style.display="none";
		}catch(e){}	
		
	}
	<c:forEach var="item" items="${operations}" varStatus="status">
	if("${item.options.length()}">2){
	  $("#picker${status.index}").picker({
	    	
	        toolbarTemplate: '<header class="bar bar-nav">\
	          <button class="button button-link pull-left">\
	        按钮\
	        </button>\
	        <button class="button button-link pull-right close-picker">\
	        确定\
	        </button>\
	        <h1 class="title">标题</h1>\
	        </header>',
	        cols: [
	          {
	            textAlign: 'center',
	            values: ${item.options},
	            cssClass: 'picker-items-col-normal'
	          }
	        ]
	      });
	}
	</c:forEach>
});
function dis(obj)
{
	var length=${operations.size()};
	for(var i=0;i<length;i++){
		try{
		if (obj.checked){
			document.getElementById("nextuser"+i).style.display="block";
			for(var j=0;j<length;j++){
				var temp=document.getElementById("checkbox"+j);
				if(temp!=obj){
					temp.checked=false;
					document.getElementById("nextuser"+j).style.display="none";
				}
			}
		}
		else {
			document.getElementById("nextuser"+i).style.display="none";
		}
		}catch(e){
			
		}
	}
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
								<div class="item-input">
									<label class="label-switch">
						                <input type="checkbox" id="checkbox${status.index }" onclick="dis(this)">
						                <div class="checkbox"></div>
						              </label>
								</div>
							</div>
						</div>

					</li>
					</c:if>
					<li>
					<c:if test="${ item.options.length()>2}">
						<div class="item-content" id="nextuser${status.index }" >
							<div class="item-inner">
								<div class="item-title label">下一环节处理人</div>
								<div class="item-input">
									<input type="text" id='picker${status.index }' readonly />
								</div>
							</div>
						</div>
					</c:if>

					</li>


					<!-- Text inputs -->
					<c:if test="${item.fieldapproval }">
					<li>

						<div class="item-content">
							<div class="item-inner">
								<div class="item-title label">审批意见</div>
								<div class="item-input">
									<textarea></textarea>
								</div>
							</div>
						</div>
					</li>
					</c:if>
				</ul>
			</div>
		</c:forEach>
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