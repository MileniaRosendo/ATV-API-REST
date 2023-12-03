package com.example.tarefa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tarefa.models.ListaDeTarefas;
import com.example.tarefa.services.ListaDeTarefasServices;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class ListaDeTarefaControllers {
    

    private final ListaDeTarefasServices tarefaService;

    @Autowired
    public ListaDeTarefaControllers(ListaDeTarefasServices tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<ListaDeTarefas>> listarTodasTarefas() {
        List<ListaDeTarefas> tarefas = tarefaService.listarTodasTarefas();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDeTarefas> buscarPorId(@PathVariable int id) {
        return tarefaService.buscarPorId(id)
                .map(tarefa -> new ResponseEntity<>(tarefa, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ListaDeTarefas> criarTarefa(@RequestBody ListaDeTarefas tarefa) {
        ListaDeTarefas novaTarefa = tarefaService.salvarTarefa(tarefa);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDeTarefas> atualizarTarefa(@PathVariable int id, @RequestBody ListaDeTarefas tarefaAtualizada) {
        return (ResponseEntity<ListaDeTarefas>) tarefaService.buscarPorId(id)
                .map(tarefa -> {
                    tarefa.setDescricao(tarefaAtualizada.getDescricao());
                    tarefa.setFeita(tarefaAtualizada.getFeita());
                    ListaDeTarefas tarefaAtualizadaDb = tarefaService.salvarTarefa(tarefa);
                    return new ResponseEntity<>(tarefaAtualizadaDb, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable int id) {
        if (tarefaService.buscarPorId(id).isPresent()) {
            tarefaService.deletarTarefa(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
