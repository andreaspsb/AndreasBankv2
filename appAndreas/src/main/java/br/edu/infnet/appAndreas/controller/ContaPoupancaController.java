package br.edu.infnet.appAndreas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appAndreas.model.domain.ContaPoupanca;
import br.edu.infnet.appAndreas.model.service.ContaPoupancaService;

@RestController
public class ContaPoupancaController {

	@Autowired
	private ContaPoupancaService contaPoupancaService;

	@GetMapping(value = "contapoupanca/listar")
	public Iterable<ContaPoupanca> obterLista() {
		return contaPoupancaService.obterLista();
	}

	@GetMapping(value = "contapoupanca/{id}")
	public ContaPoupanca obterPorId(@PathVariable Integer id) {
		return contaPoupancaService.obterPorId(id);
	}

	@PostMapping(value = "contapoupanca/incluir")
	public String incluir(@RequestBody ContaPoupanca contaPoupanca) {
		contaPoupancaService.incluir(contaPoupanca);

		return "Inclusão realizada com sucesso";
	}

	@DeleteMapping(value = "contapoupanca/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		contaPoupancaService.excluir(id);

		return "Exclusão realizada com sucesso";
	}
	
	@GetMapping(value = "contapoupanca/contar")
	public long obterQtde() {
		return contaPoupancaService.obterQtde();
	}

}
