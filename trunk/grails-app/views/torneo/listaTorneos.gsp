<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
</head>
<body>
	<div class="grid_16 mt10 mb10">
		<div class="grid_10">
			<div class="box box-607">
				<h3 class="title">
					Calendario ${ year }
					<g:select name="year" from="${2014..2000 }" value="${ year }"
						class="profile-year" id="calendar_year" />
				</h3>
				<div class="inner-box">
					<g:render template="/torneo/torneoCard" var="torneoInstance"
						collection="${ torneoInstanceList }" />
				</div>
			</div>
		</div>
	</div>
	<r:require module="torneos" />
</body>
</html>
