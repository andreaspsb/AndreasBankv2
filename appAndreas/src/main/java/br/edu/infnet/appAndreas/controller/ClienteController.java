package br.edu.infnet.appAndreas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appAndreas.model.domain.Cliente;
import br.edu.infnet.appAndreas.model.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "cliente/listar")
	public Iterable<Cliente> obterLista() {
		return clienteService.obterLista();
	}

	@GetMapping(value = "cliente/{id}")
	public Cliente obterPorId(@PathVariable Integer id) {
		return clienteService.obterPorId(id);
	}

	@PostMapping(value = "cliente/incluir")
	public String incluir(@RequestBody Cliente cliente) {
		clienteService.incluir(cliente);

		return "Inclusão realizada com sucesso";
	}

	@DeleteMapping(value = "cliente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		clienteService.excluir(id);

		return "Exclusão realizada com sucesso";
	}
	
	@GetMapping(value = "cliente/contar")
	public long obterQtde() {
		return clienteService.obterQtde();
	}

}
