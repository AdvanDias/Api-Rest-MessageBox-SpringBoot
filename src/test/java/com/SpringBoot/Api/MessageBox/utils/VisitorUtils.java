package com.SpringBoot.Api.MessageBox.utils;

import com.SpringBoot.Api.MessageBox.dto.request.VisitorDTO;
import com.SpringBoot.Api.MessageBox.entites.Visitor;

import java.util.Collections;


public class VisitorUtils {

    private static final String NAME = "Visitante";
    private static final String COMMENT = "Comentario vai aqui";
    private static final int POINT = 5;
    private static final long ID_VISITOR = 1L;

    public static VisitorDTO createFakeDTO(){
        return VisitorDTO.builder()
                .name(NAME)
                .comment(COMMENT)
                .point(5)
                .person(PersonUtils.createFakeDTO())
                .build();
    }

    public static Visitor createFakeEntity(){
        return Visitor.builder()
                .id(ID_VISITOR)
                .name(NAME)
                .comment(COMMENT)
                .point(POINT)
                .person(PersonUtils.createFakeEntity())
                .build();
    }

}
