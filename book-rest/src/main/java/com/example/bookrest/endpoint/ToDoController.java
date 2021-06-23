package com.example.bookrest.endpoint;

import com.example.bookrest.model.Book;
import com.example.bookrest.model.ToDo;
import com.example.bookrest.model.User;
import com.example.bookrest.security.SecurityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class ToDoController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity getAllTodos() {
//        System.out.println(SecurityService.getCurrentUser());
//        System.out.println(SecurityService.getCurrentUserEmail());

        ResponseEntity<ToDo[]> response = restTemplate.getForEntity(
                "https://jsonplaceholder.typicode.com/todos/",
                ToDo[].class);

        ToDo[] todos = response.getBody();

        return ResponseEntity.ok(todos);
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {

        try {
            ResponseEntity<ToDo> response = restTemplate.getForEntity(
                    "https://jsonplaceholder.typicode.com/todos/" + id,
                    ToDo.class);
            ToDo todo = response.getBody();

            return ResponseEntity.ok(todo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}
