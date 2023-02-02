package com.example.ToDoListApp.controller;


import com.example.ToDoListApp.model.ToDo;
import com.example.ToDoListApp.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListController {
    private final ToDoService toDoService;

    public ListController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/")
    public List<ToDo> getAllList(){
        return toDoService.findAll().stream().collect(Collectors.toList());
    }

   @PostMapping("/post")
    public ResponseEntity<HttpStatus> addToDo(@RequestBody ToDo toDo){
        toDoService.save(toDo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteToDo(@PathVariable("id") int id){
        toDoService.deleteById(id);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(value = "update/{id}/")
    public ResponseEntity<HttpStatus> updateToDo (@PathVariable("id") int id, @RequestBody ToDo todo) throws Exception {
        toDoService.updateById(id, todo);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
