package com.example.demo.repository;

import java.util.List;

import com.example.demo.vo.CardVo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CardListRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<CardVo> findAll() {
        return sqlSession.selectList("card.findAll");
    }
}
