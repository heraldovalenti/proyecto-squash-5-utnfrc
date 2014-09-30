<g:if test="${ flash.message }">
<div class="message">
	${ flash.message }
</div>
</g:if>
<g:if test="${ flash.errors }">
	<ul class="errors">
		<g:each in="${ flash.errors }" var="error">
			<li><g:message error="${error}"/></li>
		</g:each>
	</ul>
</g:if>
<g:if test="${ flash.exception }">
	<ul class="errors">
		<li>${ flash.exception.message }</li>
	</ul>
</g:if>