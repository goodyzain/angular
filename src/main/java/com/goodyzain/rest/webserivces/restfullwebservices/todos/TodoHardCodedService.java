package com.goodyzain.todos;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter,"goodyzain","Need to complete Angular", new Date(),false));
        todos.add(new Todo(++idCounter,"nawaz","Need to learn quran", new Date(),false));
        todos.add(new Todo(++idCounter,"saniya","Need to learn kannada", new Date(),false));
        todos.add(new Todo(++idCounter,"azhaan","Need to learn arabic", new Date(),false));
        todos.add(new Todo(++idCounter,"fatima","Need to prepare vada pav", new Date(),false));
    }

    public  List<Todo> findAll(){
        return todos;
    }

    public ResponseEntity<Void> deleteById(String username, long id){
        Todo todo = findById(id);
        if(todo==null) return null;
        if(todos.remove(todo)){
            return ResponseEntity.noContent().build();
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    public Todo save(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);
        }else{
            deleteById("goodyzain",todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

}
