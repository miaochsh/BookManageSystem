<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>図書管理システム</title>
<script type="text/javascript">
	function eraseInfo() {
		document.getElementsByName("accountId")[0].placeholder = "";
	}
</script>
</head>
<body
	style="background: url(img/background.jpg); background-size: cover;">
	<div align="left">
		<div>
			<i><img src="img/logo.png" width="68px" height="68px"></i>
		</div>
	</div>

	<h1 align="center">図書管理システム</h1>
	<br>
	<hr>
	<div align="center">
		<s:form action="login" method="post" name="form" theme="simple">
			<table>
				<tr>
					<td>ユーザ名：</td>
				</tr>
				<tr>
					<td><s:textfield name="accountId" value=""
							placeholder="Emailアドレスを入力してください" onkeydown="eraseInfo();" /></td>
				</tr>

				<tr>
					<td></td>
				</tr>

				<tr>
					<td>パスワード：</td>
				</tr>
				<tr>
					<td><s:textfield name="password" value="" /></td>
				</tr>
			</table>
			<s:submit value="ログイン"></s:submit>
		</s:form>
	</div>
	<div style="color: red">
		<s:fielderror />
		<s:actionmessage />
	</div>
</body>
</html>