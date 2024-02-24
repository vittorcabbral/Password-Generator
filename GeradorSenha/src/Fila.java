import java.util.LinkedList;

public class Fila {
    private GeradorSenha geradorS;
    private LinkedList<Senha> filaSenha;

    public Fila() {
        this.filaSenha = new LinkedList<Senha>();
        this.geradorS = new GeradorSenha();
    }

    public  LinkedList<Senha> getFilaSenha() {
        return filaSenha;
    }

    public String criarSenha() {
        Senha senha = geradorS.gerarSenha(this.getFilaSenha());
        this.filaSenha.add(senha);

        return "\nNova senha: " + senha.getSenha();
    }

    public String chamarSenha() {

        if(filaSenha.isEmpty()){
            return "Fila vazia!";
        }
        Senha primeiraSenha = this.filaSenha.get(0);
        filaSenha.remove(filaSenha.get(0));
        return "\nSenha: " + primeiraSenha.getSenha();
    }

    @Override
    public String toString() {

        String senha = null;
        if(!filaSenha.isEmpty()){
            senha = "";
            for(int i = 0; i < filaSenha.size(); i++){
                senha += filaSenha.get(i).getSenha() + "/ ";
            }
        }
        return "Fila = " + senha;
    }
}
