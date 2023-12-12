package ifce.maracanau.computacao.tjw.bookworm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name", unique = true, nullable = false)
    private String name;
    @Column(name="page_quantity")
    private int pageQuantity;
    @Column(name="author_name")
    private String authorName;
    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private List<Annotation> annotationList;

    public Book(String name, int pageQuantity, String authorName) {
        this.name = name;
        this.pageQuantity = pageQuantity;
        this.authorName = authorName;
    }

    public Book() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Annotation> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(List<Annotation> annotationList) {
        this.annotationList = annotationList;
    }
}
