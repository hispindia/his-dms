<%--
 *  Copyright 2012 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Dms module.
 *
 *  Dms module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Dms module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Dms module.  If not, see <http://www.gnu.org/licenses/>.
 *
--%>
<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<h2>DeActivated Unit List</h2>
<form id="unitDeActivatedListForm" method="POST">
<table id="myTable" class="tablesorter">
	<thead>
		<tr>
			<th>Sl No</th>
			<th>Unit No</th>
			<th>Opd</th>
			<th>Opd Day</th>
			<th>Start Time</th>
			<th>End Time</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="dmsv" items="${dmsopdunitl}" varStatus="index">
			<c:choose>
				<c:when test="${index.count mod 2 == 0}">
					<c:set var="klass" value="odd"/>
				</c:when>					
				<c:otherwise>
					<c:set var="klass" value="even"/>
				</c:otherwise>
			</c:choose>
			<tr class="${klass}">
			<td><input type="checkbox" id="showResultsi" name="showResultsn" value="${dmsv.id}"></td>
			<td>${index.count}</td>
			<td>${dmsv.unitNo}</td>
			<td>${dmsv.opdConceptId.names}</td>
			<td>${dmsv.opdWorkingDay}</td>
			<td>${dmsv.startTime}</td>
			<td>${dmsv.endTime}</td>
			</tr>
			</c:forEach>
	</tbody>
	<tr>
			<td><input type="submit" value="Activate"></td>
			<td><input type="button" value="Reset"
				onclick="window.location.href=window.location.href"></td>
		</tr>
</table>
</form>
<%@ include file="/WEB-INF/template/footer.jsp"%>