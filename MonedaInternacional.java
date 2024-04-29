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

        String url_str = "https://v6.exchangerate-api.com/v6/02030c20bf8b98533e8b5c4c/latest/USD";

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        System.out.println("***************************************");
        System.out.println("Sea bienvenido al Conversor de monedas");

        System.out.println();
        System.out.println("1) Soles => Peso Argentino");
        System.out.println("2) Soles => Boliviano boliviano");
        System.out.println("3) Soles => Real Brasileño");
        System.out.println("4) Soles => Peso chileno");
        System.out.println("5) Soles => Peso Colombiano");
        System.out.println("6) Soles => Dólar estadounidense");
        System.out.println("7) Salir");
        System.out.println();
        System.out.println("Elija una opcion valida");
        System.out.println("***************************************");

        Scanner lectura = new Scanner(System.in);
        int opcion = Integer.parseInt(lectura.nextLine());

        double conversionRate = 0;
        String codigoInsertado = "";
        String codigoMultiplicado = "";

        switch (opcion) {
            case 1:

                conversionRate = jsonobj.getAsJsonObject("conversion_rates").get("ARS").getAsDouble();
                codigoInsertado = "Soles";
                codigoMultiplicado = "ARS";
                break;
            case 2:
                conversionRate = jsonobj.getAsJsonObject("conversion_rates").get("BOB").getAsDouble();
                codigoInsertado = "Soles";
                codigoMultiplicado = "BOB";
                break;
            case 3:
                conversionRate = jsonobj.getAsJsonObject("conversion_rates").get("BRL").getAsDouble();
                codigoInsertado = "Soles";
                codigoMultiplicado = "BRL";
                break;
            case 4:
                conversionRate = jsonobj.getAsJsonObject("conversion_rates").get("CLP").getAsDouble();
                codigoInsertado = "Soles";
                codigoMultiplicado = "CLP";
                break;
            case 5:
                conversionRate = jsonobj.getAsJsonObject("conversion_rates").get("COP").getAsDouble();
                codigoInsertado = "Soles";
                codigoMultiplicado = "COP";
                break;
            case 6:
                conversionRate = jsonobj.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
                codigoInsertado = "Soles";
                codigoMultiplicado = "USD";
                break;
            case 7:
                System.out.println("Saliendo");
                return;
            default:
                System.out.println("Opcion no valida");
                return;
        }
        System.out.println("Ingrese el monto a convertir");
        double montoConversion = Double.parseDouble((lectura.nextLine()));
        double montoConvertido = montoConversion * conversionRate;

        System.out.println("El valor "+ montoConversion + " " + codigoInsertado +" correspondiente al valor final es =>> " + montoConvertido + " " + codigoMultiplicado );
    }
}
