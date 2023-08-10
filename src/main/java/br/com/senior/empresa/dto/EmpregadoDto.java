package br.com.senior.empresa.dto;

import br.com.senior.empresa.model.entity.Projeto;
import br.com.senior.empresa.model.enumerado.Genero;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class EmpregadoDto {

    public String nome;
    public String cpf;
    public Genero sexo;
    public Double salario;
    public List<Projeto> projetos;
    public Date dataNascimento;

}
