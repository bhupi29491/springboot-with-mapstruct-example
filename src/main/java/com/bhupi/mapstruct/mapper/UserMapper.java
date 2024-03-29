package com.bhupi.mapstruct.mapper;

import com.bhupi.mapstruct.dto.UserDTO;
import com.bhupi.mapstruct.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "emailId", target = "email")
    @Mapping(source = "contactNo", target = "phoneNo")
    User toEntity(UserDTO userDTO);

    @Mapping(source = "email", target = "emailId")
    @Mapping(source = "phoneNo", target = "contactNo")
    UserDTO toDTO(User user);
    
    List<UserDTO> toDTOList(List<User> users);
}
