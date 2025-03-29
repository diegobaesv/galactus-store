<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GALACTUS STORE | SISE</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
</head>
<body>

	<header>
		<div class="flex bg-green-600 h-[50px] items-center justify-between">
			<div class="flex gap-4 justify-center w-full">
				<a href="/galactus-store" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Inicio</a>
				<a href="/galactus-store/categorias" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Categorías</a>
				<a class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Marcas</a>
			</div>
			
			<a class="mr-2 p-1 rounded font-medium bg-green-700 text-white border border-white border-solid" href="/galactus-store/carrito">Carrito</a>
		</div>
	</header>

</body>
</html>