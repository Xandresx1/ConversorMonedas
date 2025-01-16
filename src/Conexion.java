import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Conexion {
    private String inicio;
    private String fin;
    private double monto;
    private String apiKey;

    public Conexion(String inicio, String fin, double monto){
        this.inicio = inicio;
        this.fin = fin;
        this.monto = monto;
        construirApi();
    }

    public void construirApi(){
        this.apiKey = "https://v6.exchangerate-api.com/v6/9d8a29ac758833cc5cab5062/pair/" + inicio + "/" + fin + "/" + monto;
    }

    //Creando al cliente HTTP
    HttpClient cliente = HttpClient.newHttpClient();

    public String ConexionOn() throws IOException, InterruptedException {
        try {
            // Creando la solicitud request
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiKey)).build();

            // Enviando la solicitud y obteniendo la respuesta
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            String respuesta = response.body();
            Gson gson = new Gson();
            ResponseApi json = gson.fromJson(respuesta, ResponseApi.class);
            return formatearResultado(json);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String formatearResultado(ResponseApi resultado) {
        return String.format(
                "El valor %.2f [%s] convertido es: %.2f [%s]",
                monto,
                resultado.base_code(),
                resultado.conversion_result(),
                resultado.target_code()
        );
    }
}
