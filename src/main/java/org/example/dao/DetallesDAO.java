package org.example.dao;

import org.example.model.JdbcUtils;
import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object para obtener detalles de películas.
 */
public class DetallesDAO {
    /**
     * Obtiene los detalles de una película por su ID.
     *
     * @param idPelicula ID de la película.
     * @return Objeto Pelicula con los detalles.
     */
    public static Pelicula obtenerDetallesPelicula(int idPelicula) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT titulo, genero, año, descripcion, director FROM Pelicula WHERE id = ?";
        Pelicula pelicula = null;

        try {
            conexion = JdbcUtils.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPelicula);
            rs = ps.executeQuery();
            if (rs.next()) {
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                int año = rs.getInt("año");
                String descripcion = rs.getString("descripcion");
                String director = rs.getString("director");
                pelicula = new Pelicula(idPelicula, titulo, genero, año, descripcion, director);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pelicula;
    }
}