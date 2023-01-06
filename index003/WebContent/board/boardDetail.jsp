<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link type="text/css" rel="stylesheet" href="style/board.css">
<script type="text/javascript" src="script/board.js"> </script>
</head>
<body>
    <div id="wrap">
      <h2>게시글 리스트</h2>
      <table>
        <tr>
          <th>제목</th>
          <td colspan="5">${board.title}</td>
        </tr>
        <tr>
          <th>닉네임</th>
          <td>${board.nickName}</td>
          <th>작성일</th>
          <td>${board.wirteDate}</td>
          <th>조회수</th>
          <td>${board.readCount}</td>
        </tr>
        <tr>
          <th>내용</th>
          <td colspan="5">${board.content}</td>
        </tr>
        <tr>
          	<td colspan="6" style="border: white; text-align:center">
		          <button type="button" onclick="newWindow('BS?command=board_check_pass_form&num=${board.num}','update')">
		         	 게시글 수정</button>
		          <button type="button" onclick="newWindow('BS?command=board_check_pass_form&num=${board.num}','delete')">
		         	게시글 삭제</button>
		          <button type="button" onclick="location.href='BS?command=board_list'">목록 보기</button>
        	</td>
        </tr>
      </table>
    </div>
  </body>
  </html>