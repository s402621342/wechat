<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type='text/javascript'>
 function save(){
	 var code=$('#code').val();
	 var name=$('#name').val();
	 var path=$('#path').val();
	 var param=$('#param').val();
	 $('#code').val("");
	 $('#name').val("");
	 $('#path').val("");
	 $('#param').val("");
	 $.ajax({
			type:"POST",
			url:"submitConfig",
			data:{
				"code": code,
				"name": name,
				"path": path,
				"param": param,
			},
			dataType:"json",
			success:function(data){
			},
			error:function(data){
			
			}
		})
	 
 }
	function del(i){
		var id=$("#h"+i).val();
		$.ajax({
			type:"POST",
			url:"delConfig",
			data:{
				"id": id,
			},
			dataType:"json",
			success:function(data){
			},
			error:function(data){
			
			}
		})
	}
	function update(){
		var id=$("#uid").val();
		var code=$('#ucode').val();
		var name=$('#uname').val();
		var path=$('#upath').val();
		var param=$('#uparam').val();
		$.ajax({
			type:"POST",
			url:"updateConfig",
			data:{
				"id":id,
				"code": code,
				"name": name,
				"path": path,
				"param": param,
			},
			dataType:"json",
			success:function(data){
			},
			error:function(data){
			
			}
		})
	}
	

	
</script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">节点基本信息
			</div>
		</div>
		<div class="panel-body">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">节点名称</span> <input
					type="text" class="form-control" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">节点备注</span> <input
					type="text" class="form-control" aria-describedby="basic-addon1"   disabled="disabled">
			</div>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">身份认证
			</div>
		</div>
		是否认证 <input type="radio" name="authentication" checked="checked">是
		<input type="radio" name="authentication" >否
		<div class="panel-body">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">认证类型</span> <input
					type="text" class="form-control" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">Cookie </span> <input
					type="text" class="form-control" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">认证地址</span> <input
					type="text" class="form-control" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">认证参数</span> <input
					type="text" class="form-control" aria-describedby="basic-addon1">
			</div>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">数字提醒
			</div>
		</div>
		<div class="panel-body">
		是否显示数字提醒 <input type="radio" name="notification" checked="checked">是
		<input type="radio" name="notification" >否
		<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">数字提醒URL地址</span> <input
					type="text" class="form-control" aria-describedby="basic-addon1">
			</div>
		</div>
	</div>



	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">
			<div class="panel-title">配置数据源


			<button type="button" class="btn btn-default navbar-right">导入</button>
			<button type="button" class="btn btn-default navbar-right"
				data-toggle="modal" data-target="#addModal">新建</button>
				</div>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>参数编码</th>
					<th>参数名称</th>
					<th>路径</th>
					<th>参数</th>
					<th>您可以</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${properties}" varStatus="status">
					<input type="hidden" id="h${status.index }" value="${item.id }">
					<tr>
						<td>${status.count }</td>
						<td>${item.code }</td>
						<td>${item.name}</td>
						<td>${item.path }</td>
						<td>${item.param }</td>
						<td><a data-toggle="modal" data-target="#updateModal"
							data-whatever="${item.id }">编辑</a> <a
							onclick="del(${status.index})">删除</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新建数据源</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">参数编码</span> <input
							type="text" class="form-control" aria-describedby="basic-addon1"
							id="code">
					</div>

					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">参数名称</span> <input
							type="text" class="form-control" aria-describedby="basic-addon1"
							id="name">
					</div>

					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">路径</span> <input
							type="text" class="form-control" aria-describedby="basic-addon1"
							id="path">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">参数</span> <input
							type="text" class="form-control" aria-describedby="basic-addon1"
							id="param">
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						onclick="save()">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改数据源</h4>
				</div>
				<input type="hidden" id="uid" value="">
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">参数编码</span> <input
							type="text" class="form-control" aria-describedby="basic-addon1"
							id="ucode">
					</div>

					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">参数名称</span> <input
							type="text" class="form-control" aria-describedby="basic-addon1"
							id="uname">
					</div>

					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">路径</span> <input
							type="text" class="form-control" aria-describedby="basic-addon1"
							id="upath">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">参数</span> <input
							type="text" class="form-control" aria-describedby="basic-addon1"
							id="uparam">
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						onclick="update()">保存修改</button>
				</div>
			</div>
		</div>
	</div>

	<script type='text/javascript'>
	$('#updateModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget);
		  var id = button.data('whatever');
		  var modal = $(this);
		  <c:forEach var="item" items="${properties}" varStatus="status">
				 var i=${item.id};
				 if(id==i){
					 var code="${item.code}";
					 var name="${item.name}";
					 var path="${item.path}";
					 var param="${item.param}";
					 modal.find('#ucode').val(code);
					 modal.find('#uname').val(name);
					 modal.find('#upath').val(path);
					 modal.find('#uparam').val(param);
					 modal.find('#uid').val(id);
				 }
		  </c:forEach>
		})
	</script>
</body>
</html>

