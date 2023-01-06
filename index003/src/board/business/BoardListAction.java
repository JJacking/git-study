package board.business;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import boardDto.BoardDto;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가져오기
		String url = "board/boardList.jsp";
		
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		int section = Integer.parseInt(((_section==null)?"1":_section));
		int pageNum = Integer.parseInt(((_section==null)?"1":_pageNum));

		
		BoardDao dao = BoardDao.getInstance();
		int totalCnt = dao.selectAllNumboard();
		List<BoardDto> boardList = dao.selectTargetBoards(section, pageNum);
		
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("section", section);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
