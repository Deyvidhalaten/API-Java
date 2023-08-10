package br.com.senior.empresa.repository;

import br.com.senior.empresa.model.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {


	@Transactional
    Optional<DepartamentoEntity> findProjetoByIdDepartamento(UUID id);

	@Transactional
    boolean existsByIdDepartamento(UUID id);

	@Transactional
    boolean deleteDepartamentoByIdDepartamento(UUID id);
}
