<%--
 *  Copyright 2013 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of DMS module.
 *
 *  DMS module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  DMS module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with DMS module.  If not, see <http://www.gnu.org/licenses/>.
 *
--%>
<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="../includes/js_css.jsp"%>
<br />
<openmrs:require privilege="Edit DMS Unit" otherwise="/login.htm"
	redirect="/module/dms/viewEditUnitList.form" />
<%@ include file="../page/localHeader.jsp"%>
<h2>Unit List</h2>
<table id="myTable" class="tablesorter" class="thickbox">
	<thead>
		<tr align="center">
			<th>Sl No</th>
			<th>Unit No</th>
			<th>OPD</th>
			<th>OPD Day</th>
			<th>Start Time</th>
			<th>End Time</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dmsopdunitl" items="${dmsopdunitls}" varStatus="index">
			<c:choose>
				<c:when test="${index.count mod 2 == 0}">
					<c:set var="klass" value="odd" />
				</c:when>
				<c:otherwise>
					<c:set var="klass" value="even" />
				</c:otherwise>
			</c:choose>
			<tr class="${klass}">
				<td>${index.count}</td>
				<td>${dmsopdunitl.unitNo}</td>
				<td><a href="editUnit.form?unitId=${dmsopdunitl.id}">${dmsopdunitl.opdConceptId.names}</a>
				</td>
				<td>${dmsopdunitl.opdWorkingDay}</td>
				<td>${dmsopdunitl.startTime}</td>
				<td>${dmsopdunitl.endTime}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="/WEB-INF/template/footer.jsp"%>