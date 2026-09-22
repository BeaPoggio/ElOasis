<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Importamos la librería JSTL para poder usar el bucle forEach --%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El Oasis</title>
<link rel="stylesheet" type="text/css" href="prueba.css">
</head>
<body>

	<header class="navbar">
		<div class="logo">🌿 EL OASIS</div>

		<nav>
			<ul class="nav-links">
				<li><a href="#inicio">Inicio</a></li>
				<li><a href="#comida">Comida</a></li>
				<li><a href="#bebida">Bebidas</a></li>
				<li><a href="#reservas">Reserva una mesa</a></li>
				<li><a href="#contacto">Contacto</a></li>
				<li><a href="/ProyectoProgramacionWeb/Producto/login">Login</a></li>
				
			</ul>
		</nav>
	</header>


	<section id="inicio" class="hero">

		<div class="hero-content">
			<h1>BIENVENIDOS A EL OASIS</h1>
			<p>DONDE LOS CLÁSICOS COBRAN VIDA Y LOS NUEVOS SABORES COMIENZAN</p>

			<a href="#comida" class="btn">VER LA CARTA</a>
		</div>
	</section>

	<section id="comida" class="menu-section">
		<article>


			<h2 class="section-title">COMIDAS DESTACADAS</h2>

			<div class="grid">

				<c:forEach items="${misProductos}" var="p">

					<div class="card">

						<img src="${pageContext.request.contextPath}/img/${p.imagen}" alt="${p.nombre}">
						<h3>${p.nombre}</h3>

						<p>${p.descripcion}</p>

						<p>${p.precio}€</p>

					</div>

				</c:forEach>

			</div>
		</article>

	</section>


	<section id="bebida" class="menu-section">
		<article>
			<h2 class="section-title">BEBIDAS</h2>

			<div class="grid">

				<c:forEach items="${misBebidas}" var="b">

					<div class="card">

						<img src="${pageContext.request.contextPath}/img/${b.imagen}" alt="${b.nombre}">

						<h3>${b.nombre}</h3>

						<p>${b.descripcion}</p>

						<p>${b.precio}€</p>

					</div>

				</c:forEach>

			</div>
		</article>
	</section>

<section id="reservas" class="menu-section">
		<article>
			<h2 class="section-title">Reservar Mesa</h2>

			<form action="ReservaServlet" method="post" class="form-reserva">

				<input type="text" name="nombre" placeholder="Tu nombre" required autocomplete="off">

				<input type="tel" name="telefono" placeholder="Teléfono" required autocomplete="off">

				<input type="date" name="fecha" required> 
				<input type="time" name="hora" required> 
				<input type="number" name="personas" placeholder="Personas" required oninput="if(value<1) value=null">

				<button type="submit" class="btn">Reservar</button>

			</form>
		</article>

	</section>
	<footer id="contacto">

		<div class="footer-content">

			<div class="footer-info">
				<h4>📍 Dirección</h4>
				<p>Calle Falsa 123, Madrid</p>
			</div>

			<div class="footer-info">
				<h4>🕒 Horario</h4>
				<p>Jue - Dom: 19:00 - 02:00</p>
			</div>

			<div class="footer-info">
				<h4>📞 Reservas</h4>
				<p>+34 912 345 678</p>
			</div>

		</div>

		<p class="copyright">© 2026 El Oasis Bar. Todos los derechos
			reservados.</p>

	</footer>

	
</body>
</html>