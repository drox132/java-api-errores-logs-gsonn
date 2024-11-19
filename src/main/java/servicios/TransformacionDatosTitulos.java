package servicios;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.TituloOmdb;
import modelos.Titulo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TransformacionDatosTitulos {

    private static final Logger logger = LogManager.getLogger(Titulo.class);

    public Titulo getTitulo(String nombre)  {


        ConexionApiOMDB con  = new ConexionApiOMDB(nombre);
        logger.debug("iniciando la transformacion de datos para obtener un titulo");

        //SI NO SE COLOCA ESTA CONFIGURACION DEL JSON NO TRAE DATOS YA QUE DIFIEREN LAS MAYUSCULAS DE MINUSCULAS
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        logger.info("se inicializo el Gson con el GsonBuilder para configurarle la opcion de que reconozca las mayusculas al inicio de cada atributo para que no haya diferencias con nuestra clase Titulo y se respeten las buenas practicas");
        String json = con.getJson();
        logger.info("se obtuvo el Json y ahora se mostrara la informacion que contiene");
        logger.info(json);
        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
        logger.info("Se realizo el traslado de la informacion del Json Al Dto que recibira los datos necesarios del Json");
        //System.out.println(tituloOmdb);
        logger.info("se procede a retornar el Titulo y a que el constructor del titulo realiza la parametrizacion");
        return new Titulo(tituloOmdb);
    }

}
