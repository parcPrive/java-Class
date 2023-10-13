package com.mok.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.mok.dao.MemberDao;
import com.mok.dto.MemberDto;

/**
 * Servlet implementation class MemberIDCheck
 */
public class MemberIDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIDCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkID = request.getParameter("userID");
		System.out.println("체크아이디!!=>>>" + checkID);
		MemberDao memberDao = new MemberDao();
		int count = memberDao.checkID(checkID);
		Gson gson = new Gson();
		Map<String, Integer> map = new HashMap<>();
		map.put("count", count);
		String resultJson = gson.toJson(map);
		request.setAttribute("resultJson", resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/id-check.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
