package com.example.tarefa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarefa.models.ListaDeTarefas;
import com.example.tarefa.repositories.ListaDeTarefasRepositories;
import java.util.Optional;
@Service
public class ListaDeTarefasServices {
    private final ListaDeTarefasRepositories tarefaRepository;

    @Autowired
    public ListaDeTarefasServices(ListaDeTarefasRepositories tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<ListaDeTarefas> listarTodasTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<ListaDeTarefas> buscarPorId(int id) {
        return tarefaRepository.findById(id);
    }

    public ListaDeTarefas salvarTarefa(ListaDeTarefas tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(int id) {
        tarefaRepository.deleteById(id);
    }
}
