package io.disc99.todo.query;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TodoQueryService {

    TodoDao todoDao;

    public TodoDto findById(String id) {
        return todoDao.findById(id);
    }

    public List<TodoDto> findAll() {
        return todoDao.findAll();
    }
}
