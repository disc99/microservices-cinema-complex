package io.disc99.todo.ui;

import io.disc99.todo.application.Add;
import io.disc99.todo.application.Do;
import io.disc99.todo.application.Modify;
import io.disc99.todo.application.TodoService;
import io.disc99.todo.domain.Added;
import io.disc99.todo.domain.Doing;
import io.disc99.todo.domain.TodoId;
import io.disc99.todo.domain.TodoList;
import io.disc99.todo.query.TodoDto;
import io.disc99.todo.query.TodoQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoController {

    TodoService todoService;
    TodoQueryService todoQueryService;

    @PostMapping("/add")
    void add(@RequestBody AddRequest request) {
//
//        TodoId id = Application.start()
//                .when(id -> )
//                .then((Added event) -> event.todoId())
//
//
//
//        TodoId todoId = new TodoId();
////        commandBus.dispatch(add);
//        new TodoList().add(todoId,new Doing(add.doing()));
//        return todoId;

        todoService.add(new Add(request.getDoing()));
    }

    @PutMapping("/modify")
    void modify(@RequestBody ModifyRequest request) {
        todoService.modify(new Modify(request.getId(), request.getDoing()));
    }

    @PostMapping("/do")
    void done(String id) {
        todoService.doit(new Do(id));
    }

    @GetMapping("/todos/{id}")
    TodoDto findById(@PathVariable String id) {
        return todoQueryService.findById(id);
    }

    @GetMapping("/todos")
    List<TodoDto> findAll() {
        return todoQueryService.findAll();
    }
}
