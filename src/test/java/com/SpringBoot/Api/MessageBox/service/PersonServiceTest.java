package com.SpringBoot.Api.MessageBox.service;

import com.SpringBoot.Api.MessageBox.dto.request.PersonDTO;
import com.SpringBoot.Api.MessageBox.dto.response.MessageResponseDTO;
import com.SpringBoot.Api.MessageBox.entites.Person;
import com.SpringBoot.Api.MessageBox.repositories.PersonRepository;
import com.SpringBoot.Api.MessageBox.services.PersoService;
import com.SpringBoot.Api.MessageBox.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.SpringBoot.Api.MessageBox.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersoService persoService;

    @Test
    void testeGivenPersonDTOThenReturnSaveMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createdExpectedMessegeResponse(expectedSavedPerson.getId());

        MessageResponseDTO succesMessage = persoService.creatPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createdExpectedMessegeResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + id)
                .build();
    }
}
