package com.example.web.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DepartmentRequest {
    private Integer id;

    @JsonCreator
    public DepartmentRequest(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

