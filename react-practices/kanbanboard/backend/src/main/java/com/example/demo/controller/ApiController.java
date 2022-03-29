package com.example.demo.controller;

import com.example.demo.dto.JsonResult;
import com.example.demo.repository.CardListRepository;
import com.example.demo.repository.TaskListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

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
}
