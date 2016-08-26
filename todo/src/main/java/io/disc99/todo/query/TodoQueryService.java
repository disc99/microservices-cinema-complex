package io.disc99.todo.query;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoQueryService {

    TodoDao todoDao;

    public TodoDto findById(String id) {
        return todoDao.findById(id);
    }
}
