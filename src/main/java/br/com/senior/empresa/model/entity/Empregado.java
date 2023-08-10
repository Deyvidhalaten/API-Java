package br.com.senior.empresa.model.entity;


import br.com.senior.empresa.model.enumerado.Genero;
import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Empregado")
@Table(name = "empregado")
public class Empregado {

    @Id
    private UUID codigo;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column
    private Genero sexo;

    @Column
    private Double salario;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "projeto_empregado", 
        joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "codigo") }, 
        inverseJoinColumns = { @JoinColumn(name = "project_id", referencedColumnName = "codigo") }
    )
    private List<Projeto> projetos;
   
    /*
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    @Column
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "projeto_empregado",
            joinColumns = {
                @JoinColumn(name = "empregado", referencedColumnName = "codigo")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "projeto", referencedColumnName = "codigo")
            }
    )
    private List<Projeto> projetos;
    */

    @Column
    private Date dataNascimento;


    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
