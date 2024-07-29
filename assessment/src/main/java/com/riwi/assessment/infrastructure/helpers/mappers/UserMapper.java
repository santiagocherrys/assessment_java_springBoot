package com.riwi.assessment.infrastructure.helpers.mappers;

import com.riwi.assessment.api.dtos.request.UserRequest;
import com.riwi.assessment.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserRequest request);
}
