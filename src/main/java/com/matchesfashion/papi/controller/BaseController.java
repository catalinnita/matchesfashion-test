package com.matchesfashion.papi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.matchesfashion.papi.api.ValidationCode;
import com.matchesfashion.papi.api.jsonview.View;
import com.matchesfashion.papi.api.dto.ProductsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    @ExceptionHandler(value = NumberFormatException.class)
    @JsonView(value = View.Error.class)
    public ResponseEntity<ProductsDto> handleNumberFormatException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ProductsDto(ValidationCode.NFE_MESSAGE, e.getMessage()));
    }
}
