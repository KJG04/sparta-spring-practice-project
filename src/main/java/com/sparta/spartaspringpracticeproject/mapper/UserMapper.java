package com.sparta.spartaspringpracticeproject.mapper;

import com.sparta.spartaspringpracticeproject.dto.UserResponseDto;
import com.sparta.spartaspringpracticeproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto toUserResponseDto(User user);
}
