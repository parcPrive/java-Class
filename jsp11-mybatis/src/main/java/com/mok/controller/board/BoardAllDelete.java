package com.mok.controller.board;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.mok.dao.BoardDao;
import com.mok.dto.ModalDto;

/**
 * Servlet implementation class BoardAllDelete
 */
public class BoardAllDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAllDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no[] = request.getParameterValues(("no"));
		BoardDao boardDao = new BoardDao();
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i = 0; i < no.length; i++) {
			nums.add(Integer.parseInt(no[i]));
		}
			

		int result = boardDao.deleteAllBoard(nums);
		if(result > 0) {
			ModalDto modalDto = new ModalDto("show", "게시글 삭제성공");
			HttpSession session = request.getSession();
			session.setAttribute("modalDto", modalDto);
			response.sendRedirect("../board/list");
			
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
