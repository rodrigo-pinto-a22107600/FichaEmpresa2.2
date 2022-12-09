package pt.ulusofona.lp2.empresasalarios;

public class Gestor extends Funcionario{
    private int salarioBase;
    public Gestor(String nome,int salarioBase) {
        super(nome);
        this.salarioBase = salarioBase;
    }
}
