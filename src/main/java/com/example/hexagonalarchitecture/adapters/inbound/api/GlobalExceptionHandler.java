package com.example.hexagonalarchitecture.adapters.inbound.api;

import com.example.hexagonalarchitecture.application.domain.exceptions.EmailAlreadyRegisteredException;
import com.example.hexagonalarchitecture.application.domain.exceptions.InvalidCpfException;
import com.example.hexagonalarchitecture.application.domain.exceptions.InvalidEmailException;
import com.example.hexagonalarchitecture.application.domain.exceptions.InvalidNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<String> emailAlreadyRegistered(RuntimeException e) {
        return new ResponseEntity<String>("Email já cadastrado", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<String> invalidEmail(RuntimeException e) {
        return new ResponseEntity<String>("Email inválido", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity<String> invalidCpf(RuntimeException e) {
        return new ResponseEntity<String>("Cpf inválido", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<String> invalidName(RuntimeException e) {
        return new ResponseEntity<String>("Nome inválido", HttpStatus.BAD_REQUEST);
    }
}
