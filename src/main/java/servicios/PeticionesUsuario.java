package servicios;

import modelos.Titulo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class PeticionesUsuario {

    private static final Logger logger = LogManager.getLogger(Titulo.class);

    Scanner entrada = new Scanner(System.in);

    public int getNumeroOpcionUsuario() {
        logger.info("iniciando la peticion del numero de opcion a seleccionar al usuario");
        System.out.println("""
                ====================================================
                BIENVENIDO AL PROGRAMA DE PELICULAS BACK END
                SELECCIONE EL NUMERO DE LA OPCION QUE DESEE
                1.- BUSCAR UNA PELICULA
                2.- SALIR
                """);
        int opcionSeleccionada = entrada.nextInt();
        return opcionSeleccionada;
    }

    public String getNombrePelicula() {
        logger.info("iniciando la peticion del nombre de la pelicula a buscar al usuario");
        System.out.println("INGRESE EL NOMBRE DE LA PELICULA QUE DESEA BUSCAR");
        return entrada.nextLine();
    }
}
