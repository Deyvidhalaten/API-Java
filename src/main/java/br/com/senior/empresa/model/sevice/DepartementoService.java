package br.com.senior.empresa.model.sevice;

import br.com.senior.empresa.model.entity.DepartamentoEntity;
import br.com.senior.empresa.model.exception.DepartamentoNotFoundExcption;
import br.com.senior.empresa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class DepartementoService {

    @Autowired
    private DepartamentoRepository repository;

    public List<DepartamentoEntity> getAllProjetos(){
        Optional<List<DepartamentoEntity>> departamento = Optional.of(repository.findAll());
        if(departamento.isPresent()){
            return departamento.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
        }
        throw new DepartamentoNotFoundExcption("Departamentos não encontrado");
    }

    public DepartamentoEntity getProjeto(UUID id){
        Optional<DepartamentoEntity> departamento = repository.findProjetoByIdDepartamento(id);
        if(departamento.isPresent()){
            return departamento.get();
        }
        throw new DepartamentoNotFoundExcption("Departamentos não encontrado");
    }

    public DepartamentoEntity saveProjeto(DepartamentoEntity projeto){
        return repository.save(projeto);
    }

    public DepartamentoEntity updateProjeto(UUID id, DepartamentoEntity departamento){
        DepartamentoEntity oldDepartamento = this.getProjeto(id);
        oldDepartamento.setNomeDepartamento(departamento.getNomeDepartamento());
        oldDepartamento.setBonusDepartamento(departamento.getBonusDepartamento());
        oldDepartamento.setGerente(departamento.getGerente());
        oldDepartamento.setLocalizacaoDepartamento(departamento.getLocalizacaoDepartamento());
        return this.saveProjeto(oldDepartamento);
    }

    public Boolean deleteDepartamento(UUID id){
        if(!repository.existsByIdDepartamento(id)){
            throw new DepartamentoNotFoundExcption("Departamentos não encontrado");
        }
        boolean canDelete = repository.deleteDepartamentoByIdDepartamento(id);
        return canDelete;
    }

}
