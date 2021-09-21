package br.com.asty.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.asty.springdata.orm.Cargo;
import br.com.asty.springdata.repository.CargoRepository;

@Service
public class CrudCargoService {
    
    private final CargoRepository cargoRepository;
    private boolean system = true;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner){
        
        while(system){
            System.out.println("Qual ação de cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Listar");
            System.out.println("4 - Apagar");

            int action = scanner.nextInt();

            switch(action){

                case 1:
                    salvar(scanner);
                    break;

                case 2:
                    atualizar(scanner);
                    break;

                case 3:
                    listar();
                    break;

                case 4:
                    apagar(scanner);
                    break;


                default:
                    system = false;
                    break;
            }
        }
       
    }

    private void salvar(Scanner scanner){
        System.out.println("Descrição do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner){
        System.out.println("Id");
        int id = scanner.nextInt();
        System.out.println("Descrição do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Atualizado");
    }
    
    private void apagar(Scanner scanner){
        System.out.println("Id");
        int id = scanner.nextInt();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargoRepository.delete(cargo);
        System.out.println("Apagado");
    }

    private void listar(){
        System.out.println("Lista de cargos:");
        
        List<Cargo> lista = (List<Cargo>) cargoRepository.findAll();

        for (Cargo cargo : lista) {
            System.out.println(cargo);
        }

        System.out.println("-------------");
    }


}
