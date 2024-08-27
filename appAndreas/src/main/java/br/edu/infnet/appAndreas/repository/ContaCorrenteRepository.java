package br.edu.infnet.appAndreas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAndreas.model.domain.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends CrudRepository<ContaCorrente, Integer> {

}
