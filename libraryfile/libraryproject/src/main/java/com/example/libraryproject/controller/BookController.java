package com.example.libraryproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryproject.entity.Book;
import com.example.libraryproject.service.BookService;

@RestController 
@RequestMapping ("/Book")
public class BookController {
    private final BookService bookService;

   
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping 
    public List<Book> saveBook(@RequestBody List<Book> book){
        return bookService.saveBook(book);
    }


    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
/*@DeleteMapping("/{id}")
public void deleteBook(@PathVariable Long id){
    bookService.deletById(id);
}*/
@DeleteMapping("/{id}")
public String deleteid(@PathVariable Long id){
 bookService.deleteByid(id);
 return "Book id deleted";

}
    
}
