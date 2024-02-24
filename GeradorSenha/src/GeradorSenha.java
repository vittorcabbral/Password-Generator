import java.util.LinkedList;
import java.util.Random;

public class GeradorSenha {

    public GeradorSenha() {
    }

    public Senha gerarSenha(LinkedList<Senha> filaSenha) {
        Senha senha = senhaString();
        while(senhaValida(filaSenha, senha) == false){
            senha = senhaString();
        }
        return senha;
    }

    public boolean senhaValida(LinkedList<Senha> filaSenha, Senha senha){

        for(int i = 0; i < filaSenha.size(); i++){
            if(senha == filaSenha.get(i)){
                return false;
            }
        }
        return true;
    }

    private Senha senhaString(){
        String caracteres = "abcdefghijklmnopqrstuvwxyz";

        Random aleatorio = new Random();
         
        String senha = "";

        for (int i = 0; i < 4; i++) {

            int posicao = aleatorio.nextInt(caracteres.length());
            char charAleatorio = caracteres.charAt(posicao);
            if (i % 2 == 0) {
                senha += Character.toUpperCase(charAleatorio);
            } else {
                senha += charAleatorio;
            }

            int valor = aleatorio.nextInt(10);
            senha += valor;
        }
        return new Senha(senha);
    }

}
