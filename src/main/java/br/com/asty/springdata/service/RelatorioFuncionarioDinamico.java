package br.com.asty.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.asty.springdata.orm.Funcionario;
import br.com.asty.springdata.repository.FuncionarioRepository;
import specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {
    
    private final FuncionarioRepository funcionarioRepository;

    private final DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        System.out.println("Por favor digite o nome");
        String nome = scanner.next();

        if(nome.equalsIgnoreCase("NULL")){
            nome = null;
        }

        System.out.println("Por favor digite o cpf");
        String cpf = scanner.next();

        if(cpf.equalsIgnoreCase("NULL")){
            cpf = null;
        }

        System.out.println("Por favor digite o salario");
        Double salario = scanner.nextDouble();

        if(salario == 0){
            salario = null;
        } 

        System.out.println("Por favor digite o dataContratacao");
        String data = scanner.next();
        LocalDate dataContratacao = null;

        if(data.equalsIgnoreCase("NULL")){
            data = null;
        }else{
            dataContratacao = LocalDate.parse(data, fomatter);
        } 


        List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification.where(Specification
        .where(
            SpecificationFuncionario.nome(nome))
            .or(SpecificationFuncionario.cpf(cpf))
            .or(SpecificationFuncionario.salario(salario))
            .or(SpecificationFuncionario.dataContratacao(dataContratacao))));

        funcionarios.forEach(System.out::println);
    }

}
