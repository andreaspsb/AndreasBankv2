package br.edu.infnet.appAndreas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAndreas.model.domain.Agencia;

@Repository
public interface AgenciaRepository extends CrudRepository<Agencia, Integer> {
	Agencia findByCodigo(String codigo);
}
