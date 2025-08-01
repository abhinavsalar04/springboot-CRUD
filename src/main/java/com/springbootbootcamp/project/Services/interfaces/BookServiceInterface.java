package com.springbootbootcamp.project.Services.interfaces;

import com.springbootbootcamp.project.Models.Book;
import org.springframework.http.ResponseEntity;

public interface BookServiceInterface {
    public ResponseEntity<Book> addBook(Book book);

    public ResponseEntity<Book> getBookById(int bookId);

   // public ResponseEntity<Book> updateBook(Book book);

    public ResponseEntity<Book> assignStory(int bookId, int storyId);

    public ResponseEntity<Book> unAssignStory(int bookId, int storyId);

    public ResponseEntity<String> removeBook(int bookId);

}
