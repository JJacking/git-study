package boardDB;

import java.sql.Connection;

public class DBTest {

	public static void main(String[] args) {
		Connection conn = DBManager.getConnection();
		
		if(conn==null) {
			System.out.println("연결실패");
		}else {
			System.out.println("연결성공");
		}

	}

}
