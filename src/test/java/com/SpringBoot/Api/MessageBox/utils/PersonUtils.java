package com.SpringBoot.Api.MessageBox.utils;

import com.SpringBoot.Api.MessageBox.dto.request.PersonDTO;
import com.SpringBoot.Api.MessageBox.entites.Person;

import java.time.LocalDate;

public class PersonUtils {

    private static final String FIRST_NAME = "Advan";
    private static final String LAST_NAME = "Dias";
    private static final long PERSON_ID = 1L;
    private static final LocalDate DATA = LocalDate.of(2021, 05,18);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .data("18-05-2021")
                .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .data(DATA)
                .build();
    }

}
