<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link type="text/css" rel="stylesheet" href="style/board.css">
</head>
<body>
<div id="wrap" align="center">
	<h2>게시글 수정</h2>
	<form action="BS" method="post">
		<input type="hidden" name="command" value="board_update">
		<input type="hidden" name="num" value="${board.num }">
		
		<table>
			<tr>
				<th>닉네임</th>
				<td><input type="text" name="title" value="${board.nickName}" required="required"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="70" name="content" value="${board.content}"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">수정하기</button>
					<button type="button" onclick="location.href='BS?command=board_list'">취소하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>