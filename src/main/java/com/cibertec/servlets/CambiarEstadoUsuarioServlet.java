package com.cibertec.servlets;

import com.cibertec.dao.UsuarioDao;
import com.cibertec.dao.impl.UsuarioDaoImpl;
import com.cibertec.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cambiarEstadoUsuario")
public class CambiarEstadoUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtiene el ID del usuario desde los parámetros
            int idUsuario = Integer.parseInt(request.getParameter("id"));

            // Inicializa el DAO
            UsuarioDao usuarioDao = new UsuarioDaoImpl();

            // Obtiene el estado actual y lo invierte
            boolean estadoActual = usuarioDao.obtenerEstadoUsuario(idUsuario);
            boolean nuevoEstado = !estadoActual;

            // Cambia el estado en la base de datos
            usuarioDao.cambiarEstadoUsuario(idUsuario, nuevoEstado);

            // Redirige nuevamente a la lista de usuarios
            response.sendRedirect("usuarios");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cambiar el estado del usuario.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de usuario inválido.");
        }
    }
}