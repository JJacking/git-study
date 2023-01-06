package board.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import boardDto.BoardDto;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDto bTo = new BoardDto();
		
		bTo.setNum(Integer.parseInt(request.getParameter("num")));
		bTo.setNickName(request.getParameter("nickName"));
		bTo.setTitle(request.getParameter("title"));
		bTo.setContent(request.getParameter("content"));
		
		BoardDao dao = BoardDao.getInstance();
		dao.updateRead(bTo);
		
		response.sendRedirect("BS?command=board_list");
	}

}
