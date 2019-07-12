package com.oxane.todo;

import java.util.List;

import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

	@Autowired
	private TodoRespository todoRespository;

	@Transactional(readOnly = true)
	public List<Todo> getTodos() {
		return todoRespository.findAll();
	}

	@Transactional
	public Todo createTodo(Todo todo) {
		return todoRespository.save(todo);
	}

	@Transactional
	public void deleteTodo(Integer id) {
		todoRespository.deleteById(id);
	}

	@Transactional
	public Todo updateTodo(Todo todo) {
		return todoRespository.save(todo);
	}
	
	@Transactional
	public List<Todo> selectAllTodos(List<Todo> todos) {
		return todoRespository.saveAll(todos);
	}

	public void deleteAllTodo() {
		todoRespository.deleteAll();
	}

	
}
