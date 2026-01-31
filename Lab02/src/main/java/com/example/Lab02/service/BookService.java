package com.example.Lab02.service;

import com.example.Lab02.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private List<Book> books = new ArrayList<>(List.of(
            new Book (1, "Lap Trinh Java", "Tran thi Kim Nghi"),
            new Book (2, "Truyen Kieu", "Nguyen Kim Nghi"),
            new Book (3, "Bong Da", "Vo Nghi")
    ));

    public List<Book> getAllBook() {
        return books;
    }

    public Book getBookById(int id){
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void addBook(Book book){
        books.add(book);
    }
}
