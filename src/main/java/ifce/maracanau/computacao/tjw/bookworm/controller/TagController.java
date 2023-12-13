package ifce.maracanau.computacao.tjw.bookworm.controller;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Tag;
import ifce.maracanau.computacao.tjw.bookworm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO restante do metodos do controller de tag
@Controller
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
    @PostMapping("/save")
    public String postTag(@ModelAttribute("tag") Tag tag) {
        tagService.postTag(tag);
        return "redirect:/home";
    }

    @PutMapping("/{id}")
    public Tag putTag(@PathVariable long id, @RequestBody Tag newTag) {
        return tagService.updateTag(id, newTag);
    }

    @GetMapping("/delete")
    public String deleteTag(@RequestParam long id) {
        tagService.deleteTag(id);
        return "redirect:/home";
    }
}
