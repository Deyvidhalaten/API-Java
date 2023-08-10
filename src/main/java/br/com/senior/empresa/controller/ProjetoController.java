package br.com.senior.empresa.controller;

import br.com.senior.empresa.dto.ProjetoDto;
import br.com.senior.empresa.exception.ProjetoNulLabelException;
import br.com.senior.empresa.mapper.ProjetoMepper;
import br.com.senior.empresa.model.entity.Projeto;
import br.com.senior.empresa.model.sevice.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(path = "/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    @Autowired
    private ProjetoMepper mapper;

    @PostMapping(path = "/api/projeto")
    public ResponseEntity<ProjetoDto> cadastrarProjeto(@RequestBody ProjetoDto projetoDto) {
        Projeto projeto = mapper.toEntity(projetoDto);
        ProjetoDto body = mapper.toDto(service.saveProjeto(projeto));

        return ResponseEntity.ok().body(body);

    }

    @PutMapping(path = "/api/projeto/{codigo}")
    public ResponseEntity<ProjetoDto> atualizarProjeto(@PathVariable String codigo, @RequestBody ProjetoDto projetoDto) {
        UUID id = UUID.fromString(codigo);
        Projeto projeto = mapper.toEntity(projetoDto);
        ProjetoDto body = mapper.toDto(service.updateProjeto(id, projeto));

        if (Objects.nonNull(body)){
            throw  new ProjetoNulLabelException("Projeto não pode ser vazio");
        }

        return ResponseEntity.ok().body(body);

    }

    /*@DeleteMapping(path = "/api/projeto/delete/{codigo}")
    public ResponseEntity<String>*/


}
