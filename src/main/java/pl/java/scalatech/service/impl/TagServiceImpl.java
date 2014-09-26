package pl.java.scalatech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.scalatech.entity.Tag;
import pl.java.scalatech.repository.TagRepository;
import pl.java.scalatech.service.TagService;

/**
 * @author przodownik
 *         Module name : mvcSpringKata
 *         Creating time : 3 cze 2014
 */
@Service
@Transactional(readOnly = true)
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Page<Tag> getAll(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag findById(long tagId) {
        return tagRepository.findOne(tagId);
    }

    @Override
    @Transactional
    public void remove(Tag tag) {
        tagRepository.delete(tag);
    }

}
