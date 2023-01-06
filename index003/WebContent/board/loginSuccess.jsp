<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>본인이 확인되었습니다.</h2>
<script type="text/javascript">

	if(window.name == 'update'){ //수정
		window.opener.parent.location.href=
			"BS?command=board_update_form&num=${param.num}";
		<%out.print("성공"); %>
	}else if(window.name == 'delete'){ //삭제
	window.opener.parent.location.href=
		"BS?command=board_delete&num=${param.num}";
	}
	
	window.close();

</script>
</body>
</html>