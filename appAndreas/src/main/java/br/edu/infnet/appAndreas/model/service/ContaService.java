package br.edu.infnet.appAndreas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appAndreas.model.domain.Agencia;
import br.edu.infnet.appAndreas.model.domain.Cliente;
import br.edu.infnet.appAndreas.model.domain.Conta;
import br.edu.infnet.appAndreas.model.domain.ContaCorrente;
import br.edu.infnet.appAndreas.model.domain.ContaPoupanca;
import br.edu.infnet.appAndreas.repository.ContaRepository;
import jakarta.transaction.Transactional;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public Iterable<Conta> obterLista() {
		return contaRepository.findAll();
	}

	public long obterQtde() {
		return contaRepository.count();
	}

	public Collection<Conta> obterContasPorAgencia(Integer id) {
		return contaRepository.findByAgenciaId(id);
	}

	public Collection<Conta> obterContasPorAgencia(Agencia agencia) {
		return contaRepository.findByAgenciaId(agencia.getId());
	}

	public Collection<Conta> obterContasPorCliente(Integer id) {
		return contaRepository.findByClienteId(id);
	}

	public Collection<Conta> obterContasPorCliente(Cliente cliente) {
		return contaRepository.findByClienteId(cliente.getId());
	}

	public void excluir(Integer id) {
		contaRepository.deleteById(id);
	}

	private void alterar(Conta conta) {
		contaRepository.save(conta);
	}

	public Conta obterPorId(Integer id) {
		return contaRepository.findById(id).orElse(null);
	}

	public Boolean sacar(float valor, Conta conta) throws Exception {
		try {
			if (!(valor > 0)) {
				throw new Exception();
			}

			// Conta conta = this.obterPorId(id);
			if (conta == null) {
				throw new Exception();
			}

			if (conta instanceof ContaCorrente) {
				ContaCorrente cc = (ContaCorrente) conta;
				if (!((cc.getSaldo() + cc.getLimite()) < valor)) {
					throw new Exception();
				}
				cc.setSaldo(cc.getSaldo() - valor);
				this.alterar(cc);
				// contaCorrenteService.alterar(cc);
			} else {
				if (!(conta.getSaldo() < valor)) {
					throw new Exception();
				}
				conta.setSaldo(conta.getSaldo() - valor);
				this.alterar(conta);
				// contaPoupancaService.alterar((ContaPoupanca) conta);
			}
		} catch (Exception e) {
			throw new Exception();
		}

		return true;
	}

	public Boolean depositar(float valor, Conta conta) throws Exception {
		try {
			if (!(valor > 0)) {
				throw new Exception();
			}

			// Conta conta = this.obterPorId(id);
			if (conta == null) {
				throw new Exception();
			}

			conta.setSaldo(conta.getSaldo() + valor);
			this.alterar(conta);

		} catch (Exception e) {
			throw new Exception();
		}

		return true;
	}

	@Transactional
	public Boolean transferir(float valor, Conta contaOrigem, Conta contaDestino) throws Exception {
		try {
			if (!(valor > 0)) {
				throw new Exception();
			}

			if (contaOrigem == null || contaDestino == null) {
				throw new Exception();
			}

			if (!this.sacar(valor, contaOrigem)) {
				throw new Exception();
			}

			if (!this.depositar(valor, contaDestino)) {
				throw new Exception();
				// return false;// TODO: lançar exceção
			}

		} catch (Exception e) {
			throw new Exception();
		}

		return true;
	}
}
