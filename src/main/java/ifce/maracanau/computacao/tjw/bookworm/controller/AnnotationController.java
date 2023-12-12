package ifce.maracanau.computacao.tjw.bookworm.controller;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Annotation;
import ifce.maracanau.computacao.tjw.bookworm.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO restante das funcoes do controller de annotation
@RestController
@RequestMapping("/annotations")
public class AnnotationController {
    AnnotationService annotationService;

    @Autowired
    AnnotationController(AnnotationService annotationService) {
        this.annotationService = annotationService;
    }

    @GetMapping("")
    public List<Annotation> getAnnotations() {
        return annotationService.getAllAnnotations();
    }

    @GetMapping("/{id}")
    public Annotation getAnnotation(@PathVariable long id) throws TupleNotFoundException {
        return annotationService.getAnnotation(id) ;
    }
    @PostMapping("")
    public Annotation postAnnotation(@RequestBody Annotation annotation) {
        return annotationService.postAnnotation(annotation);
    }

    @PutMapping("/{id}")
    public Annotation putAnnotation(@PathVariable long id, @RequestBody Annotation newAnnotation) {
        return annotationService.updateAnnotation(id, newAnnotation);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnotation(@PathVariable long id) {
        annotationService.deleteAnnotation(id);
    }
}
