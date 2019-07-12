package com.oxane.todo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todos")
public class TodoController {

	@Autowired
	private TodoService todoservice;

	@GetMapping()
	public List<Todo> getTodos() {
		return todoservice.getTodos();
	}

	@PostMapping()
	public Todo create(@Valid @RequestBody Todo todo) {
		return todoservice.createTodo(todo);
	}
	
	@PutMapping
	public Todo update(@Valid @RequestBody Todo todo) {
		return todoservice.createTodo(todo);
	}
	
	@PutMapping("toggle-all") 
	public List<Todo> selectAllTodos(@RequestBody List<Todo> todos) {
		return todoservice.selectAllTodos(todos);
	}

	@DeleteMapping("delete")
	public void deleteAll() {
		todoservice.deleteAllTodo();
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		todoservice.deleteTodo(id);
	}
}
