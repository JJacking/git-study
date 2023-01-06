package board.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import boardDto.BoardDto;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto bTo = new BoardDto();
		
		bTo.setTitle(request.getParameter("title"));
		bTo.setEmail(request.getParameter("email"));
		bTo.setNickName(request.getParameter("nickName"));
		bTo.setContent(request.getParameter("content"));
		
		BoardDao dao = BoardDao.getInstance();
		dao.insertBoard(bTo);
		
		response.sendRedirect("BS?command=board_list");

	}

}
