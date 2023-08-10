package br.com.senior.empresa.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Dados Inválidos")
public class ProjectBadRequestException extends RuntimeException {
    public ProjectBadRequestException(String msg) {
        super(msg);
    }
}

