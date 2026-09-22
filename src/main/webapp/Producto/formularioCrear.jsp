<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto nuevo</title>
</head>
<body>
    <h2>Nuevo producto</h2>

<form action="${pageContext.request.contextPath}/Producto/nuevo" method="POST" enctype="multipart/form-data">        
        <label for="nombre">Nombre del producto:</label><br>
        <input type="text" name="nombre" required><br><br>
        
        <label for="categoria">Categoría: (1-comida/2-bebida)</label><br>
        <input type="text" name="categoria" required pattern="[1-2]"><br><br>

        <label for="descripcion">Descripción:</label><br>
        <input type="text" name="descripcion" required><br><br>
        
        <label for="precio">Precio:</label><br>
        <input type="number" name="precio" step="0.01" min="0" required><br><br>
        
         <label for="imagen">Imagen:</label><br>
        <input type="file" name="imagen" required><br><br>

        <button type="submit">Guardar</button>

    </form>
</body>
</html>