<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Producto" %>
<%@ page import= "shared.Constants" %>
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
		List<Producto> productos = (List<Producto>) request.getAttribute("productos");
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
			<% if (productos != null && !productos.isEmpty()) { %>
				<% for(Producto producto: productos) { %>
					<a class="flex bg-gray-200 w-[200px] justify-center flex-col p-4 gap-1 items-center rounded-md border border-gray-300 border-solid hover:border-green-600 cursor-pointer">
						<img class="rounded-sm" src="<%= producto.getImagenUrl() != null ? producto.getImagenUrl()  : Constants.IMAGEN_PRODUCTO_DEFAULT %>" width="150px">
						<span class="w-full justify-between items-end flex">
							<span class="text-xs text-left text-center text-green-600 font-medium"><%= producto.getCodigoInterno() %></span>
							<span class="text-center font-bold text-blue-600 text-right text-xl">S/. <%= producto.getPrecio() %></span>
						</span>
						
						<span class="text-center font-bold text-gray-600 text-xs"><%= producto.getNombre() %></span>
						<span class="w-full text-red-500 text-left text-xs"><%= producto.getStock() %> unidades</span>
						
						<button class="bg-orange-600 w-full text-white font-medium hover:bg-orange-700 p-1 rounded cursor-pointer" 
							onclick="agregarCarrito(<%= producto.getIdProducto()  %>)">+ Agregar Carrito</button>
						
					</a>
				<% 	} %>
			<%	} else { %>
				<p>No se encontraron registros</p>
			<% } %>
		</div>
			
		
	</main>
	
	
</body>

<script>
	
	async function agregarCarrito(idProducto){
		console.log('agregarCarrito', idProducto);
	
		fetch('/galactus-store/carrito?idProducto='+idProducto, {
			method: 'POST'
		});
	}

</script>

</html>