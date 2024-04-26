import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaMoeda consultaMoeda = new ConsultaMoeda();

        System.out.println("Digite um codigo de moeda aqui: ");
        var moeda = leitura.nextLine();

        try {
            Moeda novaMoeda = consultaMoeda.buscaEndereco(moeda);
            System.out.println(novaMoeda);
        } catch (RuntimeException e) {
            System.out.println(e);
        }

    }
}