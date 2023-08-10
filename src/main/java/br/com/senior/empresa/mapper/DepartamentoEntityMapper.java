package br.com.senior.empresa.mapper;

import br.com.senior.empresa.dto.DepartamentoDto;
import br.com.senior.empresa.model.entity.DepartamentoEntity;

public class DepartamentoEntityMapper {

	 public DepartamentoDto toDto (DepartamentoEntity departamento){
	        DepartamentoDto dto = new DepartamentoDto();

	        dto.nomeDepartamento = departamento.getNomeDepartamento();
	        dto.bonusDepartamento = departamento.getBonusDepartamento();
	        dto.localizacaoDepartamento = departamento.getLocalizacaoDepartamento();
	        dto.gerente = departamento.getGerente();

	        return dto;
	    }

	    public DepartamentoEntity toEntity(DepartamentoDto dto){
	    	DepartamentoEntity departamento = new DepartamentoEntity();

	        departamento.setNomeDepartamento(dto.nomeDepartamento);
	        departamento.setBonusDepartamento(dto.bonusDepartamento);
	        departamento.setGerente(dto.gerente);
	        departamento.setLocalizacaoDepartamento(dto.localizacaoDepartamento);

	        return departamento;
	    }
	    
}
