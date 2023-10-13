package com.mok.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.mok.dao.BoardDao;
import com.mok.dto.BoardDto;
import com.mok.dto.PageDto;

/**
 * Servlet implementation class BoardList
 */
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int start = Integer.parseInt(request.getParameter("start"));
//		int end = Integer.parseInt(request.getParameter("end"));
		
		BoardDao boardDao = new BoardDao();
		PageDto pageDto = new PageDto();
		pageDto.setStart(1);
		pageDto.setEnd(7);
		List<BoardDto> boardList = boardDao.getAllBoard();
		List<BoardDto> boardListP = boardDao.getPageBoard(pageDto);
		BoardDto boardDto = boardDao.getOneBoard(15);
		
		System.out.println(boardList.size());
		System.out.println("페이지"+boardListP.size());
		System.out.println(boardDto.toString());
		HttpSession session = request.getSession();
		request.setAttribute("boardList", boardListP);
		RequestDispatcher dispatcehr = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		
		
		dispatcehr.forward(request, response);
		if(session.getAttribute("modalDto") != null) {
			session.removeAttribute("modalDto");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
