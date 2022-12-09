package pt.ulusofona.lp2.empresasalarios;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMain {
    @Test
    public void testeRegistarClienteEmpresarial(){
        Empresa teste = Main.obterUmaEmpresa();
        ClienteEmpresarial novoCliente = new ClienteEmpresarial("Rod",91291831,1214113,"kasja",12131);
        teste.novoCliente(novoCliente);
        assertEquals(2,teste.getClientesEmpresariais().size());
    }

    @Test
    public void testeRegistarClienteIndividual(){
        Empresa teste = Main.obterUmaEmpresa();
        ClienteIndividual novoCliente = new ClienteIndividual("Rod",91291831,1214113);
        teste.novoCliente(novoCliente);
        assertEquals(2,teste.getClientesIndividuais().size());
    }

    @Test
    public void testeRegistar2ClienteIndividual(){
        Empresa teste = Main.obterUmaEmpresa();
        ClienteIndividual novoCliente = new ClienteIndividual("Rod",91291831,1214113);
        teste.novoCliente(novoCliente);
        teste.novoCliente(novoCliente);
        assertEquals(2,teste.getClientesIndividuais().size());
    }

    @Test
    public void testeRegistar2ClienteEmpresarial(){
        Empresa teste = Main.obterUmaEmpresa();
        ClienteEmpresarial novoCliente = new ClienteEmpresarial("Rod",91291831,1214113,"kasja",12131);
        teste.novoCliente(novoCliente);
        teste.novoCliente(novoCliente);
        assertEquals(2,teste.getClientesEmpresariais().size());
    }
}
