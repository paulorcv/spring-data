package br.com.asty.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.asty.springdata.orm.Funcionario;
import br.com.asty.springdata.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

    @Autowired
    private final FuncionarioRepository funcionarioRepository;
    private boolean system = true;

    
    
    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {

        while (system) {
            System.out.println("Qual ação de cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionário por nome");

            int action = scanner.nextInt();

            switch (action) {

            case 1:
                buscaFuncionarioPorNome(scanner);
                break;

            default:
                system = false;
                break;
            }
        }

    }

    private void buscaFuncionarioPorNome(Scanner scanner) {
        System.out.println("Nome:");
        String nome = scanner.next();
        
        List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);       
        
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

    }

}
