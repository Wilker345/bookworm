package ifce.maracanau.computacao.tjw.bookworm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Annotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, columnDefinition = "TEXT NOT NULL")
    private String text;
    private int page;
    @ManyToOne
    @JsonBackReference
    private Book book;
    @ManyToMany
    private List<Tag> tagList;

    public Annotation() {

    }

    public Annotation(String text, int page, Book book, List<Tag> tagList) {
        this.text = text;
        this.page = page;
        this.book = book;
        this.tagList = tagList;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
