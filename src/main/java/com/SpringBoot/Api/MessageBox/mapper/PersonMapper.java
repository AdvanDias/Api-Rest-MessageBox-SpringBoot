package com.SpringBoot.Api.MessageBox.mapper;

import com.SpringBoot.Api.MessageBox.dto.request.PersonDTO;
import com.SpringBoot.Api.MessageBox.entites.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);


    @Mapping(target = "data", source = "data", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);


    PersonDTO toDTO(Person person);

}
