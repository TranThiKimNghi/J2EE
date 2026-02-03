package com.example.Lab03.service;
import com.example.Lab03.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public void updateBook(Book updatedBook) {
        books.stream()
                .filter(book -> book.getId().equals(updatedBook.getId()))
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                });
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

}
//package com.example.Lab03.service;
//
//import com.example.Lab03.model.Book;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class BookService {
//    private List<Book> books = new ArrayList<>(List.of(
//            new Book (1, "Lap Trinh Java", "Tran thi Kim Nghi"),
//            new Book (2, "Truyen Kieu", "Nguyen Kim Nghi"),
//            new Book (3, "Bong Da", "Vo Nghi")
//    ));
//
//    public List<Book> getAllBook() {
//        return books;
//    }
//
//    public Book getBookById(int id){
//        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
//    }
//
//    public void addBook(Book book){
//        books.add(book);
//    }
//}
