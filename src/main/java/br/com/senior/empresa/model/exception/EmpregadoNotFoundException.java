package br.com.senior.empresa.model.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Empregado não encontrado")
public class EmpregadoNotFoundException extends RuntimeException {
    public EmpregadoNotFoundException(String msg) {
        super(msg);
    }
    
}
