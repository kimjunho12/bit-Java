package com.example.demo.controller;

import com.example.demo.dto.JsonResult;
import com.example.demo.repository.CardListRepository;
import com.example.demo.repository.TaskListRepository;
import com.example.demo.vo.TaskVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ApiController {

    @Autowired
    private CardListRepository cardListRepository;

    @GetMapping(value = "/api/card")
    public ResponseEntity<JsonResult> read() {
        return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(cardListRepository.findAll()));
    }

    @Autowired
    private TaskListRepository taskListRepository;

    @GetMapping(value = "/api/task")
    public ResponseEntity<JsonResult> read(@RequestParam String cardNo) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(JsonResult.success(taskListRepository.findAll(Long.parseLong(cardNo))));
    }

    @PutMapping(value = "/api/task/{no}")
    public ResponseEntity<JsonResult> update(@PathVariable("no") Long no, @RequestParam String done) {
        return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(taskListRepository.updateStatus(no, done)));
    }

    @PostMapping(value = "/api/task/add")
    public ResponseEntity<JsonResult> add(@RequestBody TaskVo task) {
        return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(taskListRepository.addTask(task)));
    }

}
