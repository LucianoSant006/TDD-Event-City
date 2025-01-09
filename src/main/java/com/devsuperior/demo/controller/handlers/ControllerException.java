package com.devsuperior.demo.controller.handlers;

import com.devsuperior.demo.dto.CustomErrorDTO;
import com.devsuperior.demo.service.exceptions.DatabaseException;
import com.devsuperior.demo.service.exceptions.ResourceNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(ResourceNotFound.class)
    ResponseEntity<CustomErrorDTO> resourceNotFoundException(ResourceNotFound e, HttpServletRequest req){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(),status.value(),e.getMessage(),req.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
    @ExceptionHandler(DatabaseException.class)
    ResponseEntity< CustomErrorDTO>  databaseViolation(DatabaseException e,HttpServletRequest req){
        HttpStatus http = HttpStatus.BAD_REQUEST;
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(),http.value(),e.getMessage(),req.getRequestURI());
        return ResponseEntity.status(http).body(error);
    }
}
