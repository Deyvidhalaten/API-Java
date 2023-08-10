package br.com.senior.empresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Projeto não pode ser vazio")
public class ProjetoNulLabelException extends RuntimeException {
    public ProjetoNulLabelException(String msg) {
        super(msg);
    }
}
