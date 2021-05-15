package com.SpringBoot.Api.MessageBox.services;


import com.SpringBoot.Api.MessageBox.dto.request.PersonDTO;
import com.SpringBoot.Api.MessageBox.dto.response.MessageResponseDTO;
import com.SpringBoot.Api.MessageBox.entites.Person;
import com.SpringBoot.Api.MessageBox.exception.PersonNotFoundException;
import com.SpringBoot.Api.MessageBox.mapper.PersonMapper;
import com.SpringBoot.Api.MessageBox.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersoService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersoService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO creatPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+ savePerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }







    /*
     * essa nova classe foi criada para mostrar uma exeção caso o id informado não esteja la
     *
     * Person person = personRepository.findById(id)
     *           .orElseThrow(() -> new personNotFoundException(id));
     *
     * como boa pratica no caso de repetição desse trecho de codigo
     * melhor trasformar em um metodo para usuar
     * chamando so assim : ->  verifyIfExists(id)
     *
     * */
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}
