package com.SpringBoot.Api.MessageBox.mapper;
import com.SpringBoot.Api.MessageBox.dto.request.VisitorDTO;
import com.SpringBoot.Api.MessageBox.entites.Visitor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VisitorMapper {

    VisitorMapper INSTANCE = Mappers.getMapper(VisitorMapper.class);


    Visitor toModel(VisitorDTO visitorDTO);

    VisitorDTO toDTO(Visitor visitor);

}
