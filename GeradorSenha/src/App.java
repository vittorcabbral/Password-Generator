import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Fila novaFila = new Fila();

        while(true){
            System.out.println("\nGERENCIADOR DE SENHA");
            System.out.println("1 - Criar senha.\n2 - Chamar senha.\n3 - Ver fila.\n4 - Fechar o Gerenciador de senha.");
            System.out.print("\nDigite a opção: ");
            int opc = leitor.nextInt();

            if (opc == 1) System.out.println(novaFila.criarSenha());
            if (opc == 2) System.out.println(novaFila.chamarSenha());
            if (opc == 3) System.out.println(novaFila.toString());
            if (opc == 4) break;
            if ((opc < 1) || (opc > 4)) System.out.println("Digite uma opção válida!");
        }
       leitor.close();
    }
}