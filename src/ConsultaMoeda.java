import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {

        public Moeda buscaEndereco(String tipoMoeda1, String tipoMoeda2) {
            URI endereco = URI.create("https://v6.exchangerate-api.com/v6/e8af78e10dd2b0ff5c9ece4d/pair/" + tipoMoeda1 + "/" + tipoMoeda2);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

            try {
                HttpResponse<String> response = HttpClient
                        .newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Moeda.class);

            } catch (Exception e) {
                throw new RuntimeException("Não consegui fazer a conversão a partir dessa moeda.");
            }
        }
}
