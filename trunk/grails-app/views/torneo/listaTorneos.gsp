<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
</head>
<body>
	<div class="box-968 fl">
		
		<g:render template="/utils/messages" />
	
		<div class="box box-607 fl mt10 ml10 mb10">
			<h3 class="title">
				Calendario ${ year }
				<g:select name="year" from="${2014..2000 }" value="${ year }"
					class="profile-year" id="calendar_year" />
			</h3>
			
			<g:if test="${ !torneoInstanceList }">
			<h1 class="mt20">No existen torneos para el calendario seleccionado</h1>
			</g:if>
			
			<div class="inner-box">
				<g:render template="/torneo/torneoCard" var="torneoInstance"
					collection="${ torneoInstanceList }" />
			</div>
		</div>
	</div>
	<r:require module="torneos" />
</body>
</html>
