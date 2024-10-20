package org.example.model;

/**
 * Representa una película con atributos básicos como título, género, año, descripción y director.
 */
public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int año;
    private String descripcion;
    private String director;

    /**
     * Constructor de la clase Pelicula.
     *
     * @param id          Identificador único de la película.
     * @param titulo      Título de la película.
     * @param genero      Género de la película.
     * @param año         Año de lanzamiento de la película.
     * @param descripcion Breve descripción de la película.
     * @param director    Nombre del director de la película.
     */
    public Pelicula(int id, String titulo, String genero, int año, String descripcion, String director) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
        this.descripcion = descripcion;
        this.director = director;
    }

    /**
     * Obtiene el identificador de la película.
     *
     * @return El identificador único de la película.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la película.
     *
     * @param id El nuevo identificador de la película.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el título de la película.
     *
     * @return El título de la película.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la película.
     *
     * @param titulo El nuevo título de la película.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el género de la película.
     *
     * @return El género de la película.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género de la película.
     *
     * @param genero El nuevo género de la película.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el año de lanzamiento de la película.
     *
     * @return El año de la película.
     */
    public int getAño() {
        return año;
    }

    /**
     * Establece el año de lanzamiento de la película.
     *
     * @param año El nuevo año de la película.
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Obtiene la descripción de la película.
     *
     * @return La descripción de la película.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la película.
     *
     * @param descripcion La nueva descripción de la película.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el nombre del director de la película.
     *
     * @return El nombre del director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Establece el nombre del director de la película.
     *
     * @param director El nuevo director de la película.
     */
    public void setDirector(String director) {
        this.director = director;
    }
}