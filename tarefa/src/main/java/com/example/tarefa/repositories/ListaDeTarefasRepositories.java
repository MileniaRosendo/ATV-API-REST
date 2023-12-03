package com.example.tarefa.repositories;

import org.springframework.stereotype.Repository;
import com.example.tarefa.models.ListaDeTarefas;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ListaDeTarefasRepositories extends JpaRepository<ListaDeTarefas, Integer> {
}
