package com.project.Mysql.books;

import com.project.Mysql.user.Role;
import com.project.Mysql.user.User;
import com.project.Mysql.utils.AuthUtils;
import com.project.Mysql.utils.CookiesUtils;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        if (!cookieUtils.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/author")
    public List<Book> getBookByAuthor(@RequestParam("author") String author) {
        String authorName = author.trim();
        return repository.findByAuthorIgnoreCase(authorName);
    }

    @GetMapping("/year")
    public List<Book> getBookByYear(@RequestParam("publish_year") int year) {
        return repository.findByYear(year);
    }

    @PostMapping("")
    public Book updateBook(
        @RequestParam("title") String title,
        @RequestParam("author") String author,
        @RequestParam("year") int year
    ) {
        Book book = new Book(title, author, year);
        return repository.save(book);
    }
}
