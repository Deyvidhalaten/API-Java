package br.com.senior.empresa.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "DepartamentoEntity")
@Table(name = "departamentoEntity")
public class DepartamentoEntity {

    @Id
    @Column(name = "id_departamento")
    private UUID idDepartamento;

    @Column(length = 100, nullable = false)
    private String nomeDepartamento;

    @Column
    private Double bonusDepartamento;

    @Column(unique = true, nullable = false)
    private String localizacaoDepartamento;

    @OneToOne
    @JoinColumn(name = "gerente", referencedColumnName = "codigo")
    private Empregado gerente;

    public Empregado getGerente() {
        return gerente;
    }

    public void setGerente(Empregado gerente) {
        this.gerente = gerente;
    }

    public UUID getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(UUID idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public Double getBonusDepartamento() {
        return bonusDepartamento;
    }

    public void setBonusDepartamento(Double bonusDepartamento) {
        this.bonusDepartamento = bonusDepartamento;
    }

    public String getLocalizacaoDepartamento() {
        return localizacaoDepartamento;
    }

    public void setLocalizacaoDepartamento(String localizacaoDepartamento) {
        this.localizacaoDepartamento = localizacaoDepartamento;
    }
}
