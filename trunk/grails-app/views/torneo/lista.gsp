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
					torneos
					
				</h3>
				<div class="inner-box">
					<g:each in="${ torneos }" var="torneo" >
						<g:render template="torneoCard" model="[torneoInstance: torneo]" />
					</g:each>
				</div>
			</div>
		</div>
	</div>
	<div class="pagination" style="height: 50px; background: #FFFFFF">
		<g:paginate total="${torneosTotal}" action="listaPaginada" max="5"/>
	</div>
</body>
</html>
