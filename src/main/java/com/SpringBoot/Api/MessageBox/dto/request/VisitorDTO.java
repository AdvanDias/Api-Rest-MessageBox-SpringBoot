package com.SpringBoot.Api.MessageBox.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100,message = "Name must be between 10 and 200 characters")
    private String name;

    @NotEmpty
    @Size(min = 10, max = 200, message = "The comment must be between 10 and 200 characters")
    private String comment;

    @NotEmpty
    @Max(value = 10,message = "The score cannot be greater than 10")
    private int point;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private PersonDTO person;

}
