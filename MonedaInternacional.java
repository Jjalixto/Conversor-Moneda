import Controller.Metodos;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MonedaInternacional {
    public static void main(String[] args) throws IOException {

        Scanner lectura = new Scanner(System.in);
        var busqueda = lectura.nextLine();

        String url_str = "https://v6.exchangerate-api.com/v6/02030c20bf8b98533e8b5c4c/latest/USD";

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        try {
            String req_result = jsonobj.get("result").getAsString();
            System.out.println("200");
        }catch (Exception e){
            System.out.println("400");
        }

        JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
        String[] currenciesToFind = {busqueda};
        //"ARS", "BOB", "BRL", "CLP","COP",
        for (String currencyCode : currenciesToFind) {
            double conversionRate = conversionRates.get(currencyCode).getAsDouble();
            System.out.println(conversionRate);
        }
        double montoTotal = 20;
        Metodos metodos = new Metodos();
        metodos.soles(1.5,2.5);
        System.out.println(metodos.soles(1.5,2.5));
    }
}
