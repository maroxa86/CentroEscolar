<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="es">
	
	<head>
		
		<meta charset="utf-8" />
		
		<title>Centro Escolar</title>
		
		<link rel="stylesheet" type="text/css" media="all" href="resources/css/estilos.css"/>
		<link rel="stylesheet" type="text/css" media="all" href="resources/css/alumno/altaAlumno.css"/>
		<script type="text/javascript" src="resources/js/web.js"></script>
		<script type="text/javascript" src="resources/js/alumno/altaAlumno.js"></script>
		
	</head>
	
	<body>

		<div class="wrapper">

			<div class="contenedor">
				
				<div class="contenido">
					
					<h1 class="titulo">Centro Escolar</h1>
					
					<div class="principal">
					
						<h2 class="seccion">Alta Alumno</h2>
							
						<fieldset>
							
							<form action="insertarAlumno.jsp" method='post' id="formAltaAlum" onsubmit="return enviarFormulario()">
								
								<div>
								
									<label for="identificador">Identificador:</label>
									<input type="text" id="identificador" name="identificador"/>
								
								</div>
							
								<div>
								
									<label for="nombre">Nombre:</label>
									<input type="text" id="nombre" name="nombre" />
								
								</div>
								
								<div>
								
									<label for="primerApellido">Primer Apellido:</label>
									<input type="text" id="primerApellido" name="primerApellido" />
								
								</div>
								
								<div>
								
									<label for="segundoApellido">Segundo Apellido:</label>
									<input type="text" id="segundoApellido" name="segundoApellido" />
								
								</div>
								
								<div>
								
									<label for="curso">Curso:</label>
									<input type="text" id="curso" name="curso" />
								
								</div>
								
								<div id="botones">
								
									<input type="button" id="borrar" value="Borrar" onclick="borrarFormulario()"/>
									<input type="submit" id="altaAlum" value="Alta Alumno">
	
								</div>
								
							</form>
							
						</fieldset>
						
					</div>
					
				</div>
				
				<div class="pie">
					
					<footer>
						
						<p>
							<a href="#" onmouseover="desarrollador(event)">Datos del desarrollador</a>
							
						</p>
						
					</footer>
					
				</div>
			
			</div>

		</div>
		
		<div id="desarrollador" onmouseout="this.style.display='none'"  onclick="this.style.display='none'"  onmouseover="this.style.display='block'"> 
			
			<p>
				Nombre: Xavier Roig Martin
				<br />
				Email: maroxa86@gmail.com
			</p>
					
			<a href="http://www.linkedin.com/pub/xavier-roig-martin/49/552/a7" class="linkedin" target="_blank">Linkedin</a>
			<a href="https://twitter.com/maroxa86" class="twitter" target="_blank">Twitter</a>
			<a href="https://github.com/maroxa86" class="github" target="_blank">Github</a>
		</div>
	
	</body>
	
</html>