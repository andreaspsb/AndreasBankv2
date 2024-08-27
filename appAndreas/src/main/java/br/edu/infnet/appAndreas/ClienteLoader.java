package br.edu.infnet.appAndreas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAndreas.model.domain.Cliente;
import br.edu.infnet.appAndreas.model.domain.ContaCorrente;
import br.edu.infnet.appAndreas.model.domain.ContaPoupanca;
import br.edu.infnet.appAndreas.model.service.ClienteService;

@Component
@Order(2)
public class ClienteLoader implements ApplicationRunner {

	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/cliente.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;

		Cliente cliente = null;

		while (linha != null) {
			campos = linha.split(";");

			switch (campos[0].toUpperCase()) {
			case "C":
				cliente = new Cliente();
				cliente.setCpf(campos[1]);
				cliente.setNome(campos[2]);

				clienteService.incluir(cliente);

				break;
			case "CC":
				ContaCorrente contaCorrente = new ContaCorrente();
				contaCorrente.setNumero(campos[1]);
				contaCorrente.setSaldo(Float.valueOf(campos[2]));
				contaCorrente.setAtivo(Boolean.valueOf(campos[3]));
				contaCorrente.setLimite(Float.valueOf(campos[4]));
				contaCorrente.setTaxaManutencao(Float.valueOf(campos[5]));

				cliente.getContas().add(contaCorrente);

				break;
			case "CP":
				ContaPoupanca contaPoupanca = new ContaPoupanca();
				contaPoupanca.setNumero(campos[1]);
				contaPoupanca.setSaldo(Float.valueOf(campos[2]));
				contaPoupanca.setAtivo(Boolean.valueOf(campos[3]));
				contaPoupanca.setDiaAniversario(Integer.valueOf(campos[4]));
				contaPoupanca.setTaxaRendimento(Float.valueOf(campos[5]));

				cliente.getContas().add(contaPoupanca);

				break;
			default:
				break;
			}

			linha = leitura.readLine();
		}

		for (Cliente c : clienteService.obterLista()) {
			System.out.println("[CLIENTE]" + c);
		}

		leitura.close();

	}

}
