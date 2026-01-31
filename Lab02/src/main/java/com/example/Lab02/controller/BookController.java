package com.example.Lab02.controller;

import com.example.Lab02.model.Book;
import com.example.Lab02.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }


    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
}
