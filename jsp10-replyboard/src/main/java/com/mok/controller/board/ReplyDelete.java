package com.mok.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mok.dao.BoardDao;
import com.mok.util.ScriptWriter;

/**
 * Servlet implementation class ReplyDelete
 */
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strNo = request.getParameter("no");
		int no = 0;
		if(strNo != null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		BoardDao boardDao = new BoardDao();
		int result = boardDao.replyDelete(no);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "댓글을 삭제했습니다.", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "알수없는에러");
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
