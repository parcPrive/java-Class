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
 * Servlet implementation class ReplyProcess
 */
public class ReplyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyProcess() {
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
		String strNo = request.getParameter("no");
		String userID =request.getParameter("userID");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String strRegroup = request.getParameter("regroup");
		String strRelevel = request.getParameter("relevel");
		String strRestep = request.getParameter("restep");

		System.out.println("제목  => " +title);
		System.out.println("내용  => " +content);
		
		int no = 0;
		int regroup = 0;
		int relevel = 0;
		int restep = 0;
		//if(strNo != null && strRegroup != null && strRelevel != null && strRestep != null) {
			regroup = Integer.parseInt(strRegroup);
			relevel = Integer.parseInt(strRelevel);
			restep = Integer.parseInt(strRestep);
			System.out.println("여기 안들어옴?");
		//}
		
		System.out.println("리그룹이=>"+regroup);
		System.out.println("리레벨 => "+relevel);
		System.out.println("리스탭 => " +restep);
		
		BoardDto replyDto = new BoardDto();
		replyDto.setNo(no);
		replyDto.setUserID(userID);
		replyDto.setName(name);
		replyDto.setTitle(title);
		replyDto.setContent(content);
		replyDto.setRegroup(regroup);
		replyDto.setRelevel(relevel);
		replyDto.setRestep(restep);
		
		BoardDao boardDao = new BoardDao();
		int result = boardDao.createReply(replyDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "등록에성공", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "등록에 실패");
		}
		
		
	}

}
