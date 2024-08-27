package br.edu.infnet.appAndreas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appAndreas.model.domain.Agencia;
import br.edu.infnet.appAndreas.model.domain.Cliente;
import br.edu.infnet.appAndreas.model.domain.Conta;
import br.edu.infnet.appAndreas.model.service.ContaService;

@RestController
public class ContaController {

	@Autowired
	private ContaService contaService;

	@GetMapping(value = "conta/listar")
	public Iterable<Conta> obterLista() {
		return contaService.obterLista();
	}

	@GetMapping(value = "conta/{id}")
	public Conta obterPorId(@PathVariable Integer id) {
		return contaService.obterPorId(id);
	}

	@GetMapping(value = "conta/agencia/{id}")
	public Iterable<Conta> obterContasPorAgencia(@PathVariable Integer id) {
		return contaService.obterContasPorAgencia(id);
	}

	@GetMapping(value = "conta/agencia")
	public Iterable<Conta> obterContasPorAgencia(@RequestBody Agencia agencia) {
		return contaService.obterContasPorAgencia(agencia);
	}

	@GetMapping(value = "conta/cliente/{id}")
	public Iterable<Conta> obterContasPorCliente(@PathVariable Integer id) {
		return contaService.obterContasPorCliente(id);
	}

	@GetMapping(value = "conta/cliente")
	public Iterable<Conta> obterContasPorCliente(@RequestBody Cliente cliente) {
		return contaService.obterContasPorCliente(cliente);
	}

	@DeleteMapping(value = "conta/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		contaService.excluir(id);

		return "Exclusão realizada com sucesso";
	}

	@GetMapping(value = "conta/contar")
	public long obterQtde() {
		return contaService.obterQtde();
	}

}
