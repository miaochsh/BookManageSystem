<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>図書基本情報変更画面</title>

</head>
<body
	style="background: url(img/background.jpg); background-size: cover;">

	<div style="float: right;" align="right">
		<input type="button" value="ログアウト" style="width: 80px;"
			onclick="window.location.href='login.jsp'" />
	</div>
	<h1 align="center">図書基本情報変更画面</h1>
	<div id="body">
		<table class="table3">
			<s:form action="ChangeAction" method="post" name="myform">
				<tr>
					<td>図書コード</td>
					<td><s:textfield value="%{bookInfo.bookCd}"
							name="bookInfo.bookCd" cssStyle="background-color:gray;"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>図書名</td>
					<td><s:textfield value="%{bookInfo.bookName}"
							name="bookInfo.bookName" cssStyle="background-color:gray;"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>図書作者</td>
					<td><s:textfield value="%{bookInfo.bookAuthor}"
							name="bookInfo.bookAuthor" cssStyle="background-color:gray;"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>借入日</td>
					<td><s:textfield value="%{bookInfo.borrowStartTime}"
							name="bookInfo.borrowStartTime" cssStyle="background-color:gray;"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>予定帰還日</td>
					<td><s:textfield value="%{bookInfo.borrowEndTime}"
							name="bookInfo.borrowEndTime" cssStyle="background-color:gray;"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>日数</td>
					<td><s:textfield value="%{bookInfo.borrowDays}"
							name="bookInfo.borrowDays" maxlength="3"
							onKeyPress="if(event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;"
							onKeyUp="this.value=this.value.replace(/\D/g,'')" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button" value="戻る"
						onclick="returnBookListInfo();" style="width: 80px;"> <s:submit
							style="width: 80px;" value="確定" onclick="return change();" /></td>
				</tr>


			</s:form>
		</table>
	</div>
</body>
<script>
	function change() {
		var msg = "確かに変更しますか？ご確認ください！";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	}
	function returnBookListInfo() {
		myform.action = "returnBookListInfo";
		myform.submit();
	}
</script>
</html>