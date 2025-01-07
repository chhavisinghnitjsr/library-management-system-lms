package com.example.library.demo.controller;

import com.example.library.demo.entity.BookResponseEntity;
import com.example.library.demo.entity.BookRequestEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Scope("singleton")
@RequestMapping("/lms/api/v1/book")
public class BookController {

    private final ConcurrentMap<Integer, BookResponseEntity> book_map = new ConcurrentHashMap<>();

    @GetMapping("/checkHealth/lms/book")
    public String checkHealth() {
        return "Connection successfully!";
    }

    // Store the last book request
    private BookRequestEntity lastBookRequest;
    private int  countId = 0;

    @PostMapping("/add")
    public ResponseEntity<BookResponseEntity> bookRequest(@RequestBody BookRequestEntity bookRequestEntity) {
        this.lastBookRequest = bookRequestEntity;
       /*
        if (book_map.containsKey(bookRequestEntity.getUserId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // User already exists
        }*/
        BookResponseEntity bookResponseEntity = new BookResponseEntity();
        bookResponseEntity.setBookId(++countId);
        bookResponseEntity.setTitle(lastBookRequest.getTitle());
        bookResponseEntity.setStatus("Book registered successfully");
        bookResponseEntity.setDescription(lastBookRequest.getDescription());
        bookResponseEntity.setAddedBy(lastBookRequest.getAddedBy());
        bookResponseEntity.setLanguage(lastBookRequest.getLanguage());
        bookResponseEntity.setIsAvailable(1);
        long currentMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentMillis);
        bookResponseEntity.setAddedAt(currentDate);
        long currentUpdMillis = System.currentTimeMillis();
        Date updDate = new Date(currentUpdMillis);
        bookResponseEntity.setUpdatedAt(updDate);
        bookResponseEntity.setIsDeleted("false");
        System.out.println("count_id is: "+countId);
        book_map.put(countId,bookResponseEntity);
        System.out.println("book is  added: ");
        System.out.println("the current book map is : "+book_map);
        return ResponseEntity.ok(bookResponseEntity);
    }

    @GetMapping("/fetch/{book_id}")
    public ResponseEntity<BookResponseEntity> getBookById(@PathVariable("book_id") int book_id) {
        BookResponseEntity bookResponseEntity = new BookResponseEntity();
        for(Map.Entry<Integer,BookResponseEntity> entry : book_map.entrySet()) {
            int key = entry.getKey();
            if(key == book_id) {
                bookResponseEntity = entry.getValue();
            }
        }
        return ResponseEntity.ok(bookResponseEntity);
    }

    @GetMapping("/fetch")
    public ResponseEntity<Map<Integer,BookResponseEntity>> getAllBook() {
        System.out.println("The book map is: "+book_map);
        return ResponseEntity.ok(book_map);
    }

    @PutMapping("/update/{book_id}")
    public ResponseEntity<BookResponseEntity> updateBook(@RequestBody BookResponseEntity bookResponseEntity,
            @PathVariable("book_id") Integer book_id) {

        System.out.println("Enter the book update method: " + book_map);
        BookResponseEntity update_book = book_map.get(book_id);
        if (!book_map.containsKey(book_id)) {
            throw new RuntimeException("Book not found with id: " + book_id);
        }
        else if (bookResponseEntity.getTitle() != null) {
            update_book.setTitle(bookResponseEntity.getTitle());
        }
        else if (bookResponseEntity.getAuthor() != null) {
            update_book.setAuthor(bookResponseEntity.getAuthor());
        }
        else if (bookResponseEntity.getAddedBy() != null) {
            update_book.setAddedBy(bookResponseEntity.getAddedBy());
        }
        else if (bookResponseEntity.getDescription() != null) {
            update_book.setDescription(bookResponseEntity.getDescription());
        }
        else if (bookResponseEntity.getLanguage() != null) {
            update_book.setLanguage(bookResponseEntity.getLanguage());
        }
        update_book.setStatus("Book updated successfully");
        update_book.setUpdatedAt(new Date());
        book_map.put(book_id, update_book); // Update map
        return ResponseEntity.ok(update_book);
    }

    @DeleteMapping("delete/{book_id}")
    public String deleteBookById(@PathVariable("book_id") Integer book_id) {
        BookResponseEntity delete_book = new BookResponseEntity();
        for (Map.Entry<Integer, BookResponseEntity> book : book_map.entrySet()) {

            int id = book.getKey();
            if (id == book_id) {
                delete_book = book.getValue();
            }
            book_map.remove(delete_book);
        }
        return "book deleted successfully";
    }


}
