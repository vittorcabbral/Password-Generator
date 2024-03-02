import java.util.LinkedList;

public class Fila {
    private GeradorSenha geradorS;
    private LinkedList<Senha> filaSenhaN; // senha normal
    private LinkedList<Senha> filaSenhaP;// senha prioridade
    private boolean controlePrioridade;

    public Fila() {
        this.filaSenhaN = new LinkedList<Senha>();
        this.filaSenhaP = new LinkedList<Senha>();
        this.geradorS = new GeradorSenha();
        this.controlePrioridade = true;
    }

    private LinkedList<Senha> getFilaSenhaN() {
        return filaSenhaN;
    }

    private LinkedList<Senha> getFilaSenhaP() {
        return filaSenhaP;
    }

    private boolean getControlePrioridade() {
        return controlePrioridade;
    }

    private void setControlePrioridade(boolean controlePrioridade) {
        this.controlePrioridade = controlePrioridade;
    }

    public String criarSenha(boolean prioridade) {
        Senha senha = geradorS.gerarSenha(prioridade);

        if(prioridade){
            this.filaSenhaP.add(senha);
            return "\nNova senha - Prioridade: " + senha.getSenha();
        }

        this.filaSenhaN.add(senha);
        return "\nNova senha: " + senha.getSenha();
    }

    public String chamarSenha() {

        if((this.getFilaSenhaN().isEmpty()) && (this.getFilaSenhaP().isEmpty())){
            return "Todas as filas estão vazias!";
        }
        
        if(this.getControlePrioridade()){
            return this.chamarSenhaP();
        }

        return this.chamarSenhaN();
    }

    private String chamarSenhaN() {
        
        if(!this.getFilaSenhaN().isEmpty()) {
            Senha primeiraSenha = this.getFilaSenhaN().get(0);
            this.getFilaSenhaN().remove(0);
            this.setControlePrioridade(true);
            return "\nSenha: " + primeiraSenha.getSenha();
        }else{
            return this.chamarSenhaP();
        }
    }

    private String chamarSenhaP() {
        if(!this.getFilaSenhaP().isEmpty()) {
            Senha primeiraSenha = this.getFilaSenhaP().get(0);
            this.getFilaSenhaP().remove(0);
            this.setControlePrioridade(false);
            return "\nSenha - Prioridade: " + primeiraSenha.getSenha();
        }else{
            return this.chamarSenhaN();
        }
    }

    public String toString(boolean prioridade) {

        String senha = null;
        
        if(prioridade){
            if(!this.getFilaSenhaP().isEmpty()){
                senha = "";
                for(int i = 0; i < this.getFilaSenhaP().size(); i++) {
                    senha += this.getFilaSenhaP().get(i).getSenha() + "/ ";
                }
                return "Fila - Prioridade = " + senha;
            }else{
                return "Fila - Prioridade = " + senha;
            }
        }

        if(!this.getFilaSenhaN().isEmpty()) {
            senha = "";
            for(int i = 0; i < this.getFilaSenhaN().size(); i++) {
                senha += this.getFilaSenhaN().get(i).getSenha() + "/ ";
            }
            return "Fila = " + senha;
        }
        return "Fila = " + senha;
    }
}
