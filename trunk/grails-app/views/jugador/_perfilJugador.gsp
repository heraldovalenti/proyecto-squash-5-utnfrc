<div class="grid_16 mt10 mb10 ml25">
	<div id="playerBioInfoCard">
		<div id="playerBioInfoCardMain">
			
			<h3 class="title-grey">${ perfil.nombre + " " + perfil.apellido}</h3>
			<div id="playerBioHeadShot">
				<p class="IE6pngFix" id="playerBioHeadShotCopy">&copy; ACS</p>
				<img style="width: 140px; height: 200px;" 
				alt="${ perfil.nombre } ${ perfil.apellido }" 
				src="${ perfil.imagenPerfil }" />
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
				
				<g:if test="${ perfil.altura }">
					<li><span>Altura: </span> ${ perfil.altura } cm</li>
				</g:if>
				
				<g:if test="${ perfil.peso }">
					<li>
						<span>Peso: </span> ${ perfil.peso } Kg
					</li>
				</g:if>
				
				<g:if test="${ perfil.brazo }">
					<li>
						<span>Brazo: </span> ${ perfil.brazo }
					</li>
				</g:if>
				
				<g:if test="${ perfil.juegaDesde }">
					<li>
						<span>Juega desde: </span> <g:formatDate date="${ perfil.juegaDesde }" format="dd-MM-yyyy"/>
					</li>
				</g:if>
				
				<g:if test="${ perfil.categoria }">
					<li>
						<span>Categoria: </span>
						${ perfil.categoria } 
						<g:if test="${ perfil.ranking }">
							 - ${ message(code:'none', default: '#') }${ perfil.ranking }
						</g:if>
						<g:else>
							 - ${ message(code:'none', default: '#') }N/A
						</g:else>
					</li>
				</g:if>
			</ul>
		</div>
	</div>
</div>