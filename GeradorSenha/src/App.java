import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Fila novaFila = new Fila();

        while(true){
            System.out.println("\nGERENCIADOR DE SENHA");
            System.out.println("1 - Criar senha.");
            System.out.println("2 - Criar senha - Prioridade.");
            System.out.println("3 - Chamar senha.");
            System.out.println("4 - Ver fila.");
            System.out.println("5 - Ver fila - Prioridade.");
            System.out.println("6 - Fechar Gerenciador de senha.");
            System.out.print("\nDigite a opção: ");
            int opc = leitor.nextInt();

            if (opc == 1) System.out.println(novaFila.criarSenha(false));
            if (opc == 2) System.out.println(novaFila.criarSenha(true));
            // if (opc == 3) System.out.println(novaFila.chamarSenha());
            if (opc == 4) System.out.println(novaFila.toString(false));
            if (opc == 5) System.out.println(novaFila.toString(true));
            if (opc == 6) break;
            if ((opc < 1) || (opc > 6)) System.out.println("Digite uma opção válida!");
        }
       leitor.close();
    }
}