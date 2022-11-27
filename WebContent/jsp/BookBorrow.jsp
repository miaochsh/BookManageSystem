<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>図書管理基本情報一覧</title>
</head>
<body
	style="background: url(img/background.jpg); background-size: cover;">

	<div style="float: right;" align="right">
		<input type="button" value="ログアウト" style="width: 80px;"
			onclick="window.location.href='login.jsp'" />
	</div>
	<h1 style="text-align: center;">図書借入基本情報一覧画面</h1>



	<br>

	<div style="color: red">
		<s:fielderror />
		<s:actionmessage />
	</div>
	<div align="center">
		<table>
			<tr>
				<td><s:form align="center" action="bookSearch">
						図書コード: <input type="text" name="bookCd">
						図書名: <input type="text" name="bookName">
						図書作者: <input type="text" name="bookAuthor">
						<s:submit value="図書検索" style="width: 80px;" />
					</s:form></td>
				<td><s:form action="goBack">
						<s:submit value="戻る" style="width: 80px;" />
					</s:form></td>
			</tr>
		</table>
	</div>



	<div align="center">
		<table border="1">
			<tr style="background-color: #FFA500;">
				<th width="80">図書コード</th>
				<th width="220">図書名</th>
				<th width="220">図書作者</th>
				<th width="200">借出日</th>
				<th width="200">予定帰還日</th>
				<th width="50">日数</th>
				<th width="80"></th>
			</tr>

			<s:iterator var="booksInfo" value="booksInfoList">
				<tr>
					<s:form action="bookBorrow">
						<td><s:property value="bookCd" /></td>
						<td><s:property value="bookName" /></td>
						<td><s:property value="bookAuthor" /></td>
						<td><s:property value="borrowStartTime" /></td>
						<td><s:property value="borrowEndTime" /></td>
						<td><s:if test='%{borrowFlag =="0"}'>
								<s:textfield name="borrowDays" cssStyle="width:50px;" required="true" maxlength="3"
								onKeyPress="if(event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;"
								 onKeyUp="this.value=this.value.replace(/\D/g,'')" />
							</s:if> <s:else>
								<s:property value="borrowDays" />
							</s:else></td>

						<td style="text-align: center;"><s:if
								test='%{borrowFlag =="0"}'>
								<s:submit class="back" value="借入" style="width: 80px;" />
							</s:if> <s:else>
								<span>借出済</span>
							</s:else>
					</s:form>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
