<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Usuarios Registrados</h1>

    <a href="registroUsuario.jsp" class="btn btn-primary mb-3 ">Registrar Nuevo Usuario</a>

    <a href="CerrarSesion" class="btn btn-danger mb-3 ">Cerrar Sesion</a>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Correo</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
      <c:forEach var="usuario" items="${usuarios}">
          <tr class="${usuario.activo ? '' : 'table-secondary'}" style="${usuario.activo ? '' : 'opacity: 0.5;'}">
              <td>${usuario.id}</td>
              <td>${usuario.nombre}</td>
              <td>${usuario.apellido}</td>
              <td>${usuario.correo}</td>
              <td>${usuario.activo ? "Activo" : "Desactivado"}</td>
              <td>
                  <a href="editarUsuario?id=${usuario.id}" class="btn btn-warning btn-sm">Editar</a>
                  <a href="cambiarEstadoUsuario?id=${usuario.id}"
                     class="btn ${usuario.activo ? 'btn-danger' : 'btn-success'} btn-sm">
                     ${usuario.activo ? "Desactivar" : "Activar"}
                  </a>
              </td>
          </tr>
      </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>