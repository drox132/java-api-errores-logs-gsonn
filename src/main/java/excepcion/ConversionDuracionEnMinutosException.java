package excepcion;

public class ConversionDuracionEnMinutosException extends RuntimeException {

    private String mensaje;

    public ConversionDuracionEnMinutosException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
