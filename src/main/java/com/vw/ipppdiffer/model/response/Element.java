package com.vw.ipppdiffer.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Element {

    @JsonIgnore
    private static int nextId = 1;
    private int id;
    private String name;
    private String color;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String value;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Element> children;


    public Element() {
        this.id = nextId;
        nextId++;
    }
}
