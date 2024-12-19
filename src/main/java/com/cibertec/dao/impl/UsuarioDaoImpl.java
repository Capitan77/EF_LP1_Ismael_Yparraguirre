package com.cibertec.dao.impl;

import com.cibertec.dao.UsuarioDao;
import com.cibertec.models.Usuario;
import com.cibertec.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {
    @Override
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM Usuario";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("clave"),
                        rs.getBoolean("activo")
                ));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al conectar con la base de datos.", e);
        }

        return usuarios;
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        String query = "SELECT * FROM Usuario WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("clave"),
                        rs.getBoolean("activo")
                );
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al conectar con la base de datos.", e);
        }

        return null;
    }

    @Override
    public Usuario validarUsuario(String correo, String clave) throws SQLException {
        String query = "SELECT * FROM Usuario WHERE correo = ? AND clave = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, correo);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("clave"),
                        rs.getBoolean("activo")
                );
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al conectar con la base de datos.", e);
        }

        return null;
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO Usuario (nombre, apellido, correo, clave, activo) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getClave());
            ps.setBoolean(5, usuario.isActivo());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al conectar con la base de datos.", e);
        }
    }

    @Override
    public void editarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE Usuario SET nombre = ?, apellido = ?, correo = ?, clave = ?, activo = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getClave());
            ps.setBoolean(5, usuario.isActivo());
            ps.setInt(6, usuario.getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al conectar con la base de datos.", e);
        }
    }
}
