package com.springboot.webapp.firstSpringWebApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {

	private static List<ToDo> todos = new ArrayList<>();
	private static int todosCount = 0;
	static {
		todos.add(new ToDo(++todosCount, "JackSparrow", "Learn how to drive electric boat",
				LocalDate.now().plusMonths(1), false));

		todos.add(new ToDo(++todosCount, "JackSparrow", "Learn Stock market", LocalDate.now().plusMonths(2), false));

		todos.add(new ToDo(++todosCount, "JackSparrow", "Learning SQL", LocalDate.now().plusMonths(3), false));

	}

	public List<ToDo> findByUsername(String username) {

	Predicate<? super ToDo> predicate = todo -> todo.getUsername().equals(username);
	return todos.stream().filter(predicate).toList();

	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++todosCount, username, description, targetDate, done);

		todos.add(todo);

	}

	public void deleteById(int id) {

		// todo.getId()==id
		// todo -> todo.getid()==id

		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid ToDo todo) {
		deleteById(todo.getId());// this is easy way of updating , not an efficient way

		todos.add(todo);

	}

}
