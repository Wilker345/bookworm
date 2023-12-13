package ifce.maracanau.computacao.tjw.bookworm.controller;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Annotation;
import ifce.maracanau.computacao.tjw.bookworm.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO restante das funcoes do controller de annotation
@Controller
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
    @PostMapping("/save")
    public String postAnnotation(@ModelAttribute("annotation") Annotation annotation) {
        annotationService.postAnnotation(annotation);
        return "redirect:/home";
    }

    @PutMapping("/{id}")
    public Annotation putAnnotation(@PathVariable long id, @RequestBody Annotation newAnnotation) {
        return annotationService.updateAnnotation(id, newAnnotation);
    }

    @GetMapping("/delete")
    public String deleteAnnotation(@RequestParam long id) {
        annotationService.deleteAnnotation(id);
        return "redirect:/home";
    }

}
