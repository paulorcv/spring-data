package br.com.asty.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.asty.springdata.orm.Cargo;
import br.com.asty.springdata.repository.CargoRepository;
import br.com.asty.springdata.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{

	private final CrudCargoService cargoService;
	private boolean system = true;

	public SpringDataApplication(CrudCargoService service){
		 this.cargoService = service;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system){
			System.out.println("--- Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");

			int action = scanner.nextInt();
			if(action == 1){
				cargoService.inicial(scanner);
			}else{
				system = false;
			}
		}

	}

	

}
