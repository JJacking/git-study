package board.controller;



import board.business.Action;
import board.business.BoardDeleteAction;
import board.business.BoardDetailAction;
import board.business.BoardListAction;
import board.business.BoardUPdateFormAction;
import board.business.BoardUpdateAction;
import board.business.BoardWriteAction;
import board.business.BoardWriteFormAction;
import board.business.EmailCheckAction;
import board.business.EmailCheckFormAction;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		
		// command값에 따른 기능 클래스를 생성해서 반환하는 클래스
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}else if(command.equals("board_write_form")){
			action = new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_detail")) {
			action = new BoardDetailAction();
		}else if(command.equals("board_check_pass_form")) {
			action = new EmailCheckFormAction();
		}else if(command.equals("board_check_pass")) {
			action = new EmailCheckAction();
		}else if(command.equals("board_update_form")) {
			action = new BoardUPdateFormAction();
		}else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
			
		
		return action;
	}	
		
}
	
