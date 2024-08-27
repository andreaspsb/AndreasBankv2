package br.edu.infnet.appAndreas.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAndreas.model.domain.Agencia;
import br.edu.infnet.appAndreas.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	private AgenciaRepository agenciaRepository;

	public void incluir(Agencia agencia) {
		agenciaRepository.save(agencia);
	}

	public Iterable<Agencia> obterLista() {
		return agenciaRepository.findAll();
	}

	public Agencia obterPorId(Integer id) {
		return agenciaRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		agenciaRepository.deleteById(id);
	}

	public long obterQtde() {
		return agenciaRepository.count();
	}

	public Agencia obterPorCodigo(String codigo) {
		return agenciaRepository.findByCodigo(codigo);
	}
}
