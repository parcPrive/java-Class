package com.mok.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mok.dao.BoardDao;
import com.mok.dto.BoardDto;

public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public View() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no = 0;
		if(strNo != null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		BoardDao boardDao = new BoardDao();
		BoardDto viewBoard = new BoardDto();
		viewBoard = boardDao.view(no);
		System.out.println("111111");
		System.out.println(viewBoard);
		System.out.println("11111");
		request.setAttribute("viewBoard", viewBoard);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/view.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
