import java.util.LinkedList;

public class Fila {
    private GeradorSenha geradorS;
    private LinkedList<Senha> filaSenhaN; // senha normal
    private LinkedList<Senha> filaSenhaP;// senha prioridade
    // private boolean controlePrioridade;

    public Fila() {
        this.filaSenhaN = new LinkedList<Senha>();
        this.filaSenhaP = new LinkedList<Senha>();
        this.geradorS = new GeradorSenha();
        // this.controlePrioridade = true;
    }

    private  LinkedList<Senha> getFilaSenhaN() {
        return filaSenhaN;
    }

    private LinkedList<Senha> getFilaSenhaP() {
        return filaSenhaP;
    }

    // private boolean getControlePrioridade() {
    //     return controlePrioridade;
    // }

    // private void setControlePrioridade(boolean controlePrioridade) {
    //     this.controlePrioridade = controlePrioridade;
    // }

    public String criarSenha(boolean prioriade) {
        Senha senha = geradorS.gerarSenha(prioriade);
        if(prioriade){
            this.filaSenhaP.add(senha);
            return "\nNova senha - Prioridade: " + senha.getSenha();
        }
        this.filaSenhaN.add(senha);

        return "\nNova senha: " + senha.getSenha();
    }

    // public String chamarSenha() {

    //     if(filaSenha.isEmpty()){
    //         return "Fila vazia!";
    //     }
    //     Senha primeiraSenha = this.filaSenha.get(0);
    //     filaSenha.remove(filaSenha.get(0));
    //     return "\nSenha: " + primeiraSenha.getSenha();
    // }

    public String toString(boolean prioriade) {

        String senha = null;
        
        if(prioriade){
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
