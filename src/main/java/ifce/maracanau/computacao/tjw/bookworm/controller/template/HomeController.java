package ifce.maracanau.computacao.tjw.bookworm.controller.template;

import ifce.maracanau.computacao.tjw.bookworm.model.Annotation;
import ifce.maracanau.computacao.tjw.bookworm.model.Book;
import ifce.maracanau.computacao.tjw.bookworm.model.Tag;
import ifce.maracanau.computacao.tjw.bookworm.service.AnnotationService;
import ifce.maracanau.computacao.tjw.bookworm.service.BookService;
import ifce.maracanau.computacao.tjw.bookworm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private BookService bookService;
    private AnnotationService annotationService;
    private TagService tagService;

    @Autowired
    HomeController(BookService bookService, AnnotationService annotationService, TagService tagService) {
        this.bookService = bookService;
        this.annotationService = annotationService;
        this.tagService = tagService;
    }
    @RequestMapping ("/home")
    public String home(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        List<Annotation> annotationList = annotationService.getAllAnnotations();
        List<Tag> tagList = tagService.getAllTags();

        model.addAttribute("books", bookList);
        model.addAttribute("annotations", annotationList);
        model.addAttribute("tags", tagList);
        return "home";
    }

    @RequestMapping("/book-form")
    public String bookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book-form";
    }

    @RequestMapping("/annotation-form")
    public String annotationForm(Model model) {
        Annotation annotation = new Annotation();
        model.addAttribute("annotation", annotation);
        return "annotation-form";
    }

    @RequestMapping("/tag-form")
    public String form(Model model) {
        Tag tag = new Tag();
        model.addAttribute(tag);
        return "tag-form";
    }

    @RequestMapping("/book-edit-form")
    public String editBookForm(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("books", bookList);
        return "book-edit-form";
    }

    @RequestMapping("/annotation-edit-form")
    public String editAnnotationForm(Model model) {
        List<Annotation> annotationList = annotationService.getAllAnnotations();
        model.addAttribute("annotations", annotationList);
        return "annotation-edit-form";
    }

    @RequestMapping("/tag-edit-form")
    public String editTagForm(Model model) {
        List<Tag> tagList = tagService.getAllTags();
        model.addAttribute("tags", tagList);
        return "tag-edit-form";
    }

    @RequestMapping("/process-book-form")
    public String processBookForm(@RequestParam("id") int id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "book-form";
    }

    @RequestMapping("/process-annotation-form")
    public String processAnnotationForm(@RequestParam("id") int id, Model model) {
        Annotation annotation = annotationService.getAnnotation(id);
        model.addAttribute("annotation", annotation);
        return "annotation-form";
    }

    @RequestMapping("/process-tag-form")
    public String processTagForm(@RequestParam("id") int id, Model model) {
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag", tag);
        return "tag-form";
    }

}
