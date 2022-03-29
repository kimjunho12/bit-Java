package com.example.demo.repository;

import java.util.List;

import com.example.demo.vo.TaskVo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskListRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<TaskVo> findAll(Long no) {
        return sqlSession.selectList("task.findAll", no);
    }
}
