package com.mok.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.mok.dao.BoardDao;
import com.mok.dto.ModalDto;

/**
 * Servlet implementation class BoardDelete
 */
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao boardDao = new BoardDao();
		int result = boardDao.deleteBoard(no);
		if(result > 0) {
				ModalDto modalDto = new ModalDto("show", "게시글 삭제성공");
				HttpSession session = request.getSession();
				session.setAttribute("modalDto", modalDto);
				response.sendRedirect("../board/list");
				
		}else {
			System.err.println("실패!!");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
