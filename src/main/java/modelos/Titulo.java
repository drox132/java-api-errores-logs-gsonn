package modelos;


import dtos.TituloOmdb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Titulo {
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDelasEvaluaciones;

    private static final Logger logger = LogManager.getLogger(Titulo.class);

    public Titulo(TituloOmdb tituloOmdb) {
        logger.info("iniciando un Titulo con informacion de un TituloOmdb");
        this.nombre = tituloOmdb.title();
        try {
            this.fechaDeLanzamiento = Integer.valueOf(tituloOmdb.year());
            logger.info("Se pudo convertir la fecha de lanzamiento  de la pelicula al tipo de dato int");
        } catch (NumberFormatException e ) {
            logger.info("No se pudo convertir la fecha de lanzamiento de la pelicula al tipo de dato int");
            logger.error(e.getMessage());
            //throw new ConversionDuracionEnMinutosException("Hubo un error en la conversion del año de lanzamiento a tipo de dato int");
        }


        try {
            this.duracionEnMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0, 2).replace(" ", ""));
            logger.info("se pudo convertir el runtime de la pelicula");

            // System.out.println("se pudo convertir el runtime de la pelicula");
        }catch (NumberFormatException e) {
            logger.info("No se pudo convertir el runtime de la pelicula pero se atrapo el error y se asigno un valor valido al atributo qu fallo");
            logger.error(e.getMessage());
            //System.out.println("No se pudo convertir el runtime de la pelicula pero se atrapo el error y se asigno un valor valido al atributo qu fallo");
            this.setDuracionEnMinutos(0);
            //throw new ConversionDuracionEnMinutosException("Hubo un error en la conversion de la Duracion de la pelicula y se le asigno un 0 -> "+ e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getTotalDelasEvaluaciones(){
        return totalDelasEvaluaciones;
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre de la película es: " + nombre);
        System.out.println("Su fecha de lanzamiento es: " + fechaDeLanzamiento);
        System.out.println("Duración en minutos: "+ getDuracionEnMinutos());
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDelasEvaluaciones++;
    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones / totalDelasEvaluaciones;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre +
                        ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                        ", duracionEnMinutos=" + duracionEnMinutos +
                        ", incluidoEnElPlan=" + incluidoEnElPlan +
                        ", sumaDeLasEvaluaciones=" + sumaDeLasEvaluaciones +
                        ", totalDelasEvaluaciones=" + totalDelasEvaluaciones ;
    }
}
