package com.example.Lab02.controller;

import com.example.Lab02.model.Book;
import com.example.Lab02.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")

public class BookController {

    @GetMapping("/books")
    public List<Book> getBooks() {

        return Arrays.asList(new Book (2025, "J2EE", "Kim Nghi"));
    }

}
