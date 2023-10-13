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
import com.mok.dto.BoardDto;
import com.mok.dto.ModalDto;


/**
 * Servlet implementation class BoardWrite
 */
public class BoardWriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BoardDao boardDao = new BoardDao();
	BoardDto boarDto = new BoardDto();
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	boarDto.setUserID("mok119");
	boarDto.setName("정현목");
	boarDto.setTitle(title);
	boarDto.setContent(content);
	boarDto.setRegroup(8);
	boarDto.setRelevel(1);
	boarDto.setRestep(1);
	
	
	int result = boardDao.writeBoard(boarDto);
	if(result > 0) {
		ModalDto modalDto = new ModalDto("show","게시글 등록 성공");
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
