<table id="data" class="calendar">
    <thead>
        <tr>
            <%-- Empty header for the time column --%>
            <th></th>
            <%--<g:each in="${0..<7}">
                --%><th class="day"><%--
                    <g:formatDate format="EEEE" date="${startDate + it}" />
                --%>
                lunes
                </th>
                <th class="day">
                martes
                </th>
                <th class="day">
                miercoles	
                </th>
                <th class="day">
                jueves
                </th>
                <th class="day">
                viernes
                </th>
                <th class="day">
                sabado
                </th>
                <th class="day">
                domingo
                </th><%--             
                
            </g:each>
        --%><tr>
    </thead>
    <tbody>
        <%-- Add row for each hour of the day.  --%>
        <g:each in="${((8* 60 * 60 * 1000) .. (24* 60 * 60 * 1000) - 1).step(60 * 60 * 1000)}">

            <%-- Determine if time is a full hour. This will determine the class of the cells
            in each of the rows. --%>
            <g:set var="isHour" value="${it % (60 * 60 * 1000) == 0}" />

            <tr id="tr">            	
                <td id="td" class="${isHour ? "time-hour" : "time-half-hour"}">
                    <g:if test="${isHour}">
                       <g:formatDate format="HH:mm" date="${new Date(startTime + it )}" />
                    </g:if>
                    <g:else>
                        &nbsp;
                    </g:else>
                </td>

                <g:each in="${0..<7}">
                    <td class="${isHour ? "entry-hour" : "entry-half-hour"}">
                        <%-- Place holder --%>
                    </td>
                </g:each>
            </tr>
        </g:each>
    </tbody>
</table>

