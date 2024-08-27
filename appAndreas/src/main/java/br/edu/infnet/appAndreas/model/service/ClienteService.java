package br.edu.infnet.appAndreas.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAndreas.model.domain.Cliente;
import br.edu.infnet.appAndreas.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void incluir(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public Iterable<Cliente> obterLista() {
		return clienteRepository.findAll();
	}

	public Cliente obterPorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}

	public long obterQtde() {
		return clienteRepository.count();
	}

}
