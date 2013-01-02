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
<%@ include file="../includes/js_css.jsp"%>
<br/>
<openmrs:require privilege="Manage DMS Activate Unit" otherwise="/login.htm" redirect="/module/dms/activateUnit.form" />
<%@ include file="../page/localHeader.jsp" %>
<h2>Activate Unit</h2>
<form id="unitActivateForm" method="POST">
	<table>
		<tr>
			<td>Unit No</td>
			<td><input type="text" id="unitno" name="unitno"></td>
		</tr>
		<tr></tr>
		<tr>
			<td>OPD Name</td>
			<td><select id="selopd" name="selopd"><option value=""><-------Select
						OPD-------></option>
					<c:forEach items="${cnamel}" var="cnl">
						<option value="${cnl.name}">${cnl.name}</option>
					</c:forEach>
			</select></td>
			<td></td>

			<td>Day</td>
			<td><select id="selday" name="selday"><option value="">
						<-Select Day-></option>
					<option value="Monday">Monday</option>
					<option value="Tuesday">Tuesday</option>
					<option value="Wednesday">Wednesday</option>
					<option value="Thursday">Thursday</option>
					<option value="Friday">Friday</option>
					<option value="Saturday">Saturday</option>
					<option value="Sunday">Sunday</option>
			</select>
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>Start Time</td>
			<td><input type="text" id="starttime" name="starttime"
				value="0:00:00"></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>End Time</td>
			<td><input type="text" id="endtime" name="endtime"
				value="23:59:59"></td>
			<td><font color="#FF0000">Enter Time in 24 hour
					format(Ex:14:32:56)</font>
			</td>
		</tr>
		<tr></tr>
		<%--
		<tr>
			<td><input type="button" name="addopd" value="Add Opd">
			</td>
		</tr>
		--%>
		<tr></tr>
		<tr>
			<td><input type="submit" value="Activate"></td>
			<td><input type="button" value="Reset"
				onclick="window.location.href=window.location.href"></td>
		</tr>
	</table>
</form>

<%@ include file="/WEB-INF/template/footer.jsp"%>