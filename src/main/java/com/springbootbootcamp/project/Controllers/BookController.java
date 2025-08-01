package com.springbootbootcamp.project.Controllers;

import com.springbootbootcamp.project.Models.Book;
import com.springbootbootcamp.project.Services.implementation.BookServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookServiceImplementation bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId){
        return bookService.getBookById(bookId);
    }

    @PutMapping("/assign-story/book/{bookId}/story/{storyId}")
    public ResponseEntity<Book> assignStory(@PathVariable int bookId, @PathVariable int storyId){
        return bookService.assignStory(bookId, storyId);
    }

    @PutMapping("/unassign-story/book/{bookId}/story/{storyId}")
    public ResponseEntity<Book> unAssignStory(@PathVariable int bookId, @PathVariable int storyId){
        return bookService.unAssignStory(bookId, storyId);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> removeBook(@PathVariable int bookId){
        return bookService.removeBook(bookId);
    }
}
