public class Conversao {

    public double calcularConversao(Double valorConversao, Moeda novaMoeda) {

        Double razaoConversao = Double.valueOf(novaMoeda.conversion_rate());

        return valorConversao * razaoConversao;
    }
}
