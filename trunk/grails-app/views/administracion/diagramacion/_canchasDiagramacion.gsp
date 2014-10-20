<%@ page import="sgt.Cancha" %>

<ul>
<g:each in="${ canchas }" var="cancha">
	<li>
		<a href="#cancha-${ cancha.numero }">
			<g:if test="${ cancha.nombre }">
			${ cancha.numero }-${ cancha.nombre }
			</g:if>
			<g:else>
			Cancha ${ cancha.numero }
			</g:else>
		</a>
	</li>
</g:each>
</ul>