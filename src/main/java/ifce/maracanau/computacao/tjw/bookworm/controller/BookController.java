package ifce.maracanau.computacao.tjw.bookworm.controller;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Book;
import ifce.maracanau.computacao.tjw.bookworm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    @PostMapping("/save")
    public String postBook(@ModelAttribute("book") Book book) {
        bookService.postBook(book);
        return "redirect:/home";
    }

    @PutMapping("/{id}")
    public Book putBook(@PathVariable long id, @RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") long id) {
        bookService.deleteBook(id);
        return "redirect:/home";
    }

}
