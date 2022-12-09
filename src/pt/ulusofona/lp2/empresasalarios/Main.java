package pt.ulusofona.lp2.empresasalarios;

import java.util.ArrayList;

public class Main {
    static void contratar(Empresa empresa, Funcionario func){
        empresa.contratar(func);
    }

    static void associarTarefa(Empresa e, Funcionario f, Tarefa t, String mes){
        f.adicionarTarefa(t,mes);
    }

    static ArrayList<Funcionario> getFuncionarios(Empresa empresa){
        return empresa.getFuncionarios();
    }

    static ArrayList<Tarefa> getTarefas(Empresa empresa){
       return empresa.getTarefas();
    }

    static ArrayList<String> obterRelatorioSalarios(Empresa emp, String mes){
        return emp.obterRelatorioSalarios(mes);
    }

    static ArrayList<String> obterRelatorioDetalhado(Empresa emp, String mes){
        return emp.getRelatorioDetalhado(mes);
    }

    static Empresa obterUmaEmpresa(){
        Empresa forexExpert = new Empresa("Forex Experts");
        Cliente cliente1 = new ClienteEmpresarial("cliente1",923,314,"Eu",131);
        cliente1.adicionaTarefa(new Tarefa("Lavar as janelas"));
        forexExpert.novoCliente(cliente1);
        Cliente cliente2 = new ClienteIndividual("cliente2",131,12131);
        cliente2.adicionaTarefa(new Tarefa("pepepe"));
        forexExpert.novoCliente(cliente2);
        return forexExpert;
    }

    static void registarCliente(Empresa empresa, Cliente cliente) {
        empresa.novoCliente(cliente);
    }

    static void registarEncomenda(Empresa empresa, Cliente c, Tarefa t) {
        c.adicionaTarefa(t);
    }

    static ArrayList<ClienteEmpresarial> getClientesEmpresariais(Empresa empresa){
        return empresa.getClientesEmpresariais();
    }

    static ArrayList<ClienteIndividual> getClientesIndividuais(Empresa empresa){
        return empresa.getClientesIndividuais();
    }

    static ArrayList<Cliente> getClientes(Empresa empresa){
        return empresa.getClientes();
    }

    static ArrayList<String> obterListaClientes(Empresa emp){
        return emp.getListaClientes();
    }

    static ArrayList<String> relatorioEncomendasMensais(Empresa e, String mes){
        return e.getRelatorioEncomendasMensais(mes);
    }


    public static void main(String[] args) {

    }
}
