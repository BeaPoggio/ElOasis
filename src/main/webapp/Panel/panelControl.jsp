<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel de Control - El Oasis</title>

</head>
<body>

	<div class="cabecera">
		<h1>🌿 EL OASIS - ADMINISTRACIÓN</h1>
		<nav>
			<a href="${pageContext.request.contextPath}/Producto/nuevo">➕
				NUEVO PRODUCTO</a> <a href="${pageContext.request.contextPath}/Producto">🚪
				SALIR</a>
		</nav>
	</div>

	<div class="tabla-container">
		<h2>Listado Actual de Productos</h2>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Categoría</th>
					<th>Precio</th>
					<th>Imagen</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${productosAdmin}">
					<tr>
						<td>${p.id_prod}</td>
						<td>${p.nombre}</td>
						<td>${p.categoria == 1 ? 'Comida' : 'Bebida'}</td>
						<td>${p.precio}€</td>
						<td>${p.imagen}</td>
						
						<td>
							<form
								action="${pageContext.request.contextPath}/Producto/actualizarPrecio"
								method="GET" style="display: inline;">
								<input type="hidden" name="id" value="${p.id_prod}"> 
								<input type="number" name="precio" step="0.01" placeholder="Nuevo precio" required>
								<button type="submit">Actualizar precio</button>
							</form>
						</td>
						<td><a
							href="${pageContext.request.contextPath}/Producto/eliminar?id=${p.id_prod}"
							onclick="return confirm('¿Seguro que quieres eliminar este producto?')">
								Eliminar </a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>