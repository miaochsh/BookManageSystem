<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>図書管理基本情報一覧</title>
</head>
<body
	style="background: url(img/background.jpg); background-size: cover;">

	<div style="float: right;" align="right">
		<input type="button" value="ログアウト" style="width: 80px;"
			onclick="window.location.href='login.jsp'" />
	</div>
	<h1 style="text-align: center;">図書管理基本情報一覧画面</h1>

	<br>
	<div align="center">
		<table>
			<tr>
				<td><s:form align="center" action="toSearch">
						図書名: <input type="text" name=bookName>
						<s:submit value="図書検索" style="width: 80px;" />
					</s:form></td>
				<td><s:form action="ToAdd">
						<s:submit value="新借入" style="width: 80px;" />
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
				<th width="200">借入日</th>
				<th width="200">予定帰還日</th>
				<th width="50">日数</th>
				<th width="160" colspan="2"></th>
			</tr>

			<s:iterator value="booksInfoList">
				<tr>

					<td><s:property value="bookCd" /></td>
					<td><s:property value="bookName" /></td>
					<td><s:property value="bookAuthor" /></td>
					<td><s:property value="borrowStartTime" /></td>
					<td><s:property value="borrowEndTime" /></td>
					<td style="text-align: center;"><s:property value="borrowDays" /></td>

					<td style="text-align: center;">
						<s:form action="toChangeInit">
							<s:submit class="back" value="変更" style="width: 80px;" />
						</s:form>
					</td>
					<td style="text-align: center;">
						<s:form action="todele">
							<s:submit class="back" value="帰還" style="width: 80px;" />
						</s:form>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
