package br.com.senior.empresa.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "Projeto")
@Table(name = "projeto")
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    private UUID codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataEntrega;

    /*@ManyToMany(mappedBy = "projetos", cascade = CascadeType.ALL)
    private List<Empregado> empregados;*/
    
    @ManyToMany(mappedBy = "projetos")
    private List<Empregado> empregados;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "departameto", referencedColumnName = "id_departamento")
    private DepartamentoEntity departamento;

    public UUID getCodigo() {
        return codigo;
    }

    
    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(List<Empregado> empregados) {
        this.empregados = empregados;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
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

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
