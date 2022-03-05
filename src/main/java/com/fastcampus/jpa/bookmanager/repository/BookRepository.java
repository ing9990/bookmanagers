package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Martin
 * @since 2021/03/31
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategoryIsNull();
    List<Book> findAllByDeletedFalse();
    List<Book> findByCategoryIsNullAndDeletedFalse();

    @Query(value="select b from Book b"
            + " where name = ?1 and createdAt >= ?2 and updatedAt>= ?3 and category is null")
    List<Book> findByNameRecently(String name, LocalDateTime createdAt, LocalDateTime updatedAt);

}
