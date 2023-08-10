package br.com.senior.empresa.dto;

import br.com.senior.empresa.model.entity.DepartamentoEntity;
import br.com.senior.empresa.model.entity.Empregado;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class ProjetoDto{

    public String nome;
    public LocalDate dataEntrega;
    public List<Empregado> empregados;
    public DepartamentoEntity departamento;

}
