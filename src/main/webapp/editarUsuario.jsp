<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Editar Usuario</h1>
    <form action="editarUsuario" method="post" class="card p-4 shadow-lg">
        <input type="hidden" name="id" value="${usuario.id}">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" value="${usuario.nombre}" required>
        </div>
        <div class="mb-3">
            <label for="apellido" class="form-label">Apellido</label>
            <input type="text" class="form-control" id="apellido" name="apellido" value="${usuario.apellido}" required>
        </div>
        <div class="mb-3">
            <label for="correo" class="form-label">Correo Electrónico</label>
            <input type="email" class="form-control" id="correo" name="correo" value="${usuario.correo}" required>
        </div>
        <div class="mb-3">
            <label for="activo" class="form-label">Activo</label>
            <input type="checkbox" id="activo" name="activo" value="true" ${usuario.activo ? "checked" : ""}>
        </div>
        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        <a href="usuarios" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>