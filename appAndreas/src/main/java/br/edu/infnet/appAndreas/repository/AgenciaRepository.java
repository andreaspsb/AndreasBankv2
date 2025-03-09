package br.edu.infnet.appAndreas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAndreas.model.domain.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {
	Agencia findByCodigo(String codigo);
}
