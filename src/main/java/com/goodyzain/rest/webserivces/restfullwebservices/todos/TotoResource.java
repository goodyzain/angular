package com.goodyzain.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TotoResource {

    @Autowired
    private TodoHardCodedService todoHardCodedService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
         return todoHardCodedService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getAllTodos(@PathVariable String username,@PathVariable long id){
        return todoHardCodedService.findById(id);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable long id,
                           @RequestBody Todo todo){
        Todo todoUpdate = todoHardCodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username,@RequestBody Todo todo){
        Todo todoUpdate = todoHardCodedService.save(todo);
        URI  uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoUpdate.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }




    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id){
       return todoHardCodedService.deleteById(username,id);
    }

    {

    }
}
