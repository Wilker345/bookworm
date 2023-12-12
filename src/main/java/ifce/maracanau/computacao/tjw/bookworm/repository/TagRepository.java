package ifce.maracanau.computacao.tjw.bookworm.repository;

import ifce.maracanau.computacao.tjw.bookworm.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
