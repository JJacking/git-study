<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>본인확인 페이지</title>
<link type="text/css" rel="stylesheet" href="style/board.css">
</head>
<body>
<div id="wrap" align="center">
	<h2>본인확인</h2>
	<form action="BS" method="post">
		<input type="hidden" name="command" value="board_check_pass">
		<input type="hidden" name="num" value="${param.num}">
		<table>
			<tr>
				<th>가입시 이메일을 적어주세요</th>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">확인</button>
			</tr>
			<tr>
				<td colspan="2">${msg}</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>