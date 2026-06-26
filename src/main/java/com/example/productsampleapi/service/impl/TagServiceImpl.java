package com.example.productsampleapi.service.impl;

import com.example.productsampleapi.dto.TagRequest;
import com.example.productsampleapi.dto.TagResponse;
import com.example.productsampleapi.mapper.TagMapper;
import com.example.productsampleapi.repository.TagRepository;
import com.example.productsampleapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    // inject bean
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;
    // then make constructor
//    public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper) {
//        TagRepository = tagRepository;
//        this.tagMapper = tagMapper;
//    }


    @Override
    public TagResponse createTag(TagRequest request) {
        var tag = tagMapper.toEntity(request);
        return tagMapper.toResponse(tagRepository.save(tag));
    }

    @Override
    public Page<TagResponse> getAllTags(Pageable pageable) {
        return tagRepository
                .findAll(pageable)
                .map(tagMapper::toResponse);
    }
}
