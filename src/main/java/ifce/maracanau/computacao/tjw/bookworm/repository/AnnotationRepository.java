package ifce.maracanau.computacao.tjw.bookworm.repository;

import ifce.maracanau.computacao.tjw.bookworm.model.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Long> {
}
