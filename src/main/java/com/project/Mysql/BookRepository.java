package com.project.Mysql;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorIgnoreCase(String author);
    List<Book> findByTitleIgnoreCase(String title);
}
