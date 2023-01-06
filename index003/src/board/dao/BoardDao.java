package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import boardDB.DBManager;
import boardDto.BoardDto;

public class BoardDao {
	
	private BoardDao() {}
	private static BoardDao dao = new BoardDao();
	public static BoardDao getInstance() {
		return dao;
	}

	
	//게시글 불러오기
	public List<BoardDto> selectAllBoard(){
		List<BoardDto> list = new ArrayList<>();
		String sql = "SELECT * FROM boardTbl ORDER BY num DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDto bTo = new BoardDto();
				bTo.setNum(rs.getInt("num"));
				bTo.setTitle(rs.getString("title"));
				bTo.setNickName(rs.getString("nickName"));
				bTo.setWirteDate(rs.getTimestamp("wirteDate"));
				bTo.setReadCount(rs.getInt("readCount"));
				
				list.add(bTo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
			
		}
		return list;
		
		
	}
	
	//게시물등록
	public void insertBoard(BoardDto bTo) {
		String sql = "INSERT INTO boardTbl(num,title,nickName,content) "
					+" VALUES(seq_boardTbl.NEXTVAL,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, bTo.getTitle());
			psmt.setString(2, bTo.getNickName());
			psmt.setString(3, bTo.getContent());
			
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	//조회수 증가
	public void updateReadCount(String num) {
		
		String sql = "UPDATE boardTbl set readcount = readcount+1 WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, num);
			
			psmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	//게시글 상세정보 읽어오기
	public BoardDto selectBoardByNum(String num) {
		BoardDto bTo = null;
		
		String sql = "SELECT * FROM boardTbl WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, num);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				bTo = new BoardDto();
				
				bTo.setNum(rs.getInt("num"));
				bTo.setNickName(rs.getString("nickName"));
				bTo.setEmail(rs.getString("email"));
				bTo.setTitle(rs.getString("title"));
				bTo.setContent(rs.getString("content"));
				bTo.setWirteDate(rs.getTimestamp("wirteDate"));
				bTo.setReadCount(rs.getInt("readCount"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return bTo;
	}
	
	// 본인확인
	public boolean checkEmail(String num, String email) {
		
		BoardDto bTo = selectBoardByNum(num);
		
		if(bTo.getEmail().equals(email)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public void updateRead(BoardDto bTo) {
		String sql = "UPDATE boardTbl "
					+ " SET nickName=?, title=?,content=? "
					+ " WHERE num=? ";
				
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, bTo.getNickName());
			psmt.setString(2, bTo.getTitle());
			psmt.setString(3, bTo.getContent());
			psmt.setInt(4, bTo.getNum());
			
			psmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	
	
	}
	//게시글 삭제
	public void deleteBoard(String num) {
		String sql = "DELETE FROM boardTbl WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, num);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	//전체게시물 갯수 조회
	public int selectAllNumboard() {
		int cntAll = 0;
		
		String sql = "SELECT COUNT(*) FROM boardTbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				cntAll = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt);
		}
		
		return cntAll;
	}
	
		//현재 페이지 글 목록 읽어오기
	public List<BoardDto> selectTargetBoards(int section, int pageNum){
		List<BoardDto> list = new ArrayList<>();
		
		String sql = "SELECT * FROM "
				+ " (SELECT ROWNUM AS num,title, nickName, content, wirteDate, readCount "
				+ " FROM (SELECT * FROM boardTbl ORDER BY num DESC)) "
				+ " WHERE nick BETWEEN (?-1)*100+(?-1)*10+1 AND (?-1)*100+(?*10) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, section);
			psmt.setInt(2, pageNum);
			psmt.setInt(3, section);
			psmt.setInt(4, pageNum);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardDto bTo = new BoardDto();
				
				bTo.setNum(rs.getInt("num"));
				bTo.setTitle(rs.getString("title"));
				bTo.setNickName(rs.getString("nickName"));
				bTo.setWirteDate(rs.getTimestamp("wirteDate"));
				bTo.setReadCount(rs.getInt("readCount"));
				
				list.add(bTo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
		return list;
	}
	

	
	
}
