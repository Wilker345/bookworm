package ifce.maracanau.computacao.tjw.bookworm.service;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Annotation;
import ifce.maracanau.computacao.tjw.bookworm.repository.AnnotationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnotationService {
    AnnotationRepository annotationRepository;
    @Autowired
    AnnotationService(AnnotationRepository annotationRepository) {
        this.annotationRepository = annotationRepository;
    }

    public List<Annotation> getAllAnnotations() {
        return annotationRepository.findAll();
    }
    public Annotation getAnnotation(long id) throws TupleNotFoundException {
        Optional<Annotation> annotation = annotationRepository.findById(id);
        if (annotation.isEmpty()) {
            throw new TupleNotFoundException("Annotation", "Não existe instância com id = " + id);
        } else {
            return annotation.get();
        }
    }
    public Annotation postAnnotation(Annotation annotation){
        annotationRepository.save(annotation);
        return annotation;
    }
    public Annotation updateAnnotation(long id, Annotation updatedAnnotation) throws EntityNotFoundException {
        Annotation annotation = annotationRepository.getReferenceById(id);
        annotation.setText(updatedAnnotation.getText());
        annotation.setBook(updatedAnnotation.getBook());
        annotation.setTagList(updatedAnnotation.getTagList());
        annotationRepository.save(annotation);
        return annotation;
    }
    public void deleteAnnotation(long id) throws EntityNotFoundException {
        Annotation annotation = annotationRepository.getReferenceById(id);
        annotationRepository.delete(annotation);
    }

}

