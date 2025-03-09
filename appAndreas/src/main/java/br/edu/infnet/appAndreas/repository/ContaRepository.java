package br.edu.infnet.appAndreas.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAndreas.model.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
	Collection<Conta> findByAgenciaId(Integer id);

	Collection<Conta> findByClienteId(Integer id);

}
