package servicios;

import excepcion.ConexionApiOmdbExcepcion;
import modelos.Titulo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApiOMDB {

    private final String URL_BASE = "https://www.omdbapi.com/";
    private final String API_KEY = "f28e7022";
    private String nombrePeliculaBuscada ;

    private static final Logger logger = LogManager.getLogger(Titulo.class);

    //CONSTRUCTOR
    public ConexionApiOMDB(String nombrePeliculaBuscada) {

        logger.debug("Entramos en la instancia de la conexion a la API");
        this.nombrePeliculaBuscada = configurarNombrePeliculaBuscada(nombrePeliculaBuscada);
    }

    //METODOS PUBLICOS QUE SE UTILIZARAN DESPUES DE LA INSTANCIA

    public String getJson()  {
        logger.info("Se entro al metodo getJson de la clase ConexionApiOmd para obtener la respuesta de acuerdo a la busqueda por nombre");
        //ARMADO DE URL PARA LA API OMDB
        String url = URL_BASE + "?t=" + nombrePeliculaBuscada + "&apikey=" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Se logro obtener los datos de la API y se retornara el body");
        } catch (IOException |InterruptedException e) {
            logger.warn("Ha ocurrido un error al traer los datos de la Api");
            logger.error(e.toString());
            throw new ConexionApiOmdbExcepcion("ha ocurrido un error al traer los datos de la api "+e.getMessage());
        }


        return response.body();
    }




    //METODOS DE LA CLASE PRIVADOS
    private String configurarNombrePeliculaBuscada (String nombre){
        logger.info("la instancia llamo a un metodo que configura el nombre de la pelicula agregandole + si tiene espacios");
        return nombre.replace(" ", "+");
    }
}

