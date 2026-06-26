package com.example.productsampleapi.mapper;


import com.example.productsampleapi.dto.TagRequest;
import com.example.productsampleapi.dto.TagResponse;
import com.example.productsampleapi.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagResponse toResponse (Tag tag);
    Tag toEntity(TagRequest tagRequest);

}
