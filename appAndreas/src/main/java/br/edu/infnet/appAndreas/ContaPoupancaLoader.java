package br.edu.infnet.appAndreas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAndreas.model.domain.Agencia;
import br.edu.infnet.appAndreas.model.domain.Cliente;
import br.edu.infnet.appAndreas.model.domain.ContaPoupanca;
import br.edu.infnet.appAndreas.model.service.ContaPoupancaService;

@Component
public class ContaPoupancaLoader implements ApplicationRunner {

	@Autowired
	private ContaPoupancaService contaPoupancaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/contapoupanca.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;

		while (linha != null) {
			campos = linha.split(";");
			
			Agencia agencia = new Agencia();
			agencia.setId(Integer.valueOf(campos[5]));
			
			Cliente cliente = new Cliente();
			cliente.setId(Integer.valueOf(campos[6]));

			ContaPoupanca contaPoupanca = new ContaPoupanca();
			contaPoupanca.setNumero(campos[0]);
			contaPoupanca.setSaldo(Float.valueOf(campos[1]));
			contaPoupanca.setAtivo(Boolean.valueOf(campos[2]));
			contaPoupanca.setDiaAniversario(Integer.valueOf(campos[3]));
			contaPoupanca.setTaxaRendimento(Float.valueOf(campos[4]));
			contaPoupanca.setAgencia(agencia);
			contaPoupanca.setCliente(cliente);

			contaPoupancaService.incluir(contaPoupanca);

			linha = leitura.readLine();
		}

		for (ContaPoupanca c : contaPoupancaService.obterLista()) {
			System.out.println("[CONTA POUPANCA]" + c);
		}

		leitura.close();
	}

}
