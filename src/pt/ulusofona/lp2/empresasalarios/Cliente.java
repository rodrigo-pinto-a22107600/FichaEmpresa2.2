package pt.ulusofona.lp2.empresasalarios;

import java.util.ArrayList;
import java.util.Objects;

abstract class Cliente {
    protected String nome;
    protected int contactoTelefonico;
    protected int nif;
    protected ArrayList<Tarefa> tarefas = new ArrayList<>();
    private int total = 0;


    public Cliente(String nome, int contactoTelefonico, int nif) {
        this.nome = nome;
        this.contactoTelefonico = contactoTelefonico;
        this.nif = nif;
    }

    public String[] obtemInfo(){
        String[] info = new String[1];
        info[0] = nome + " | " + contactoTelefonico + " | " + nif;
        return info;
    }

    abstract boolean empresarial();

    public void adicionaTarefa(Tarefa tarefa){
        if(!(tarefa == null || tarefas.contains(tarefa))){
            tarefas.add(tarefa);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return contactoTelefonico == cliente.contactoTelefonico && nif == cliente.nif && Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, contactoTelefonico, nif);
    }

    public ArrayList<String> getInformacaoTarefasMes(String mes){
        ArrayList<String> result = new ArrayList<>();
        total = 0;
        for (Tarefa tarefa : tarefas) {
            if(tarefa.getMes().equals(mes)){
                total += tarefa.getPreco();
                result.add(tarefa.getDescTarefa());
            }
        }
        return result;
    }

    public int getTotalMes(String mes) {
        getInformacaoTarefasMes(mes);
        return total;
    }

    public String getInfoCliente(String mes){
        if(empresarial()){
            return nome + " (Emp) (a pagar: " + getTotalMes(mes) + " euros)";
        }
        else{
            return nome + " (Ind) (a pagar: " + getTotalMes(mes) + " euros)";
        }
    }
}
