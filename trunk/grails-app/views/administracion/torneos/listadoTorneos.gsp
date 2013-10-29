<%@ page import="sgt.Torneo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		
	</head>
	<body>
	
	<div id="playerBioInfoCardMain">
			<h1>Listado de Torneos</h1>
			
			<table>
				
					<tr >
						<td width=50%;>
						
						<div id="playerBioHeadShot">
							<p class="IE6pngFix" id="playerBioHeadShotCopy">&copy; ACS</p>
							<img width="180" height="170" alt="${ perfil.nombre } ${ perfil.apellido }" 
							src="${ resource(dir: 'images/perfiles', file: perfil.imagenPerfil) }" />
						</div>
						<ul id="playerBioInfoList">			
							<g:if test="${ perfil.fechaNacimiento }">
								<li>
								<span>Edad: </span> ${ perfil.edad } (<g:formatDate date="${ perfil.fechaNacimiento }" format="dd-MM-yyyy"/>)
								</li>
							</g:if>
				
							<g:if test="${ perfil.lugarNacimiento }">
								<li>
								<span>Lugar de Nac: </span> ${ perfil.lugarNacimiento }
							</li>
							</g:if>
				
							<g:if test="${ perfil.residencia }">
								<li>
								<span>Residencia: </span> ${ perfil.residencia } 
							</li>
							</g:if>
						</ul>
						
						
						
						</td>
						<td width=50%>
						
						<ul id="playerBioInfoList">			
							<g:if test="${ perfil.fechaNacimiento }">
								<li>
								<span>Edad: </span> ${ perfil.edad } (<g:formatDate date="${ perfil.fechaNacimiento }" format="dd-MM-yyyy"/>)
								</li>
							</g:if>
				
							<g:if test="${ perfil.lugarNacimiento }">
								<li>
								<span>Lugar de Nac: </span> ${ perfil.lugarNacimiento }
							</li>
							</g:if>
				
							<g:if test="${ perfil.residencia }">
								<li>
								<span>Residencia: </span> ${ perfil.residencia } 
							</li>
							</g:if>
						</ul>
						
						</td>						
					</tr>
					
					<tr>
						<td width=50%>
						
						<ul id="playerBioInfoList">			
							<g:if test="${ perfil.fechaNacimiento }">
								<li>
								<span>Edad: </span> ${ perfil.edad } (<g:formatDate date="${ perfil.fechaNacimiento }" format="dd-MM-yyyy"/>)
								</li>
							</g:if>
				
							<g:if test="${ perfil.lugarNacimiento }">
								<li>
								<span>Lugar de Nac: </span> ${ perfil.lugarNacimiento }
							</li>
							</g:if>
				
							<g:if test="${ perfil.residencia }">
								<li>
								<span>Residencia: </span> ${ perfil.residencia } 
							</li>
							</g:if>
						</ul>
						
						</td>								
						
						<td width=50%>
						
						<ul id="playerBioInfoList">			
							<g:if test="${ perfil.fechaNacimiento }">
								<li>
								<span>Edad: </span> ${ perfil.edad } (<g:formatDate date="${ perfil.fechaNacimiento }" format="dd-MM-yyyy"/>)
								</li>
							</g:if>
				
							<g:if test="${ perfil.lugarNacimiento }">
								<li>
								<span>Lugar de Nac: </span> ${ perfil.lugarNacimiento }
							</li>
							</g:if>
				
							<g:if test="${ perfil.residencia }">
								<li>
								<span>Residencia: </span> ${ perfil.residencia } 
							</li>
							</g:if>
						</ul>
												
						</td>					
						
					</tr>					
					
					<tr>
						<td width=50%>
						
						<ul id="playerBioInfoList">			
							<g:if test="${ perfil.fechaNacimiento }">
								<li>
								<span>Edad: </span> ${ perfil.edad } (<g:formatDate date="${ perfil.fechaNacimiento }" format="dd-MM-yyyy"/>)
								</li>
							</g:if>
				
							<g:if test="${ perfil.lugarNacimiento }">
								<li>
								<span>Lugar de Nac: </span> ${ perfil.lugarNacimiento }
							</li>
							</g:if>
				
							<g:if test="${ perfil.residencia }">
								<li>
								<span>Residencia: </span> ${ perfil.residencia } 
							</li>
							</g:if>
						</ul>
						
						</td>
						<td width=50%>
						
						<ul id="playerBioInfoList">			
							<g:if test="${ perfil.fechaNacimiento }">
								<li>
								<span>Edad: </span> ${ perfil.edad } (<g:formatDate date="${ perfil.fechaNacimiento }" format="dd-MM-yyyy"/>)
								</li>
							</g:if>
				
							<g:if test="${ perfil.lugarNacimiento }">
								<li>
								<span>Lugar de Nac: </span> ${ perfil.lugarNacimiento }
							</li>
							</g:if>
				
							<g:if test="${ perfil.residencia }">
								<li>
								<span>Residencia: </span> ${ perfil.residencia } 
							</li>
							</g:if>
						</ul>
						
						</td>					
					</tr>			
			
			</table>
			</div>
		</body>	
			