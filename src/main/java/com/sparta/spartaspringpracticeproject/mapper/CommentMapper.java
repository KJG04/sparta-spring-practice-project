package com.sparta.spartaspringpracticeproject.mapper;

import com.sparta.spartaspringpracticeproject.dto.CommentResponseDto;
import com.sparta.spartaspringpracticeproject.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResponseDto toCommentResponseDto(Comment comment);
}
