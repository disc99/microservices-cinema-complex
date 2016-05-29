package io.disc99.todo.ui;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

    @PostMapping("/add")
    void add() {}

    @PutMapping("/modify")
    void modify() {}

    @PostMapping("/do")
    void done() {}

}
