package com.example.tarefa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ListaDeTarefas {

   
    private String tipoTarefa;
    private int quantTarefa; 
    @Id
    private int id;
    private String descricao;
    private Boolean feita;

     public ListaDeTarefas(String tipoTarefa, int quantTarefa, int id, String descricao, Boolean feita) {
        this.tipoTarefa = tipoTarefa;
        this.quantTarefa = quantTarefa;
        this.id = id;
        this.descricao = descricao;
        this.feita = feita;
    }
public ListaDeTarefas() {
    }
public String getTipoTarefa() {
    return tipoTarefa;
}
public void setTipoTarefa(String tipoTarefa) {
    this.tipoTarefa = tipoTarefa;
}
public int getQuantTarefa() {
    return quantTarefa;
}
public void setQuantTarefa(int quantTarefa) {
    this.quantTarefa = quantTarefa;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getDescricao() {
    return descricao;
}
public void setDescricao(String descricao) {
    this.descricao = descricao;
}
public Boolean getFeita() {
    return feita;
}
public void setFeita(Boolean feita) {
    this.feita = feita;
}}
