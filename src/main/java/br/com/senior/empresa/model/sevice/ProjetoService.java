package br.com.senior.empresa.model.sevice;

import br.com.senior.empresa.model.entity.Projeto;
import br.com.senior.empresa.model.exception.ProjetoNotFoundExcption;
import br.com.senior.empresa.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public List<Projeto> getAllProjetos(){
        Optional<List<Projeto>> projetos = Optional.of(repository.findAll());
        if(projetos.isPresent()){
            return projetos.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
        }
        throw new ProjetoNotFoundExcption("Projetos não encontrado");
    }

    public Projeto getProjeto(UUID id){
        Optional<Projeto> projeto = repository.findProjetoByCodigo(id);
        if(projeto.isPresent()){
            return projeto.get();
        }
        throw new ProjetoNotFoundExcption("Projeto não encontrado");
    }

    public Projeto saveProjeto(Projeto projeto){
        return repository.save(projeto);
    }

    public Projeto updateProjeto(UUID id, Projeto projeto){
        Projeto oldProjeto = this.getProjeto(id);
        oldProjeto.setNome(projeto.getNome());
        oldProjeto.setDepartamento(projeto.getDepartamento());
        oldProjeto.setEmpregados(projeto.getEmpregados());
        oldProjeto.setDataEntrega(projeto.getDataEntrega());
        return this.saveProjeto(oldProjeto);
    }

    public Boolean deleteProjeto(UUID id){
        if(!repository.existsByCodigo(id)){
            throw new ProjetoNotFoundExcption("Projeto não encontrado");
        }
        Boolean canDelete = repository.deleteProjetoByCodigo(id);
        return canDelete;
    }

}
