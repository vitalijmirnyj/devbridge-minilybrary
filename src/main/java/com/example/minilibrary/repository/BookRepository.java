package com.example.minilibrary.repository;

import com.example.minilibrary.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByTitle(String title);

    public List<Book> findByAuthor(String author);

    public List<Book> findByReleaseYear(int year);

    public List<Book> findByGenre(String genre);

    public List<Book> findByRating(int rating);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.rating = ?2 WHERE b.id = ?1")
    public void updateBookRating(int id, int rating);
}
