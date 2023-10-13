package com.mok.dao;

import org.apache.ibatis.session.SqlSession;


import com.mok.dto.MemberDto;
import com.mok.mybatis.MybatisConnectionFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class MemberDao {

	public MemberDto login(MemberDto memberDto) {
		MemberDto loginMember = new MemberDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		System.out.println("맴버디티오 =>>>>" + memberDto);
		loginMember = sqlSession.selectOne("LoginMember",memberDto);
		sqlSession.close();
		
		
		return loginMember;
		
	}

	public int checkID(String checkID) {
		MemberDto checkIDDto = new MemberDto();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		checkIDDto = sqlSession.selectOne("CheckedID", checkID);
		int result = 0;
		if(checkIDDto != null) {
			result = 1;
		}
		return result;
		
	}

	public void imageUpload(Part profile, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String uploadDirectory = "upload";
		System.out.println("다오안 프로필값======>>>>>" + profile);
		System.out.println("다오안 프로필값toString======>>>>>" + profile.toString());
		String partHeader = profile.getHeader("Context-disposition");
		System.out.println("다오안 파트헤더======>>>>>" + partHeader);
		String partHeaderArray[] = partHeader.split("filename=");
		String originalFileName = partHeaderArray[1].trim().replace("\"", "");
//		String realUploadPath = getServletContext().getRealPath(uploadDirectory);
		
		System.out.println("다오안 파트헤더어레이======>>>>>" + partHeaderArray[1]);
		System.out.println("다오안 오리지널파일네임======>>>>>" + originalFileName);
		
	}

	public int insertMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember", memberDto);
		return result;
		
		
	}
	

}
