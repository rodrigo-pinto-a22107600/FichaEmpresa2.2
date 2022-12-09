package pt.ulusofona.lp2.empresasalarios;

import java.util.Objects;

class ClienteEmpresarial extends Cliente{
    private String nomeResponsavel;
    private int telefoneResponsavel;

    public ClienteEmpresarial(String nome, int contactoTelefonico, int nif, String nomeResponsavel, int telefoneResponsavel) {
        super(nome, contactoTelefonico, nif);
        this.nomeResponsavel = nomeResponsavel;
        this.telefoneResponsavel = telefoneResponsavel;
    }

    @Override
    public String[] obtemInfo() {
        String[] infoPai = super.obtemInfo();
        String[] info = new String[2];
        info[0] = infoPai[0];
        info[1] = nomeResponsavel + " | " + telefoneResponsavel;
        return info;
    }

    @Override
    boolean empresarial() {
        return true;
    }

}
