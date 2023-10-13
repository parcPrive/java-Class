package com.mok.controller.member;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.mok.dao.MemberDao;
import com.mok.dto.MemberDto;
import com.mok.dto.ModalDto;


/**
 * Servlet implementation class MemberLoginProcess
 */
public class MemberLoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginProcess() {
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
		String userID = request.getParameter("userID");
		String password = request.getParameter("userPW");
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userID);
		memberDto.setPassword(password);
		MemberDto loginMember = new MemberDto();
		loginMember = memberDao.login(memberDto);
		
		
		if(loginMember != null) {
			ModalDto modalDto = new ModalDto("show", "로그인성공!!!");
			HttpSession session = request.getSession();
			session.setAttribute("loggedID", loginMember.getId());
			session.setAttribute("loggedName", loginMember.getName());
			session.setAttribute("profile", loginMember.getProfile());
			session.setAttribute("modalDto", modalDto);
			response.sendRedirect("../board/list");
		}
				
		
	}

}
