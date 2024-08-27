package br.edu.infnet.appAndreas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAndreas.model.domain.Agencia;
import br.edu.infnet.appAndreas.model.domain.ContaCorrente;
import br.edu.infnet.appAndreas.model.domain.ContaPoupanca;
import br.edu.infnet.appAndreas.model.service.AgenciaService;

@Component
@Order(1)
public class AgenciaLoader implements ApplicationRunner {

	@Autowired
	private AgenciaService agenciaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/agencia.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;

		Agencia agencia = null;

		while (linha != null) {
			campos = linha.split(";");

			switch (campos[0].toUpperCase()) {
			case "A":
				agencia = new Agencia();
				agencia.setCodigo(campos[1]);
				agencia.setNome(campos[2]);

				// Endereco endereco = new Endereco();
				// enderecoService.obterPorCep(campos[3]);
				// agencia.setEndereco(endereco);

				agenciaService.incluir(agencia);

				break;
			case "CC":
				ContaCorrente contaCorrente = new ContaCorrente();
				contaCorrente.setNumero(campos[1]);
				contaCorrente.setSaldo(Float.valueOf(campos[2]));
				contaCorrente.setAtivo(Boolean.valueOf(campos[3]));
				contaCorrente.setLimite(Float.valueOf(campos[4]));
				contaCorrente.setTaxaManutencao(Float.valueOf(campos[5]));

				agencia.getContas().add(contaCorrente);

				break;
			case "CP":
				ContaPoupanca contaPoupanca = new ContaPoupanca();
				contaPoupanca.setNumero(campos[1]);
				contaPoupanca.setSaldo(Float.valueOf(campos[2]));
				contaPoupanca.setAtivo(Boolean.valueOf(campos[3]));
				contaPoupanca.setDiaAniversario(Integer.valueOf(campos[4]));
				contaPoupanca.setTaxaRendimento(Float.valueOf(campos[5]));

				agencia.getContas().add(contaPoupanca);

				break;
			default:
				break;
			}

			linha = leitura.readLine();
		}

		for (Agencia a : agenciaService.obterLista()) {
			System.out.println("[AGENCIA]" + a);
		}

		leitura.close();
	}

}
