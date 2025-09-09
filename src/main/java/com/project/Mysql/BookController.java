package com.project.Mysql;

import java.util.List;
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
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/author")
    public List<Book> getBookByAuthor(@RequestParam("author") String author) {
        String authorName = author.trim();
        return repository.findByAuthorIgnoreCase(authorName);
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
