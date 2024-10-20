package org.example.dao;

import org.example.model.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object para gestionar las copias de usuario.
 */
public class CopiasDAO {

    /**
     * Obtiene las copias asociadas a un usuario.
     *
     * @param idUsuario Identificador del usuario.
     * @return Lista de copias.
     */
    public static List<String> obtenerCopiasPorUsuario(int idUsuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rss = null;
        List<String> copias = new ArrayList<>();
        String query = "SELECT p.titulo, c.id_pelicula FROM Copia c JOIN Pelicula p ON c.id_pelicula = p.id WHERE c.id_usuario = ?";


        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    String nombrePelicula = resultSet.getString("titulo");
                    int idPelicula = resultSet.getInt("id_pelicula");
                    copias.add(nombrePelicula + "    : Registro: " + idPelicula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (rss != null) rss.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return copias;
    }
}