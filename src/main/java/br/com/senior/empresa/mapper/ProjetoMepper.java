package br.com.senior.empresa.mapper;

import br.com.senior.empresa.dto.ProjetoDto;
import br.com.senior.empresa.model.entity.Projeto;
import org.springframework.stereotype.Service;

@Service
public class ProjetoMepper {

    public ProjetoDto toDto(Projeto projeto){
        ProjetoDto dto = null;

        if(projeto != null){
            dto = new ProjetoDto();

            dto.nome = projeto.getNome();
            dto.dataEntrega = projeto.getDataEntrega();
            dto.empregados = projeto.getEmpregados();
            dto.departamento = projeto.getDepartamento();
        }
        return dto;
    }

    public Projeto toEntity(ProjetoDto dto){
        Projeto projeto = null;
        if (dto != null){
            projeto = new Projeto();

            projeto.setDataEntrega(dto.dataEntrega);
            projeto.setEmpregados(dto.empregados);
            projeto.setNome(dto.nome);
            projeto.setDepartamento(dto.departamento);
        }

        return projeto;

    }

}
