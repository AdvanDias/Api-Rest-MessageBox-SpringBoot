package com.SpringBoot.Api.MessageBox.resources;

import com.SpringBoot.Api.MessageBox.dto.request.VisitorDTO;
import com.SpringBoot.Api.MessageBox.dto.response.MessageResponseDTO;
import com.SpringBoot.Api.MessageBox.exception.PersonNotFoundException;
import com.SpringBoot.Api.MessageBox.services.VisitorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/visitor")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VisitorResource {

    private VisitorService visitorService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO creatVisitor(@RequestBody @Valid VisitorDTO visitorDTO){
        return visitorService.creatVisitor(visitorDTO);
    }

    @GetMapping
    public List<VisitorDTO> listAll(){
        return visitorService.listAll();
    }

    @GetMapping("/{id}")
    public VisitorDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return visitorService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletVisitor(@PathVariable Long id) throws PersonNotFoundException {
        visitorService.deletVisitor(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid VisitorDTO visitorDTO) throws  PersonNotFoundException {
        return  visitorService.updateById(id,visitorDTO);
    }


}
