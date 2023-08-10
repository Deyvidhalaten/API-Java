package br.com.senior.empresa.repository;

import br.com.senior.empresa.model.entity.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

    @Transactional
    Optional<Empregado> findEmpregadoByCodigo(UUID id);

    @Transactional
    boolean existsByCodigo(UUID id);

    @Transactional
    void deleteByCodigo(UUID id);
    
    @Transactional
    boolean existsByCpf(String cpf);
}
