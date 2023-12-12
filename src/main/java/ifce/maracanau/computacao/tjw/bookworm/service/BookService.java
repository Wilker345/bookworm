package ifce.maracanau.computacao.tjw.bookworm.service;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Book;
import ifce.maracanau.computacao.tjw.bookworm.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookRepository bookRepository;
    @Autowired
    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book getBook(long id) throws TupleNotFoundException {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new TupleNotFoundException("Book", "Não existe instância com id = " + id);
        } else {
            return book.get();
        }
    }
    public Book postBook(Book book){
        bookRepository.save(book);
        return book;
    }
    public Book updateBook(long id, Book updatedBook) throws EntityNotFoundException {
        Book book = bookRepository.getReferenceById(id);
        book.setName(updatedBook.getName());
        book.setAuthorName(updatedBook.getAuthorName());
        book.setPageQuantity(updatedBook.getPageQuantity());
        bookRepository.save(book);
        return book;
    }
    public void deleteBook(long id) throws EntityNotFoundException {
        Book book = bookRepository.getReferenceById(id);
        bookRepository.delete(book);
    }

}
