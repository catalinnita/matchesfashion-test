package com.matchesfashion.papi.api.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.matchesfashion.papi.api.jsonview.View;

public abstract class AbstractDto {

    @JsonView(value = View.Error.class)
    protected String message;

    @JsonView(value = View.Error.class)
    protected String error;

    public AbstractDto() {}

    public AbstractDto(String message, String error) {
        this.message = message;
        this.error = error;
    }
}
