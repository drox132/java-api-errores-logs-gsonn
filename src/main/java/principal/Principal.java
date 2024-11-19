package principal;

import modelos.Titulo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import servicios.PeticionesUsuario;
import servicios.TransformacionDatosTitulos;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    /*
     * Para esta configuración básica de logging en Java, utilizamos la biblioteca estándar
     *  java.util.logging, que viene integrada con el JDK. No es necesario descargar ni añadir
     * ninguna biblioteca externa; todo está incluido de forma nativa.*/

    private static final Logger logger = LogManager.getLogger(Titulo.class);
    
    public static void main(String[] args)   {
        logger.info("Iniciando la aplicacion");

        PeticionesUsuario entradaUsuario = new PeticionesUsuario();

        //boolean bandera= true;
        int contador =1;
        List<Titulo> listadoTitulosConsultados = new ArrayList<>();

        while (contador<3) {
            logger.info("Entramos en el bucle para que el usuario pida las peliculas que desee");

            logger.info("inician las peticiones");
            String nombrePeliculaBuscar = entradaUsuario.getNombrePelicula();

            logger.info("inician las tranformaciones de datos");
            TransformacionDatosTitulos transformacionDatosTitulos = new TransformacionDatosTitulos();
            Titulo  item = transformacionDatosTitulos.getTitulo(nombrePeliculaBuscar);
            logger.info("se agrega el titulo obtenido a la lista de titulos");
            logger.info(item.toString());
            listadoTitulosConsultados.add(item);
            listadoTitulosConsultados.forEach(e-> System.out.println(e));
            contador++;
            logger.warn("El contador cambia de valor a " + contador);

        }

        logger.info("Fin de la aplicacion");

    }
}