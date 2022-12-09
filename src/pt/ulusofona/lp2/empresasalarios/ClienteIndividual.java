package pt.ulusofona.lp2.empresasalarios;

class ClienteIndividual extends Cliente{


    public ClienteIndividual(String nome, int contactoTelefonico, int nif) {
        super(nome, contactoTelefonico, nif);
    }


    @Override
    boolean empresarial() {
        return false;
    }


}
