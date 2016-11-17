package io.disc99.todo.query;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDto {
    String id;
    String doing;
    LocalDateTime doneAt;
}
