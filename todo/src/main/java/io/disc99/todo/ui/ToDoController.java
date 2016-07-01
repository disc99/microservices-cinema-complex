package io.disc99.todo.ui;

import io.disc99.archetype.Identify;
import io.disc99.todo.application.Add;
import io.disc99.todo.application.Do;
import io.disc99.todo.application.Modify;
import io.disc99.todo.application.TodoService;
import io.disc99.todo.domain.Doing;
import io.disc99.todo.domain.TodoList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TodoController {

    TodoService todoService;

    @PostMapping("/add")
    void add(String doing) {
        todoService.add(new Add(new Doing(doing)));
    }

    @PutMapping("/modify")
    void modify(String id, String doing) {
        todoService.modify(new Modify(new Identify(id), new Doing(doing)));
    }

    @PostMapping("/do")
    void done(String id) {
        todoService.doit(new Do(new Identify(id)))
    }

}
