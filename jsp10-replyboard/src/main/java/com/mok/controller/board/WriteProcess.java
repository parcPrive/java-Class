package com.mok.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mok.dao.BoardDao;
import com.mok.dto.BoardDto;
import com.mok.util.ScriptWriter;

/**
 * Servlet implementation class WriteProcess
 */
public class WriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setUserID(userID);
		boardDto.setName(name);
		BoardDao boardDao = new BoardDao();
		int result = boardDao.write(boardDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "게시글 작성완료", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "에러");
		}
		
	}

}
