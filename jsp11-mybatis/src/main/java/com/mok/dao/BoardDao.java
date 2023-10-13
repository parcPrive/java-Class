package com.mok.dao;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mok.dto.BoardDto;
import com.mok.dto.PageDto;
import com.mok.mybatis.MybatisConnectionFactory;

public class BoardDao {
	public List<BoardDto> getAllBoard() {
		List<BoardDto> boardList = null;
		// SqlSession을 하나 열어준다.
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllReplyboard");
		sqlSession.close();
		return boardList;
	}
	public BoardDto getOneBoard(int no) {
		BoardDto boardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		
		boardDto = sqlSession.selectOne("getOneBoard",no);
		sqlSession.close();
		return boardDto;
	}
	
	public List<BoardDto> getPageBoard(PageDto pageDto) {
		List<BoardDto> boardList = null;
		// SqlSession을 하나 열어준다.
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getPageBoard", pageDto);
		sqlSession.close();
		return boardList;
	}
	
	public int writeBoard(BoardDto boardDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertBoard", boardDto);
		sqlSession.close();
		return result;
	}
	public int deleteBoard(int no) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteBoard", no);
		sqlSession.close();
		return result;
	}
	public int updateHit(int no) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateHit", no);
		sqlSession.close();
		return result;
		
	}
	
	public int deleteAllBoard(ArrayList<Integer> nums) { // ArrayList<Integer> nums  int nums[]
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("deleteAllBoard", nums);
		sqlSession.close();
		return result;
	}
	public List<BoardDto> getSearchBoard(HashMap<String, String> searchMap) {
		// TODO Auto-generated method stub
		List<BoardDto> boardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectList("searchSelect", searchMap);
		return boardDto;
	}
	
//	public BoardDto find(int no) {
//		BoardDto boardDto = new BoardDto();
//		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession(); 
//		boardDto = sqlSession.selectOne("getOneBoard", no);
//		sqlSession.close();
//		return boardDto;
//	}
	
}
