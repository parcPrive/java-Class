package com.mok.controller.member;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mok.dao.MemberDao;
import com.mok.dto.MemberDto;
import com.mok.dto.ModalDto;

/**
 * Servlet implementation class MemberInsertProcess
 */
public class MemberInsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertProcess() {
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
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("email");
		String tel = request.getParameter("tel");
		int zipCode = Integer.parseInt(request.getParameter("postCode"));
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		
		Part profile = request.getPart("profile");
		String partHeader = profile.getHeader("Content-disposition"); 
		String partArray[] = partHeader.split("filename=");
		String originalFileName = partArray[1].trim().replace("\"","");
//		System.out.println(partArray[1]);
//		System.out.println(originalFileName);
		String uploadDirectory = "upload";
		String realUploadPath = getServletContext().getRealPath(uploadDirectory);
		System.out.println("리얼업로드 파쓰======>>>>>" + realUploadPath);
		String newFileName = "";
		if (!originalFileName.isEmpty()) {
			// 실질적인 (믈리적인) 경로
			profile.write(realUploadPath + File.separator + originalFileName);
			String firstFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
			String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); // asdasda.jpg 그리고 asdasdasd.png라면 .jpg .png를뽑아온다.
			//String now = new SimpleDateFormat("yyyymmdd_HmSS").format(new Date()); //현재시간을 뽑는다.
			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd_HmSS");
			String strNow = simpleDateFormat.format(now);
			newFileName = firstFileName + strNow + ext;
			System.out.println(newFileName);
			File oldFile = new File(realUploadPath + File.separator + originalFileName); 
			File newFile = new File(realUploadPath + File.separator + newFileName);
			oldFile.renameTo(newFile);
		}
		MemberDao memberDao = new MemberDao();
		
		System.out.println(userID);
		System.out.println(userPW);
		System.out.println(userName);
		System.out.println(userEmail);
		System.out.println(tel);
		System.out.println(zipCode);
		System.out.println(address);
		System.out.println(profile);
		System.out.println(partHeader);
		
		
		memberDao.imageUpload(profile, request);
		
//		MemberDto memberDto = new MemberDto();
//		memberDto.setId(userID);
//		memberDto.setPassword(userPW);
//		memberDto.setName(userName);
//		memberDto.setEmail(userEmail);
//		memberDto.setTel(tel);
//		memberDto.setPostCode(zipCode);
//		memberDto.setAddress(address);
//		memberDto.setDetailAddress(detailAddress);
//		memberDto.setProfile(newFileName);
//		
//		int result = memberDao.insertMember(memberDto);
//		if(result > 0) {
//			ModalDto modalDto = new ModalDto("show", "회원가입성공!!!");
//			HttpSession session = request.getSession();
//			session.setAttribute("modalDto", modalDto);
//			response.sendRedirect("../member/login");
//		}else {
//			response.sendRedirect("../member/insert");
//		}
	}

}
