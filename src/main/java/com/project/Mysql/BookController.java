package com.project.Mysql;

import com.project.Mysql.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @RequestMapping("/book")
    @ResponseBody
    public String getBooks() {
        return "Books";
    }
}
