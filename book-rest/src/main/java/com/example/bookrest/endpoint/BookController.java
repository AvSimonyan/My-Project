package com.example.bookrest.endpoint;

import com.example.bookrest.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/all")
    public ResponseEntity getAllBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("girq 1", "lav girq", 200, "USD"));
        books.add(new Book("girq 2", "vat girq", 400, "USD"));



        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book) {
        System.out.println(book);
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") int id) {
        return new Book("girq 2", "vat girq", 400, "USD");
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") int id) {
        //repository.deleteById();
        //if id not found
        return ResponseEntity.notFound().build();
    }

}
