package board.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;

public class EmailCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		String num = request.getParameter("num");
		String email = request.getParameter("email");
		
		BoardDao dao = BoardDao.getInstance();
		
		if(dao.checkEmail(num,email)) {
			//ture : 메일 일치
			System.out.println("이메일일치");
			url="board/loginSuccess.jsp";
			request.setAttribute("msg", "확인되었습니다.");
		}else {
			//false : 메일 불 일치
			System.out.println("이메일 불일치");
			url="board/loginCheck.jsp";
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
			}

}
