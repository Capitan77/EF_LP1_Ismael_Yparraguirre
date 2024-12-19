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


@WebServlet(name = "CerrarSesion", urlPatterns = "/CerrarSesion")


//Creamos el SERVLET CERRAR SESION SERVLET
public class CerrarSesionServlet extends HttpServlet {
    //Llamamos a un metodo GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Obtenemos la sesion actual
        HttpSession session = request.getSession(false);
        //En caso la sesion sea diferente de Null,es decir se encuentre abierta
        if (session != null) {
            //se cerrara y nos enviará al LOGIN.JSP
            session.invalidate();
        }
        response.sendRedirect("login.jsp");
    }
}