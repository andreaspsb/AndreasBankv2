package br.edu.infnet.appAndreas.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAndreas.model.domain.ContaPoupanca;
import br.edu.infnet.appAndreas.repository.ContaPoupancaRepository;

@Service
public class ContaPoupancaService {

	@Autowired
	private ContaPoupancaRepository contaPoupancaRepository;

	public void incluir(ContaPoupanca contaPoupanca) {
		contaPoupancaRepository.save(contaPoupanca);
	}

	public Iterable<ContaPoupanca> obterLista() {
		return contaPoupancaRepository.findAll();
	}

	public ContaPoupanca obterPorId(Integer id) {
		return contaPoupancaRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		contaPoupancaRepository.deleteById(id);
	}

	public long obterQtde() {
		return contaPoupancaRepository.count();
	}
}
