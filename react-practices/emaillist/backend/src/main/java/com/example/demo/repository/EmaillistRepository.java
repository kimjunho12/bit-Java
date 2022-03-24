package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.EmaillistVo;

@Repository
public class EmaillistRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<EmaillistVo> findAll(String keyword) {
		return sqlSession.selectList("emaillist.findAll", keyword);
	}
	
	public Boolean insert(EmaillistVo vo) {
		return sqlSession.insert("emaillist.insert", vo) == 1;		
	}
}
