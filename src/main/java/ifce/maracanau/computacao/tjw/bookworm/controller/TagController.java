package ifce.maracanau.computacao.tjw.bookworm.controller;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Tag;
import ifce.maracanau.computacao.tjw.bookworm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO restante do metodos do controller de tag
@RestController
@RequestMapping("/tags")
public class TagController {
    TagService tagService;

    @Autowired
    TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("")
    public List<Tag> getTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public Tag getTag(@PathVariable long id) throws TupleNotFoundException {
        return tagService.getTag(id) ;
    }
    @PostMapping("")
    public Tag postTag(@RequestBody Tag tag) {
        return tagService.postTag(tag);
    }

    @PutMapping("/{id}")
    public Tag putTag(@PathVariable long id, @RequestBody Tag newTag) {
        return tagService.updateTag(id, newTag);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable long id) {
        tagService.deleteTag(id);
    }
}
