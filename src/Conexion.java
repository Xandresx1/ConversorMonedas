import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {
    String apiKey = "https://v6.exchangerate-api.com/v6/9d8a29ac758833cc5cab5062/latest/USD";

    //Creando al cliente HTTP
    HttpClient cliente = HttpClient.newHttpClient();

    public String ConexionOn() throws IOException, InterruptedException {
        try {
            // Creando la solicitud request
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiKey)).build();

            // Enviando la solicitud y obteniendo la respuesta
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
