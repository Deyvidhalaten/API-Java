package br.com.senior.empresa.controller;

import br.com.senior.empresa.dto.EmpregadoDto;
import br.com.senior.empresa.mapper.EmpregadoMapper;
import br.com.senior.empresa.model.entity.Empregado;
import br.com.senior.empresa.model.sevice.EmpregadoService;
import br.com.senior.empresa.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/empregado/")
public class EmpregadoController {

    @Autowired
    private EmpregadoService service;
    
    @Autowired
    private EmpregadoMapper mapper;

    @PostMapping(path = "api/cadastrar/")
    public ResponseEntity<EmpregadoDto> cadastrarEmpregado(@RequestBody EmpregadoDto empregadoDto){
        Empregado empregado = mapper.toEntity(empregadoDto);
        EmpregadoDto body = mapper.toDto(service.createEmpregado(empregado));
        return ResponseEntity.ok().body(body);
    }

    @PutMapping(path = "api/atualizar/{codigo}")
    public ResponseEntity<EmpregadoDto> atualizarEmpregado(@PathVariable String codigo,@RequestBody EmpregadoDto empregadoDto){
        UUID id = UUID.fromString(codigo);

        Empregado empregado = mapper.toEntity(empregadoDto);
        EmpregadoDto body = mapper.toDto(service.updateEmpregado(id, empregado));

        return ResponseEntity.ok().body(body);
    }

    @GetMapping(path = "api/empregado/{codigo}")
    public ResponseEntity<EmpregadoDto> findById(@PathVariable String codigo){
        UUID id = UUID.fromString(codigo);

        EmpregadoDto body = mapper.toDto(service.getEmpregado(id));

        return ResponseEntity.ok().body(body);
    }

    @GetMapping(path = "api/empregados")
    public ResponseEntity<List<EmpregadoDto>> findAll(){
        List<EmpregadoDto> empregadoDtos = service.getAllEmpregados().stream().map(e -> mapper.toDto(e)).collect(Collectors.toList());

        return ResponseEntity.ok().body(empregadoDtos);
    }

    @DeleteMapping(path = "api/deletar/{codigo}")
    public ResponseEntity<Void> delete (@PathVariable String codigo){
        UUID id = UUID.fromString(codigo);
        service.deleteEmpregado(id);

        return ResponseEntity.ok().build();
    }
}
