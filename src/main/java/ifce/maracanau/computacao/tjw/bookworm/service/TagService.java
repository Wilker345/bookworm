package ifce.maracanau.computacao.tjw.bookworm.service;

import ifce.maracanau.computacao.tjw.bookworm.controller.exception.TupleNotFoundException;
import ifce.maracanau.computacao.tjw.bookworm.model.Tag;
import ifce.maracanau.computacao.tjw.bookworm.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    TagRepository tagRepository;
    @Autowired
    TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
    public Tag getTag(long id) throws TupleNotFoundException {
        Optional<Tag> tag = tagRepository.findById(id);
        if (tag.isEmpty()) {
            throw new TupleNotFoundException("Tag", "Não existe instância com id = " + id);
        } else {
            return tag.get();
        }
    }
    public Tag postTag(Tag tag){
        tagRepository.save(tag);
        return tag;
    }
    public Tag updateTag(long id, Tag updatedTag) throws EntityNotFoundException {
        Tag tag = tagRepository.getReferenceById(id);
        tag.setName(updatedTag.getName());
        tag.setAnnotationList(updatedTag.getAnnotationList());
        tagRepository.save(tag);
        return tag;
    }
    public void deleteTag(long id) throws EntityNotFoundException {
        Tag tag = tagRepository.getReferenceById(id);
        tagRepository.delete(tag);
    }
}
