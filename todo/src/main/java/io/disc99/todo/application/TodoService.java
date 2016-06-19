package io.disc99.todo.application;

import io.disc99.todo.domain.TodoList;


public class TodoService {

    TodoList create() {
        return new TodoList();
    }

}
