package ru.golikov.activity_example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.golikov.activity_example.dto.PostValueDto;
import ru.golikov.activity_example.dto.TaskDto;
import ru.golikov.activity_example.service.ProcessService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProcessController {
    private final ProcessService processService;

    @PostMapping("/start")
    public ResponseEntity<?> start(@RequestBody PostValueDto postValueDto) {
        processService.startProcess(postValueDto);
        return new ResponseEntity<>("Process started", HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getTasks() {
        return new ResponseEntity<>(processService.getAllTasks(), HttpStatus.OK);
    }

    @PutMapping("/completetask")
    public ResponseEntity<?> completeTask(@RequestBody TaskDto task) {
        processService.completeTask(task);
        return new ResponseEntity<>("задача(id = "+ task.getId() + ") выполнена", HttpStatus.OK);
    }

    @GetMapping("/result")
    public ResponseEntity<List<TaskDto>> result() {
        return new ResponseEntity<>(processService.getResult(), HttpStatus.OK);
    }
}
