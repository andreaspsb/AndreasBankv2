package br.edu.infnet.appAndreas.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAndreas.model.domain.ContaCorrente;
import br.edu.infnet.appAndreas.repository.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	public void incluir(ContaCorrente contaCorrente) {
		contaCorrenteRepository.save(contaCorrente);
	}

	public Iterable<ContaCorrente> obterLista() {
		return contaCorrenteRepository.findAll();
	}

	public ContaCorrente obterPorId(Integer id) {
		return contaCorrenteRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		contaCorrenteRepository.deleteById(id);
	}

	public long obterQtde() {
		return contaCorrenteRepository.count();
	}
}
