package com.mok.mybatis;

import java.io.IOException;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MybatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/mok/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			System.out.println("또여기자나");
			e.printStackTrace();
		}
		
		
	}
	
	public static SqlSession getSqlSession() {
		//여기가 commit 설정하느곳
		//auto commit을 할려면 밑에 true를 추가한다.
		return sqlSessionFactory.openSession(true);
		
	}
}

//여기서 config.xml에 들어간다.
//config.xml에서 데이터베이스 연동이 잘되어있는지 그리고 매핑된 xml의 쿼리문도 문제가 없는지 확인까지 해야 실해이된다.
