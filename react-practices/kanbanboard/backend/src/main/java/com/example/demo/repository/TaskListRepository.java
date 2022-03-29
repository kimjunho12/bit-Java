package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Integer updateStatus(Long no, String done) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("no", no);
        map.put("done", done);

        return sqlSession.update("task.updateStatus", map);
    }

    public Integer addTask(TaskVo task) {
        return sqlSession.insert("task.addTask", task);
    }

    public Integer deleteTask(Long no) {
        return sqlSession.delete("task.deleteTask", no);
    }
}
