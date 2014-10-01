<%@ page import="sgt.Club"%>

<div style="margin: 10px; padding: 10px; background-color: #FFFFFF; width: 770px; position: relative; float: left;">
	<h3 class="title">${ club.nombre }</h3>
	<div style="width: 170px; position: relative; float: left;">
		<div class="fieldcontain">
			<div class="vista-previa" 
				style="background-image: url(<g:resource dir="${ imagesDir }" file="${ imageSource }"/>);">
			</div>
		</div>
	</div>
	<div style="width: 600px; position: relative; float: left;">
		<ol class="property-list club">
			
			<g:if test="${ club.sitioWeb }">
			<li class="fieldcontain">
				<span class="property-label">Web</span>
				<span class="property-value">${ club.sitioWeb }</span>
			</li>
			</g:if>
			
			<g:if test="${ club.correo }">
			<li class="fieldcontain">
				<span class="property-label">Correo electronico</span>
				<span class="property-value">${ club.correo }</span>
			</li>
			</g:if>
			
			<g:if test="${ club.telefono }">
			<li class="fieldcontain">
				<span class="property-label">Telefono</span>
				<span class="property-value">${ club.telefono }</span>
			</li>
			</g:if>
			
			<g:if test="${ club.domicilio }">
			<li class="fieldcontain">
				<span class="property-label">Domicilio</span>
				<span class="property-value">
					${ club.domicilio.calle }
					${ club.domicilio.numero },
					
					<g:if test="${ club.domicilio.piso || club.domicilio.departamento }">
					<g:if test="${ club.domicilio.piso  }">
						${ club.domicilio.piso  }
					</g:if>
					<g:if test="${ club.domicilio.departamento }">
						${ club.domicilio.departamento }
					</g:if>
					,
					</g:if>
					
					${ club.domicilio.ciudad }
					<g:if test="${ club.domicilio.codigoPostal > 0 }">
					(${ club.domicilio.codigoPostal }),
					</g:if>
					<g:else>,</g:else>
					${ club.domicilio.provincia }
				</span>
			</li>
			</g:if>
			
			<g:if test="${ club.canchas && club.canchas.size() > 0 }">
			<li class="fieldcontain">
				<span class="property-label">Cantidad de canchas</span>
				<span class="property-value">
					${ club.canchas.size() }
				</span>
			</li>
			</g:if>
			
			<g:if test="${ club.servicios && club.servicios.size() > 0 }">
			<li class="fieldcontain">
				<span class="property-label">Servicios</span>
				<span class="property-value">
				<g:each in="${ club.servicios }" var="servicio" status="i">
					${ servicio }
					<g:if test="${ i < club.servicios.size() - 1 }">- </g:if>
				</g:each>
				</span>
			</li>
			</g:if>
			
		</ol>
	</div>
</div>
