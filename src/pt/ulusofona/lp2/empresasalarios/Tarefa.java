package pt.ulusofona.lp2.empresasalarios;

import java.util.Objects;

class Tarefa {
    private String descricao;
    private int duracao;
    private int numHorasTrabalhadas;
    private Boolean completa = false;
    private String mes;
    private int preco;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    boolean terminarTarefa(int nrHoras){
        if(completa){
            return false;
        }
        if(nrHoras >= duracao){
            numHorasTrabalhadas += nrHoras;
            completa = true;
            return true;
        }
        numHorasTrabalhadas += nrHoras;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tarefa tarefa = (Tarefa) o;
        return duracao == tarefa.duracao &&
                Objects.equals(descricao, tarefa.descricao) &&
                Objects.equals(completa, tarefa.completa) &&
                Objects.equals(mes, tarefa.mes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, duracao, completa, mes);
    }

    public Boolean mudarMes(String mes){
        if(mes == null || mes.equals("")){
            return false;
        }
        this.mes = mes;
        return true;
    }

    public String getMes() {
        return mes;
    }


    public int getDuracao() {
        return duracao;
    }


    public String getDescricao() {
        return descricao;
    }

    private void calculaPreco(){
        preco = 500 + 10 * numHorasTrabalhadas;
    }

    public int getNumHorasTrabalhadas() {
        return numHorasTrabalhadas;
    }

    public String getDescTarefa(){
        calculaPreco();
        return descricao + " (" + numHorasTrabalhadas + " horas) (" + preco + ")";
    }

    public int getPreco() {
        calculaPreco();
        return preco;
    }
}
