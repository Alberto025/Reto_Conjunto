package org.example.dao;

import org.example.model.JdbcUtils;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object para gestionar usuarios en la base de datos.
 */
public class UsuarioDAO {

    /**
     * Valida un usuario según su nombre y contraseña.
     *
     * @param nombre_usuario Nombre del usuario.
     * @param contraseña     Contraseña del usuario.
     * @return El objeto Usuario si es válido, o null si no lo es.
     */
    public Usuario validarUsuario(String nombre_usuario, String contraseña) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            con = JdbcUtils.getConnection();

            ps = con.prepareStatement("SELECT * FROM USUARIO WHERE nombre_usuario = ? AND contraseña = ?"); {
                ps.setString(1, nombre_usuario);
                ps.setString(2, contraseña);
                rs = ps.executeQuery();
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                    usuario.setContraseña(rs.getString("contraseña"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(rs!=null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
}