package br.edu.uapi.devshowcase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final ProjectRepository repository;

    public DataInitializer(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new Project(
                "Sistema de Biblioteca",
                "Aplicação para gerenciamento de livros e empréstimos.",
                "Java"
            ));
            repository.save(new Project(
                "Loja Virtual",
                "API para produtos, clientes e pedidos.",
                "Spring Boot"
            ));
            repository.save(new Project(
                "Agenda Online",
                "Sistema de cadastro e consulta de compromissos.",
                "JavaScript"
            ));
        }
    }
}
