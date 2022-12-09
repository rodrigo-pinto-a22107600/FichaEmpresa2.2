package pt.ulusofona.lp2.empresasalarios;

import java.util.ArrayList;

class Empresa {
    private String nome;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();


    public Empresa(String nome) {
        this.nome = nome;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    Boolean contratar(Funcionario func){
        if(func != null && !funcionarios.contains(func)){
            funcionarios.add(func);
            return true;
        }
        return false;
    }

    boolean novoCliente(Cliente cliente){
        if(cliente == null){
            return false;
        }
        if(clientes.contains(cliente)){
            return false;
        }
        clientes.add(cliente);
        return true;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }


    public ArrayList<ClienteEmpresarial> getClientesEmpresariais(){
        ArrayList<ClienteEmpresarial> clientesEmpresarials = new ArrayList<>();
        for (Cliente cliente : getClientes()) {
            if(cliente.empresarial()){
                clientesEmpresarials.add((ClienteEmpresarial) cliente);
            }
        }
        return clientesEmpresarials;
    }

    public ArrayList<ClienteIndividual> getClientesIndividuais() {
        ArrayList<ClienteIndividual> clientesIndividuais = new ArrayList<>();
        for (Cliente cliente : getClientes()) {
            if(!cliente.empresarial()){
                clientesIndividuais.add((ClienteIndividual) cliente);
            }
        }
        return clientesIndividuais;
    }

    public ArrayList<String> getListaClientes(){
        ArrayList<String> clientes = new ArrayList<>();
        clientes.add("Lista de Clientes");
        for (ClienteEmpresarial clienteEmpresarial : getClientesEmpresariais()) {
            clientes.add(clienteEmpresarial.obtemInfo()[0] + " (Emp)");
            clientes.add(clienteEmpresarial.obtemInfo()[1]);
        }
        for (ClienteIndividual clienteIndividual : getClientesIndividuais()) {
            clientes.add(clienteIndividual.obtemInfo()[0] + " (Ind)");
        }
        return clientes;
    }

    public ArrayList<Tarefa> getTarefas(){
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        for (Funcionario funcionario : getFuncionarios()) {
            tarefas.addAll(funcionario.getTarefas());
        }
        return tarefas;
    }

    public ArrayList<String> obterRelatorioSalarios(String mes){
        ArrayList<String> relatorioSalarios = new ArrayList<>();
        relatorioSalarios.add("Relatório de Salários - mês de " + mes);


        for (Funcionario funcionario : getFuncionarios()) {
            relatorioSalarios.add(funcionario.getInfo(mes));
        }
        return relatorioSalarios;
    }

    public ArrayList<String> getRelatorioEncomendasMensais(String mes){
        ArrayList<String> result = new ArrayList<>();
        result.add("Relatório de encomendas mensais - mês de " + mes);
        for (Cliente cliente : clientes) {
            result.add(cliente.getInfoCliente(mes));
            result.addAll(cliente.getInformacaoTarefasMes(mes));
        }
        return result;
    }

    public ArrayList<String> getRelatorioDetalhado(String mes){
        ArrayList<String> relatorioDetalhado = new ArrayList<>();
        relatorioDetalhado.add("Relatório detalhado - mês de " + mes);
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario.getTarefas().size() > 0) {
                relatorioDetalhado.add("  " + funcionario.getNome() + " - " + funcionario.calculaSalario(mes));
                for (Tarefa tarefa : funcionario.getTarefas()) {
                    relatorioDetalhado.add("    " + tarefa.getDescricao() + " (" + tarefa.getNumHorasTrabalhadas() + ")");
                }
            } else {
                relatorioDetalhado.add("  " + funcionario.getNome() + " - " + funcionario.calculaSalario(mes));
                relatorioDetalhado.add("    Sem tarefas");
            }
        }
        return relatorioDetalhado;
    }
}
