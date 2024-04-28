import java.util.Scanner;

public class Menu {
    Scanner leitura = new Scanner(System.in);
    ConsultaMoeda consultaMoeda = new ConsultaMoeda();
    Conversao conversao = new Conversao();

    public void menu () {
        int continuaPrograma = 1;

        while (continuaPrograma == 1) {
            System.out.println("""
                  *********** Conversor de Moedas ***********

                  Codigos disponiveis:

                  ARS - Peso argentino
                  BOB - Boliviano boliviano
                  BRL - Real brasileiro
                  CLP - Peso chileno
                  COP - Peso colombiano
                  USD - Dólar americano

                  Digite o codigo da moeda que deseja fazer a conversão:""");

            var moeda1 = leitura.nextLine();
            System.out.println("Para qual moeda quer converter? ");
            var moeda2 = leitura.nextLine();
            System.out.println("Qual valor deseja converter? ");
            var valorConversao = leitura.nextLine();

            try {
                Moeda novaMoeda = consultaMoeda.buscaEndereco(moeda1, moeda2);
                double conversaoMoeda = conversao.calcularConversao(Double.valueOf(valorConversao), novaMoeda);
                System.out.println("Valor convertido:  " + conversaoMoeda);
            } catch (RuntimeException e) {
                System.out.println(e);
            }

            System.out.println("Deseja continuar (1) ou sair (0)? ");
            continuaPrograma = Integer.parseInt(leitura.nextLine());
        }
    }
}

