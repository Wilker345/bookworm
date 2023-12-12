package ifce.maracanau.computacao.tjw.bookworm.controller;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Book;
import ifce.maracanau.computacao.tjw.bookworm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO restante das funcoes do controller de book
@RestController
@RequestMapping("/books")
public class BookController {
    BookService bookService;

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) throws TupleNotFoundException {
        return bookService.getBook(id) ;
    }
    @PostMapping("")
    public Book postBook(@RequestBody Book book) {
        return bookService.postBook(book);
    }

    @PutMapping("/{id}")
    public Book putBook(@PathVariable long id, @RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

}
