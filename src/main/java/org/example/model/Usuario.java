package org.example.model;

/**
 * Representa un usuario del sistema.
 */
public class Usuario {
    private Integer id;
    private String nombre_usuario;
    private String contraseña;

    /** Constructor por defecto. */
    public Usuario() {}

    /**
     * Constructor con parámetros.
     *
     * @param id             Identificador único del usuario.
     * @param nombre_usuario Nombre de usuario.
     * @param contraseña     Contraseña del usuario.
     */
    public Usuario(int id, String nombre_usuario, String contraseña) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }

    /** @return El identificador del usuario. */
    public Integer getId() {
        return id;
    }

    /** @param id Nuevo identificador del usuario. */
    public void setId(Integer id) {
        this.id = id;
    }

    /** @return El nombre de usuario. */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /** @param nombre_usuario Nuevo nombre de usuario. */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /** @return La contraseña del usuario. */
    public String getContraseña() {
        return contraseña;
    }

    /** @param contraseña Nueva contraseña del usuario. */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}