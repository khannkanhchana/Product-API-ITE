package com.example.productsampleapi.service;

import com.example.productsampleapi.dto.TagRequest;
import com.example.productsampleapi.dto.TagResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {

    // request, response
    TagResponse createTag(TagRequest request);
    Page<TagResponse> getAllTags(Pageable pageable);
}
