package com.SpringBoot.Api.MessageBox.services;


import com.SpringBoot.Api.MessageBox.dto.request.PersonDTO;
import com.SpringBoot.Api.MessageBox.dto.request.VisitorDTO;
import com.SpringBoot.Api.MessageBox.dto.response.MessageResponseDTO;
import com.SpringBoot.Api.MessageBox.entites.Person;
import com.SpringBoot.Api.MessageBox.entites.Visitor;
import com.SpringBoot.Api.MessageBox.exception.PersonNotFoundException;
import com.SpringBoot.Api.MessageBox.mapper.VisitorMapper;
import com.SpringBoot.Api.MessageBox.repositories.VisitorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VisitorService {

    private VisitorRepository visitorRepository;

    private final VisitorMapper visitorMapper = VisitorMapper.INSTANCE;


    public MessageResponseDTO creatVisitor(VisitorDTO visitorDTO){
        Visitor visitorToSave = visitorMapper.toModel(visitorDTO);

        Visitor savePerson = visitorRepository.save(visitorToSave);
        return createMessageResponse(savePerson.getId(), "Created person with ID");
    }

    public List<VisitorDTO> listAll() {
        List<Visitor> allVisitor = visitorRepository.findAll();
        return allVisitor.stream()
                .map(visitorMapper::toDTO)
                .collect(Collectors.toList());
    }





    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }


}
