package br.com.asty.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.asty.springdata.service.CrudCargoService;
import br.com.asty.springdata.service.CrudUnidadeTrabalhoService;
import br.com.asty.springdata.service.RelatorioFuncionarioDinamico;
import br.com.asty.springdata.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamicoService;

	private boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService, CrudUnidadeTrabalhoService unidadeTrabalhoService,
			CrudFuncionarioService funcionarioService, RelatoriosService relatoriosService,
			RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.funcionarioService = funcionarioService;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamicoService = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Funcionario");
			System.out.println("2 - Cargo");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatórios");
			System.out.println("5 - Relatório Funcionário Dinâmico");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					funcionarioService.inicial(scanner);
					break;
				case 2:
					cargoService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
					break;

				case 5:
					relatorioFuncionarioDinamicoService.inicial(scanner);
					break;

				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}

	}

}
