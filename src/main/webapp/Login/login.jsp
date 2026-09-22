<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Importamos la librería JSTL para poder usar el bucle forEach --%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El Oasis</title>
<link rel="stylesheet" type="text/css" href="../Login/login.css">
</head>
<body>

	<div class="login-container">
        <div class="login-card">
            <div class="logo">🌿 EL OASIS</div>
            <h2>Bienvenido de nuevo</h2>
            <p>Accede a tu cuenta para gestionar tus reservas.</p>

            <form id="loginForm" action="${pageContext.request.contextPath}/Producto/login" method="POST">      

                <div class="input-group">
                    <label for="usuario">Usuario</label>
                    <input name="usuario" type="text" id="usuario" required placeholder="mete tu usuario" autocomplete="off">
                </div>
                
                <div class="input-group">
                    <label for="password">Contraseña</label>
                    <input name="password" type="password" id="password" required placeholder="••••••••">
                </div>

                <div class="form-actions">
                    <label class="remember-me">
                        <input type="checkbox"> Recordarme
                    </label>
                    <a href="#" class="forgot-password">¿Olvidaste tu clave?</a>
                </div>

                <button type="submit" class="btn">INICIAR SESIÓN</button>
            </form>

        </div>
    </div>

    <script src="../Login/login.js"></script>


	
</body>
</html>