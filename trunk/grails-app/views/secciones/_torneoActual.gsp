<%@ page import="sgt.Torneo"%>

<g:set scope="request" var="idTorneo" value="${ g.torneoActual() }"/>
<g:if test="${ idTorneo != 'null' }">

<div class="live-tour" >
   	<div id="headerLiveScoreBox1" class="headerLiveScoreBox" style="width: 250px; height: 60px;">
		<div class="backgroundFrame"></div>
		<img class="scoreboardLogo" src="<g:logoTorneoActual />" height="55">
		
		<p class="headScorebrdTitle">
			<a href="#"><g:nombreTorneoActual /></a>
		</p>
		<p class="headerScorebrdPlace"><g:fechasTorneoActual /></p>
		<p class="headScorebrdTitle" style="margin-top: 5px;">
			<g:link controller="torneo" action="verTorneo" params="[idTorneo: idTorneo]"
				class="ml10 button_small blue">Informacion del Torneo</g:link>
		</p>
	</div>
</div>
</g:if>