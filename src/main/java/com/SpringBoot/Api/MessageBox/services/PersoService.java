package com.SpringBoot.Api.MessageBox.services;


import com.SpringBoot.Api.MessageBox.dto.request.PersonDTO;
import com.SpringBoot.Api.MessageBox.dto.response.MessageResponseDTO;
import com.SpringBoot.Api.MessageBox.entites.Person;
import com.SpringBoot.Api.MessageBox.exception.PersonNotFoundException;
import com.SpringBoot.Api.MessageBox.mapper.PersonMapper;
import com.SpringBoot.Api.MessageBox.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersoService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    

    public MessageResponseDTO creatPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);
        return createMessageResponse(savePerson.getId(), "Created person with ID");
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

    public void delePerson(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Update person with ID");
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

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }


}
