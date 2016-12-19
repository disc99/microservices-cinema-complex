package io.disc99.todo.ui;

import io.disc99.todo.application.Add;
import io.disc99.todo.application.Do;
import io.disc99.todo.application.Modify;
import io.disc99.todo.application.TodoService;
import io.disc99.todo.domain.TodoId;
import io.disc99.todo.query.TodoDto;
import io.disc99.todo.query.TodoQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ToDoController {

    TodoService todoService;
    TodoQueryService todoQueryService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    Map<String, String> add(@RequestBody AddRequest request) {
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

        TodoId id = todoService.add(new Add(request.getDoing()));
        return Collections.singletonMap("id", id.value());
    }

    @PutMapping("/modify")
    void modify(@RequestBody ModifyRequest request) {
        todoService.modify(new Modify(request.getId(), request.getDoing()));
    }

    @PostMapping("/do")
    void done(@RequestBody DoRequest request) {
        todoService.doit(new Do(request.getId()));
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
