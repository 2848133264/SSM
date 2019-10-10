<%@ page language="java"   import="java.util.*"  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电子商务平台-后台登入</title>
<!-- 引入EasyUI 的相关css ，js  文件  -->
<link href="EasyUI/themes/default/easyui.css" rel="stylesheet" type="text/css">
<link href="EasyUI/themes/icon.css" rel="stylesheet" type="text/css">
<link href="EasyUI/demo.css" rel="stylesheet" type="text/css">
<script src="EasyUI/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="EasyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="EasyUI/easyui-lang-zh_CN.js"></script>

</head>
<body>

	<script type="text/javascript">
		//清除输入
		function clearForm() {
			$('#adminLoginForm').form('clear');
		}
		//登入操作
		function checkAdminLogin() {
			$("#adminLoginForm").form('submit', {
				url : '${pageContext.servletContext.contextPath }/admininfo/login',
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.success == "true") {
						window.location.href = 'admin.jsp';
						$("$adminLoginDlg").dialog("close");
					} else {
						$.messager.show({
							title : "提示信息",
							msg : result.message
						});
					}
				}
			})
		}
	</script>

	<div id="adminLoginDlg" class="easyui-dialog"
		style="left: 550px; top: 200px; width: 400px; height: 300px;"
		data-options="title:'后台登入',buttons:'#bb',modal:true">
		<!-- 采用easyui中自己的校验方式，添加关键字：required:true -->
		<form id="adminLoginForm" method="post">
			<table style="margin: 71px; font-size: 25;">
				<tr>
					<th>用户名 :</th>
					<td><input class="easyui-textbox" type="text" id="name"
						name="name" data-options="required:true" value="admin"></input></td>
				</tr>
				
				<tr><br>
					<th>密&nbsp;&nbsp;&nbsp;码 :</th>
					<td><input class="easyui-textbox" type="text" id="pwd"
						name="pwd" data-options="required:true" value="123456"></input></td>
				</tr>
			</table>
		</form>
		<div id="bb">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="checkAdminLogin()" type="submit">登入</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm();">重置</a>
		</div>
	</div>
</body>
</html>