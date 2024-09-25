package com.example.minilibrary.service;

import com.example.minilibrary.model.Book;
import com.example.minilibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public List<Book> filterBooksByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<Book> filterBooksByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<Book> filterBooksByYear(int year) {
        return repository.findByReleaseYear(year);
    }

    public List<Book> filterBooksByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    public List<Book> filterBooksByRating(int rating) {
        return repository.findByRating(rating);
    }

    public void updateRating(int id, int rating) {
        repository.updateBookRating(id, rating);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(int id) {
        return repository.findById(id).orElse(null);
    }
}
