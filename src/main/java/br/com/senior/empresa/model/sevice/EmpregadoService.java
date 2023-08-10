package br.com.senior.empresa.model.sevice;

import br.com.senior.empresa.model.entity.Empregado;
import br.com.senior.empresa.model.exception.EmpregadoNotFoundException;
import br.com.senior.empresa.model.exception.ProjectBadRequestException;
import br.com.senior.empresa.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository repository;

    public List<Empregado> getAllEmpregados(){
        Optional<List<Empregado>> empregados = Optional.of(repository.findAll());

        if(empregados.isPresent()){
            return empregados.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
        }
        throw new EmpregadoNotFoundException("Empregados não encontrado");
    }

    public Empregado getEmpregado(UUID id){
        Optional<Empregado> empregado = repository.findEmpregadoByCodigo(id);

        if(empregado.isPresent()){
            return empregado.get();
        }
        throw new EmpregadoNotFoundException("Empregado não encontrado");
    }

    public Empregado createEmpregado(Empregado empregado){
    	if(empregado.getCodigo()==null) {
    		empregado.setCodigo(geradorUUID());
    	}
    	if(validaDados(empregado)) {
    		throw new ProjectBadRequestException("Dados Inválidos");
    	}else {
    		return repository.save(empregado);
    	}
    }

    public Empregado updateEmpregado(UUID id, Empregado empregado){
        Empregado oldEmpregado = this.getEmpregado(id);
        oldEmpregado.setCpf(empregado.getCpf());
        oldEmpregado.setNome(empregado.getNome());
        oldEmpregado.setSexo(empregado.getSexo());
        oldEmpregado.setSalario(empregado.getSalario());
        oldEmpregado.setProjetos(empregado.getProjetos());
        return this.createEmpregado(oldEmpregado);
    }

    public void deleteEmpregado(UUID id){
        if(!repository.existsByCodigo(id)){
            throw new EmpregadoNotFoundException("Empregado não encontrado");
        }
        repository.deleteByCodigo(id);
    }
    
    public static UUID geradorUUID() {
        final UUID uuid = UUID.randomUUID();
        return uuid;
    }
    
    public boolean validaDados(Empregado empregado) {
    	if(empregado.getCpf().length()<11) {
    		return true;
    	}
    	if (repository.existsByCpf(empregado.getCpf())) {
    		return true;
    	}
    	return false;
    }

}
