package ifce.maracanau.computacao.tjw.bookworm.repository;

import ifce.maracanau.computacao.tjw.bookworm.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
