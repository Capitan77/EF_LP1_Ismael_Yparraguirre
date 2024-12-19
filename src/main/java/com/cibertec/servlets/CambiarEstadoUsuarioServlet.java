package com.cibertec.servlets;

import com.cibertec.dao.UsuarioDao;
import com.cibertec.dao.impl.UsuarioDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CambiarEstadoUsuario", urlPatterns = "/cambiarEstadoUsuario")
public class CambiarEstadoUsuarioServlet extends HttpServlet {
    private final UsuarioDao usuarioDAO = new UsuarioDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            boolean estadoActual = usuarioDAO.obtenerEstadoUsuario(id);

            usuarioDAO.cambiarEstadoUsuario(id, !estadoActual);

            response.sendRedirect("usuarios");
        } catch (SQLException e) {
            throw new ServletException("Error al cambiar el estado del usuario", e);
        }
    }
}