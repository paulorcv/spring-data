package br.com.asty.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.asty.springdata.service.CrudCargoService;
import br.com.asty.springdata.service.CrudUnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	
	private boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService, CrudUnidadeTrabalhoService unidadeTrabalhoService, CrudFuncionarioService funcionarioService){
		 this.cargoService = cargoService;
		 this.unidadeTrabalhoService = unidadeTrabalhoService;
		 this.funcionarioService = funcionarioService;
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
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}

	}

	

}
