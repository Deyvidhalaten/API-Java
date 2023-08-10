package br.com.senior.empresa.model.exception;

public class DepartamentoNotFoundExcption extends RuntimeException {
    public DepartamentoNotFoundExcption(String departamentos_não_encontrado) {
        super(departamentos_não_encontrado);
    }
}
