package com.example.minilibrary.controller;

import com.example.minilibrary.dto.RatingDto;
import com.example.minilibrary.model.Book;
import com.example.minilibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("books")
    public List<Book> filterBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer rating,
            @RequestParam(required = false) String genre) {

        if (title != null) {
            return bookService.filterBooksByTitle(title);
        } else if (year != null) {
            return bookService.filterBooksByYear(year);
        } else if (author != null) {
            return bookService.filterBooksByAuthor(author);
        } else if (rating != null) {
            return bookService.filterBooksByRating(rating);
        } else if (genre != null) {
            return bookService.filterBooksByGenre(genre);
        } else {
            return bookService.getAllBooks();
        }
    }

    @GetMapping("books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PutMapping("books/{id}")
    public void rateBook(@PathVariable("id") int id, @RequestBody RatingDto bookdto) {

        bookService.updateRating(id, bookdto.getRating());
    }
}
