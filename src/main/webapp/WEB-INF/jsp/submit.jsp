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
		document.getElementById("origin"+i).style.display="block";
		document.getElementById("close").style.display="none";
		try{
			document.getElementById("popup"+i).style.display="none";
		}catch(e){}
		
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
		displayoptions(i);
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
			
			if(length==0&&"${item.hasOptions}"){
				try{
				for(j=0;j<100;j++){							//100为最大审批人数
					document.getElementById("c"+i+"-"+j).style.display="none";
				}
				}catch(e){
				}
			
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
			if(length==0&&"${item.hasOptions}"){
				try{
				for(j=0;j<100;j++){							//100为最大审批人数
					if(document.getElementById("c"+i+"-"+j).style.display=="block"){
						document.getElementById("c"+i+"-"+j).style.display="none";
					}else if(document.getElementById("c"+i+"-"+j).style.display=="none"){
						document.getElementById("c"+i+"-"+j).style.display="block";
					}
				}
				}catch(e){
				}
			
			}
		}
		</c:forEach>
		
	}catch(e){}
	
	
}

function select(i){
	var length=${operations.size()};
	for(var j=0;j<length;j++){
		document.getElementById("origin"+j).style.display="none";
	}
	document.getElementById("button").style.display="none";
	document.getElementById("popup"+i).style.display="block";
	document.getElementById("close").style.display="block";
}


function hideUser(){
		<c:forEach var="operation" items="${operations }" varStatus="s">
	try{
		<c:forEach var="item" items="${departments }" varStatus="status">
		var s=${s.index};
		var i=${status.index};
			var j;
			var length=${ item.usernames.size()};
			for(j=0;j<length;j++){
					document.getElementById("d"+s+"-"+i+"-"+j).style.display="none";
			}
		</c:forEach>
	}catch(e){}
		</c:forEach>
}


function disUser(s,i){
	try{
		<c:forEach var="item" items="${departments }" varStatus="status">
		var number=${status.index};
		if(i==number){
			var j;
			var length=${ item.usernames.size()};
			for(j=0;j<length;j++){
				if(document.getElementById("d"+s+"-"+i+"-"+j).style.display=="block"){
					document.getElementById("d"+s+"-"+i+"-"+j).style.display="none";
				}else if(document.getElementById("d"+s+"-"+i+"-"+j).style.display=="none"){
					document.getElementById("d"+s+"-"+i+"-"+j).style.display="block";
				}
			}
		}
		</c:forEach>
		
	}catch(e){}
	
}
function cancelPop(){
	var s=0;
	var length=${operations.size()};
	for(var j=0;j<length;j++){
		document.getElementById("origin"+j).style.display="block";
		try{
		if(	document.getElementById("popup"+j).style.display=="block"){
			s=j;
		}
		}catch(e){}
		
	}
	document.getElementById("button").style.display="block";
	document.getElementById("popup"+s).style.display="none";
	document.getElementById("close").style.display="none";
}

