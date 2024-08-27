package br.edu.infnet.appAndreas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAndreas.model.domain.Agencia;
import br.edu.infnet.appAndreas.model.domain.Cliente;
import br.edu.infnet.appAndreas.model.domain.ContaCorrente;
import br.edu.infnet.appAndreas.model.service.ContaCorrenteService;

@Component
public class ContaCorrenteLoader implements ApplicationRunner {

	@Autowired
	private ContaCorrenteService contaCorrenteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/contacorrente.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;

		while (linha != null) {
			campos = linha.split(";");
			
			Agencia agencia = new Agencia();
			agencia.setId(Integer.valueOf(campos[5]));
			
			Cliente cliente = new Cliente();
			cliente.setId(Integer.valueOf(campos[6]));

			ContaCorrente contaCorrente = new ContaCorrente();
			contaCorrente.setNumero(campos[0]);
			contaCorrente.setSaldo(Float.valueOf(campos[1]));
			contaCorrente.setAtivo(Boolean.valueOf(campos[2]));
			contaCorrente.setLimite(Float.valueOf(campos[3]));
			contaCorrente.setTaxaManutencao(Float.valueOf(campos[4]));
			contaCorrente.setAgencia(agencia);
			contaCorrente.setCliente(cliente);

			contaCorrenteService.incluir(contaCorrente);

			linha = leitura.readLine();
		}

		for (ContaCorrente c : contaCorrenteService.obterLista()) {
			System.out.println("[CONTA CORRENTE]" + c);
		}

		leitura.close();
	}

}
