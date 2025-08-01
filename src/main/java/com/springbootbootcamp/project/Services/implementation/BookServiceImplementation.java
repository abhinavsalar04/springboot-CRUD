package com.springbootbootcamp.project.Services.implementation;

import com.springbootbootcamp.project.Exceptions.BookNotFoundException;
import com.springbootbootcamp.project.Exceptions.StoryNotFoundException;
import com.springbootbootcamp.project.Models.Book;
import com.springbootbootcamp.project.Models.Story;
import com.springbootbootcamp.project.Repositories.BookRepository;
import com.springbootbootcamp.project.Repositories.StoryRepository;
import com.springbootbootcamp.project.Services.interfaces.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImplementation implements BookServiceInterface {

    private final BookRepository bookRepository;
    private final StoryRepository storyRepository;

    @Autowired
    public BookServiceImplementation(BookRepository bookRepository, StoryRepository storyRepository){
        this.bookRepository = bookRepository;
        this.storyRepository = storyRepository;
    }

    public ResponseEntity<Book> addBook(Book book){
        Book bookResponse = bookRepository.save(book);
        return new ResponseEntity<Book>(bookResponse, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Book> getBookById(int bookId){
        Optional<Book> response = bookRepository.findById(bookId);
        if(response.isEmpty()){
            throw new BookNotFoundException("Book not found with id: " + bookId);
        }
        Book book = response.get();
        return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Book> assignStory(int bookId, int storyId){
       Optional<Book> bookResponse = bookRepository.findById(bookId);
       if(bookResponse.isEmpty()){
           throw new BookNotFoundException("Book not found with id: " + bookId);
       }

       Optional<Story> storyResponse = storyRepository.findById(storyId);

       if(storyResponse.isEmpty()){
           throw new StoryNotFoundException("Book not found with id: " + storyId);
       }
       Book book = bookResponse.get();
       Story story = storyResponse.get();
       book.addStory(story);
       Book updatedBook = bookRepository.save(book);
       return new ResponseEntity<Book>(updatedBook, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Book> unAssignStory(int bookId, int storyId){
        Optional<Book> bookResponse = bookRepository.findById(bookId);
        if(bookResponse.isEmpty()){
            throw new BookNotFoundException("Book not found with id: " + bookId);
        }

        Optional<Story> storyResponse = storyRepository.findById(storyId);

        if(storyResponse.isEmpty()){
            throw new StoryNotFoundException("Book not found with id: " + storyId);
        }
        Book book = bookResponse.get();
        Story story = storyResponse.get();
        book.removeStory(story);
        Book updatedBook = bookRepository.save(book);
        return new ResponseEntity<Book>(updatedBook, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> removeBook(int bookId){
        if (!bookRepository.existsById(bookId)) {
            throw new BookNotFoundException("Book not found with id: " + bookId);
        }
        bookRepository.deleteById(bookId);
        return new ResponseEntity<String>(("Book removed with id: " + bookId), HttpStatus.ACCEPTED);
    }
}
