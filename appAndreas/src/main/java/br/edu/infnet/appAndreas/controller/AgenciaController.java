package br.edu.infnet.appAndreas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appAndreas.model.domain.Agencia;
import br.edu.infnet.appAndreas.model.service.AgenciaService;

@RestController
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;

	@GetMapping(value = "agencia/listar")
	public Iterable<Agencia> obterLista() {
		return agenciaService.obterLista();
	}

	@GetMapping(value = "agencia/{id}")
	public Agencia obterPorId(@PathVariable Integer id) {
		return agenciaService.obterPorId(id);
	}

	@PostMapping(value = "agencia/incluir")
	public String incluir(@RequestBody Agencia agencia) {
		agenciaService.incluir(agencia);

		return "Inclusão realizada com sucesso";
	}

	@DeleteMapping(value = "agencia/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		agenciaService.excluir(id);

		return "Exclusão realizada com sucesso";
	}
	
	@GetMapping(value = "agencia/contar")
	public long obterQtde() {
		return agenciaService.obterQtde();
	}
}
