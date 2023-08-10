package br.com.senior.empresa.mapper;

import br.com.senior.empresa.dto.EmpregadoDto;
import br.com.senior.empresa.model.entity.Empregado;
import org.springframework.stereotype.Service;

@Service
public class EmpregadoMapper {

    public EmpregadoDto toDto (Empregado empregado){
        EmpregadoDto dto = new EmpregadoDto();

        dto.nome = empregado.getNome();
        dto.cpf = empregado.getCpf();
        dto.sexo = empregado.getSexo();
        dto.salario = empregado.getSalario();
        dto.projetos = empregado.getProjetos();
        dto.dataNascimento = empregado.getDataNascimento();

        return dto;
    }

    public Empregado toEntity(EmpregadoDto dto){
        Empregado empregado = new Empregado();

        empregado.setNome(dto.nome);
        empregado.setCpf(dto.cpf);
        empregado.setSexo(dto.sexo);
        empregado.setSalario(dto.salario);
        empregado.setProjetos(dto.projetos);
        empregado.setDataNascimento(dto.dataNascimento);

        return empregado;
    }

}
