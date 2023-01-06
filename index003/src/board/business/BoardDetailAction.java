package board.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import boardDto.BoardDto;

public class BoardDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "board/boardDetail.jsp";
		
		String num = request.getParameter("num");
		
		BoardDao dao = BoardDao.getInstance();
		
		//조회수 증가 
		dao.updateReadCount(num);
		
		BoardDto bTo = dao.selectBoardByNum(num);
	
		
		
		request.setAttribute("board", bTo);
		
		request.getRequestDispatcher(url).forward(request, response);


	}

}
