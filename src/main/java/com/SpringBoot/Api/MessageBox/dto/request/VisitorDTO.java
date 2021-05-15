package com.SpringBoot.Api.MessageBox.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    private String comment;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String point;

}
