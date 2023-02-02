package com.example.ToDoListApp.service;

import com.example.ToDoListApp.model.ToDo;
import com.example.ToDoListApp.repository.ToDoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository  toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Transactional
    public void save(ToDo toDo) {
        toDoRepository.save(toDo);
    }
    @Transactional
    public void deleteById(int id) {
        toDoRepository.deleteById(id);
    }
    @Transactional
    public void updateById(int id, ToDo toDo) throws Exception {
        ToDo toDo1 = toDoRepository.findById(id).orElseThrow(Exception::new);
        toDoRepository.save(toDo1);
    }
}
