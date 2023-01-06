<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<link type="text/css" rel="stylesheet" href="style/board.css">
</head>
<body>
  <form action="BS" method="post">
    <table class="wrap">
      <tr>
        <th>글제목</th>
        <td><input type="text" name="title" required>*필수</td>
      </tr>
      <tr>
        <th>닉네임</th>
        <td><input type="text" name="name" value="${board.nickName}" required>*필수</td>
      </tr>
      <tr>
      	<th>이메일</th>
      	<td><input type="email" name="email" value="${board.email}" required>*필수</td>
      </tr>
      <tr>
        <th>본문</th>
        <td><textarea rows="15" cols="70" name="content"></textarea></td>
      </tr>
     
      <tr>
        <td colspan="2">
          <button type="submit">글작성</button>
          <button type="reset">다시 작성</button>
          <button type="button" onclick="location.href='BS?command=board_list'">목록으로</button>
        </td>
      </tr>
      
    </table>
  
  </form>
  </body>
  </html>