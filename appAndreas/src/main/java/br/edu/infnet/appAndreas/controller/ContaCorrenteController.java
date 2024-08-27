package br.edu.infnet.appAndreas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appAndreas.model.domain.ContaCorrente;
import br.edu.infnet.appAndreas.model.service.ContaCorrenteService;

@RestController
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService contaCorrenteService;

	@GetMapping(value = "contacorrente/listar")
	public Iterable<ContaCorrente> obterLista() {
		return contaCorrenteService.obterLista();
	}

	@GetMapping(value = "contacorrente/{id}")
	public ContaCorrente obterPorId(@PathVariable Integer id) {
		return contaCorrenteService.obterPorId(id);
	}

	@PostMapping(value = "contacorrente/incluir")
	public String incluir(@RequestBody ContaCorrente contaCorrente) {
		contaCorrenteService.incluir(contaCorrente);

		return "Inclusão realizada com sucesso";
	}

	@DeleteMapping(value = "contacorrente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		contaCorrenteService.excluir(id);

		return "Exclusão realizada com sucesso";
	}
	
	@GetMapping(value = "contacorrente/contar")
	public long obterQtde() {
		return contaCorrenteService.obterQtde();
	}

}
