package com.SpringBoot.Api.MessageBox.resources;

import com.SpringBoot.Api.MessageBox.dto.request.PersonDTO;
import com.SpringBoot.Api.MessageBox.dto.response.MessageResponseDTO;
import com.SpringBoot.Api.MessageBox.exception.PersonNotFoundException;
import com.SpringBoot.Api.MessageBox.services.PersoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonResource {

    private PersoService persoService;

    @Autowired
    public PersonResource(PersoService persoService) {
        this.persoService = persoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO creatPerson(@RequestBody @Valid PersonDTO personDTO){
        return persoService.creatPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return persoService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return persoService.findById(id);
    }

}
