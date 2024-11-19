package excepcion;

public class ConexionApiOmdbExcepcion extends RuntimeException {
    private String mensaje;

    public ConexionApiOmdbExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return mensaje;
    }
}
