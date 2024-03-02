public class GeradorSenha {
    private int numeroN;
    private int numeroP;

    public GeradorSenha() {
    }
    
    private int getNumeroN() {
        return numeroN;
    }


    private void setNumeroN(int numeroN) {
        this.numeroN = numeroN;
    }


    private int getNumeroP() {
        return numeroP;
    }


    private void setNumeroP(int numeroP) {
        this.numeroP = numeroP;
    }

    public Senha gerarSenha(boolean prioridade){
        String senha = "";

        if(prioridade){
            this.setNumeroP(this.getNumeroP() + 1);
            senha = String.format("P%03d", this.getNumeroP());
            return new Senha(senha);
        }
        this.setNumeroN(this.getNumeroN() + 1);
        senha = String.format("N%03d", this.getNumeroN());

        return new Senha(senha);
    }

}
