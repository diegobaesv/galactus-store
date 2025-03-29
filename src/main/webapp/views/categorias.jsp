<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Categoria" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GALACTUS STORE | SISE</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
</head>
<body>

	<%
		List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
	%>

	<header>
		<div class="flex bg-green-600 h-[50px] items-center justify-between">
			<div class="flex gap-4 justify-center w-full">
				<a href="/galactus-store" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Inicio</a>
				<a href="/galactus-store/categorias" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer border border-white border-solid">Categorías</a>
				<a class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Marcas</a>
			</div>
			
			<a class="mr-2 bg-white p-1 rounded text-green-700 font-medium hover:bg-green-700 hover:text-white hover:border hover:border-white" href="/galactus-store/carrito">Carrito</a>
		</div>
	</header>
	
	<main class="p-4">
		<div class="flex w-full justify-center p-4 gap-4 flex-wrap">
			<% if (categorias != null && !categorias.isEmpty()) { %>
				<% for(Categoria categoria: categorias) { %>
					<a href="/galactus-store/subcategorias?idCategoria=<%= categoria.getIdCategoria() %>" class="flex bg-gray-200 w-[200px] justify-center flex-col p-4 gap-2 items-center rounded-md border border-gray-300 border-solid hover:border-green-600 cursor-pointer">
						<img class="rounded-sm" src="<%= categoria.getImagenUrl() %>" width="150px">
						<span class="text-center font-bold text-gray-600"><%= categoria.getNombre() %></span>
					</a>
				<% 	} %>
			<%	} else { %>
				<p>No se encontraron registros</p>
			<% } %>
		</div>
		
		<% if (categorias != null && !categorias.isEmpty()) { %>
			<div class="w-full p-4">Total registros: <%= categorias.size() %></div>
		<% } %>
		
		
	</main>
	
	
</body>
</html>