function closePop(){
	var s=0;
	var length=${operations.size()};
	for(var j=0;j<length;j++){
		document.getElementById("origin"+j).style.display="block";
		try{
		if(	document.getElementById("popup"+j).style.display=="block"){
			s=j;
		}
		}catch(e){}
		
	}
	document.getElementById("button").style.display="block";
	document.getElementById("popup"+s).style.display="none";
	document.getElementById("close").style.display="none";
	var names=new Array();
	try{
		<c:forEach var="item" items="${departments }" varStatus="status">
		var i=${status.index};
			var j;
			var length=${ item.usernames.size()};
			for(j=0;j<length;j++){
					if(document.getElementById("s"+s+"-"+i+"-"+j).checked){
						names.push(document.getElementById("name"+s+"-"+i+"-"+j).innerHTML);
					}
					
			}
		</c:forEach>
		
	}catch(e){}
	for(var x=0;x<names.length;x++){
		var ul=document.getElementById("ul"+s);
		var html="<li id=\"c"+s+"-"+x+"\"><label class=\"label-checkbox item-content\">"+
		"<input type=\"checkbox\" name=\"checkbox\" checked=\"checked\" id=\"o"+s+"-"+x+"\">"+
	"<div class=\"item-media\">"+
		"<i class=\"icon icon-form-checkbox\"></i>"+
	"</div>"+
	"<div class=\"item-inner\">"+
		"<div class=\"item-title-row\">"+
			"<div class=\"item-title\" id=\"n"+s+"-"+x+"\">"+names[x]+"</div>"+
		"</div></div></label></li>";
		try{$("#c"+s+"-"+x).remove();
			}catch(e){
				
			}
		
		$("#ul"+s).append(html);
	}
}
function submit(){
	var length=${operations.size()};
	var i;
	for(i=0;i<length;i++){
		if(document.getElementById("checkbox"+i).checked){
			break;
		}
	}
	if(i==length){
		$.alert("请选择一项操作");
		return;
	}else{
	var nextnode="";
	var fieldapproval="";
	var documentid="";
	var actionname="";
	var actionnum="";
	var checkdate="";
	var nextstepusername = "";
	try{
		fieldapproval=document.getElementById("approvaltext"+i).value;
	}catch(e){
		
	}
	}
		<c:forEach var="operation" items="${operations }" varStatus="s">
	try{
		var index=${s.index}
		if(i==index){
		var x=0;
		var size=${operation.options.size()};
		var hasOptions=${operation.hasOptions};
		if(size>0){
			x=${operation.options.size()};
		}else if(size==0&&hasOptions){
			x=100;
		}
		nextnode="${operation.nextnode}";
		documentid="${operation.documentid}";
		actionname="${operation.actionname}";
		actionnum="${operation.actionnum}";
		checkdate="${operation.checkdate}";
		for(var j=0;j<x;j++){
		if(document.getElementById("o"+i+"-"+j).checked){
			if(nextstepusername!=""){
				nextstepusername=nextstepusername+";"+document.getElementById("n"+i+"-"+j).innerHTML;
			}else{
				nextstepusername=nextstepusername+document.getElementById("n"+i+"-"+j).innerHTML;
			}
		}
		}
		}
	}catch(e){
	}
		</c:forEach>
		
		$.ajax({
			type:"POST",
			url:"aftersubmit",
			data:{
				"type":"${type}",
				"id":"${id}",
				"nextnode": nextnode,
				"fieldapproval": fieldapproval,
				"documentid": documentid,
				"actionname": actionname,
				"checkdate": checkdate,
				"nextstepusername": nextstepusername
			},
			dataType:"json",
			success:function(data){
				$.alert(decodeURIComponent(data.message));
				if(data.result=="1"){
					window.location.href="getTab";
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
		<c:forEach var="item" items="${operations }" varStatus="status">
			<div class="list-block" id="origin${status.index }">
				<ul id="ul${status.index }">
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
											<textarea id="approvaltext${status.index }"></textarea>
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
											<input type="radio" name="radio"
												id="o${status.index }-${sta.index}">
										</c:if> <c:if test="${item.multi==true}">
											<input type="checkbox" name="checkbox"
												id="o${status.index }-${sta.index}">
										</c:if>
										<div class="item-media">
											<i class="icon icon-form-checkbox"></i>
										</div>
										<div class="item-inner">
											<div class="item-title-row">
												<div class="item-title" id="n${status.index }-${sta.index}">${name }</div>
											</div>
										</div>
								</label></li>
							</c:forEach>
						</c:if>
						<!-- 自选 -->
						<c:if test="${item.options.size()==0 }">
							<li>
								<div class="item-content item-link"
									id="nextuser${status.index }" onclick="select(${status.index})">
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


		<div class="content-block" id="button">
			<div class="row">
				<a onclick="submit()"
					class="button button-big button-fill button-success">确定</a>
			</div>
		</div>


		<c:forEach var="operation" items="${operations }" varStatus="s">
			<c:if test="${operation.hasOptions}">
				<c:if test="${operation.options.size()==0}">

					<div class="content-block" id="popup${s.index }">
						<c:forEach var="item" items="${departments }" varStatus="status">
							<div class="list-block">
								<ul>
									<li>
										<div class="item-content item-link"
											onclick="disUser(${s.index},${status.index})">
											<div class="item-inner">
												<div class="item-title">${item.name }</div>
												<div class="item-after"></div>
											</div>
										</div>
									</li>
									<c:forEach var="username" items="${item.usernames }"
										varStatus="sta">
										<li id="d${s.index}-${status.index }-${sta.index}"><label
											class="label-checkbox item-content"> <c:if
													test="${operation.multi==false}">
													<input type="radio" name="radio"
														id="s${s.index}-${status.index }-${sta.index}">
												</c:if> <c:if test="${operation.multi==true}">
													<input type="checkbox" name="checkbox"
														id="s${s.index}-${status.index }-${sta.index}">
												</c:if>
												<div class="item-media">
													<i class="icon icon-form-checkbox"></i>
												</div>
												<div class="item-inner">
													<div class="item-title-row">
														<div class="item-title"
															id="name${s.index}-${status.index }-${sta.index}">${username }
														</div>
													</div>
												</div>
										</label></li>
									</c:forEach>
								</ul>
							</div>
						</c:forEach>
						<br/>
					</div>
				</c:if>
			</c:if>
		</c:forEach>
	</div>

	<nav class="bar bar-tab" id="close">
		<a class="tab-item external" onclick="closePop()"> 确定 </a> <a
			class="tab-item external" onclick="cancelPop()"> 取消 </a>
	</nav>
	<script src="js/sm.js"></script>
	<script src="js/sm-city-picker.js"></script>
</body>

</html>