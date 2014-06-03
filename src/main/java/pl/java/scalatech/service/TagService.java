package pl.java.scalatech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.java.scalatech.entity.Tag;

/**
 * @author przodownik
 * Module name :    mvcSpringKata
 * Creating time :  3 cze 2014
 */
public interface TagService {
    Page<Tag> getAll(Pageable pageable);
    Tag saveTag(Tag tag);
    Tag findById(long tagId);
    void remove(Tag tag);
}
