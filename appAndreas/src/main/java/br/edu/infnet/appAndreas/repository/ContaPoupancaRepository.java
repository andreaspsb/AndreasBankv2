package br.edu.infnet.appAndreas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAndreas.model.domain.ContaPoupanca;

@Repository
public interface ContaPoupancaRepository extends CrudRepository<ContaPoupanca, Integer> {

}
