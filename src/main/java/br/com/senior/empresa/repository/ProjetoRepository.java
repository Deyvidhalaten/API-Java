package br.com.senior.empresa.repository;

import br.com.senior.empresa.model.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    @Transactional
    Optional<Projeto> findProjetoByCodigo(UUID id);

    @Transactional
    boolean existsByCodigo(UUID id);

    @Transactional
    Boolean deleteProjetoByCodigo(UUID id);

}
