package modelos;

import dtos.TituloOmdb;

public class Pelicula extends Titulo {
    private String director;

    public Pelicula(TituloOmdb tituloOmdb) {
        super(tituloOmdb);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}