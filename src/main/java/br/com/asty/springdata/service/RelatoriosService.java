package br.com.asty.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {

        while (system) {
            System.out.println("Qual ação de cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionário por nome");
            System.out.println("2 - Buscar funcionário por nome, data de contratação e salário maior");

            int action = scanner.nextInt();

            switch (action) {

            case 1:
                buscaFuncionarioPorNome(scanner);
                break;
            case 2:
                buscaFuncionarioNomeSalarioMaiorData(scanner);
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

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Nome:");
        String nome = scanner.next();

        System.out.println("Data de contratação:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Salário:");
        Double salario = scanner.nextDouble();

        List<Funcionario> funcionarios = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario,
                localDate);

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

}
