package com.bhupi.mapstruct.mapper;

import com.bhupi.mapstruct.dto.ContactDTO;
import com.bhupi.mapstruct.entity.Contact;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toEntity(ContactDTO contactDTO);

    ContactDTO toDTO(Contact contact);

    List<ContactDTO> toDTOList(List<Contact> contacts);
}
