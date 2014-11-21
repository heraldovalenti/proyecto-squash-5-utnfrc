<g:if test="${ !torneo.detalles.isEmpty() }">
<div class="box box-335 fr mt10 mr5">
	<h3>Draws</h3>
	<div class="mt10 ml10 mr10 mb10">
		<ul id="news-result">
			<g:each in="${ torneo.detalles }" var="detalle">
			<li>
				<g:link controller="torneo" action="verFixture" id="${ torneo.id }" 
				params="[categoria: detalle.id]">
					${ detalle.categoria }
				</g:link>
			</li>
			</g:each>
		</ul>
	</div>
</div>
</g:if>