package pt.ulusofona.lp2.empresasalarios;

import java.util.ArrayList;
import java.util.Objects;

class Funcionario {
    private String nome;
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Funcionario that = (Funcionario) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(tarefas, that.tarefas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tarefas);
    }

    Boolean adicionarTarefa(Tarefa tarefa, String mes){
        if(tarefa != null && mes != null &&!tarefas.contains(tarefa)){
            tarefa.mudarMes(mes);
            tarefas.add(tarefa);
            return true;
        }
        return false;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    int calculaSalario(String mes){
        int numHoras = 0;
        int bonus = 0;
        int nrTarefas = 0;

        for (Tarefa tarefa : tarefas) {
            if(tarefa.getMes().equals(mes)){
                numHoras += tarefa.getNumHorasTrabalhadas();
                nrTarefas++;
            }
        }

        if(nrTarefas > 10 && numHoras < 50){
            bonus = nrTarefas - 5;
        }
        return 505 + 2 * numHoras + bonus;
    }

    public String getInfo(String mes){
        return "  " + getNome() + " - " + calculaSalario(mes);
    }
}
