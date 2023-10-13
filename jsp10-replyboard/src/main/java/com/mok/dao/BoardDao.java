package com.mok.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mok.common.JDBCConnect;
import com.mok.dto.BoardDto;
import com.mok.service.BoardService;

public class BoardDao implements BoardService{

	@Override
	public int write(BoardDto boardDto) {
		// TODO Auto-generated method stub
		int result = 0;
		
		int max = getMaxRegroup();
		System.out.println("111111");
		System.out.println(boardDto.getUserID());
		System.out.println(boardDto.getName());
		System.out.println(boardDto.getTitle());
		System.out.println(boardDto.getContent());
		System.out.println("111111");
		
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "insert INTO replyboard values(seq_replyboard.nextval, ?, ?, ?, ?, sysdate, 0, ?, 1, 1, 1)";
		
					  
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			System.out.println("1");
			pstmt.setString(1, boardDto.getUserID());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContent());
			pstmt.setInt(5, max + 1);
//			pstmt.setInt(6, boardDto.getRelevel());
//			pstmt.setInt(7, boardDto.getRestep());
			System.out.println("2");
			result = pstmt.executeUpdate();
			System.out.println("3");
			System.out.println("22222");
			System.out.println(result);
			System.out.println("22222");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		return result;
	}

	@Override
	public List<BoardDto> list() {
		int result = 0;
		List<BoardDto> boardList = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select * from replyboard order by regroup desc, relevel asc, restep asc";

			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			boardList = new ArrayList<BoardDto>();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setUserID(rs.getString("userID"));
				boardDto.setName(rs.getString("name"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegDate(rs.getString("regDate"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegroup(rs.getInt("regroup"));
				boardDto.setRelevel(rs.getInt("relevel"));
				boardDto.setRestep(rs.getInt("restep"));
				boardDto.setAvailable(rs.getInt("available"));
				boardList.add(boardDto);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		
		return boardList;
	}

	@Override
	public int getMaxRegroup() {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select nvl(max(regroup),0) as max from replyboard";

			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("max");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		return result;
	}

	public BoardDto view(int no) {
		BoardDto viewBoard = null;
		ResultSet rs = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		
		try {
			String sql = "SELECT * FROM \n"
					+ "	(SELECT rownum, a.* FROM (SELECT * FROM replyboard ORDER BY regroup) a)\n"
					+ "		WHERE NO=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			viewBoard = new BoardDto();
			if(rs.next()) {
				viewBoard.setNo(rs.getInt("no"));
				viewBoard.setUserID(rs.getString("userID"));
				viewBoard.setName(rs.getString("name"));
				viewBoard.setTitle(rs.getString("title"));
				viewBoard.setContent(rs.getString("content"));
				viewBoard.setRegDate(rs.getString("regDate"));
				viewBoard.setHit(rs.getInt("hit"));
				viewBoard.setRegroup(rs.getInt("regroup"));
				viewBoard.setRelevel(rs.getInt("relevel"));
				viewBoard.setRestep(rs.getInt("restep"));
				viewBoard.setAvailable(rs.getInt("available"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		
		return viewBoard; 
	}

	public int createReply(BoardDto replyDto) {
		// TODO Auto-generated method stub
		JDBCConnect jdbcConn = new JDBCConnect();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			 String insert = "insert INTO replyboard values(seq_replyboard.nextval, ?, ?, ?, ?, sysdate, 0, ?, seq_relevel.nextval, ?, 1)";
			 pstmt = jdbcConn.conn.prepareStatement(insert);
			 pstmt.setString(1, replyDto.getUserID());
			 pstmt.setString(2, replyDto.getName());
			 pstmt.setString(3, replyDto.getTitle());
			 pstmt.setString(4, replyDto.getContent());
			 pstmt.setInt(5, replyDto.getRegroup());
			 pstmt.setInt(6, replyDto.getRestep() + 1);
			 result = pstmt.executeUpdate();
			 
			 
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	public int replyDelete(int no) {
		// TODO Auto-generated method stub
		JDBCConnect jdbcConn = new JDBCConnect();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "update replyboard set available=0 where no=?";
			pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public BoardDto prevBoard(int no) {
		BoardDto viewBoard = null;
		ResultSet rs = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		
		try {
			String sql = "SELECT * FROM \n"
					+ "	(SELECT rownum, a.* FROM (SELECT * FROM replyboard ORDER BY regroup) a)\n"
					+ "		WHERE NO=?-1";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			viewBoard = new BoardDto();
			if(rs.next()) {
				viewBoard.setNo(rs.getInt("no"));
				viewBoard.setUserID(rs.getString("userID"));
				viewBoard.setName(rs.getString("name"));
				viewBoard.setTitle(rs.getString("title"));
				viewBoard.setContent(rs.getString("content"));
				viewBoard.setRegDate(rs.getString("regDate"));
				viewBoard.setHit(rs.getInt("hit"));
				viewBoard.setRegroup(rs.getInt("regroup"));
				viewBoard.setRelevel(rs.getInt("relevel"));
				viewBoard.setRestep(rs.getInt("restep"));
				viewBoard.setAvailable(rs.getInt("available"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		
		return viewBoard; 
		
	}

	

}
