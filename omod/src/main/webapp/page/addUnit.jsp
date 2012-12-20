<%--
 *  Copyright 2009 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Billing module.
 *
 *  Billing module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Billing module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Billing module.  If not, see <http://www.gnu.org/licenses/>.
 *
--%>
<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<h2>Add Unit</h2>
<form id="unitAddForm" method="POST">
	<table>
		<tr>
			<td>Unit No</td>
			<td><input type="text" name="unitno"></td>
		</tr>
		<tr></tr>
		<tr>
			<td>Opd Name</td>
			<td><select name="sel"><option value=""><---Select---></option><option value="${abc.name}"></option></select></td>
			<td></td>
			<td>Day</td>
			<td><input type="text" name="day"></td>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td>Start Time</td>
			<td><input type="text" name="starttime"></td>
			<td></td><td></td><td></td><td></td>
			<td>End Time</td>
			<td><input type="text" name="endtime"></td>
		</tr>
		<tr></tr>
		<tr>
			<td><input type="button" name="addopd" value="Add Opd"></td>
		</tr>
		<tr></tr>
		<tr>
			<td><input type="submit" value="Active"></td>
			<td><input type="button" value="Deactive"></td>
			<td><input type="button" value="Reset"></td>
			<td><input type="button" value="Edit"></td>
		</tr>
	</table>
</form>

<%@ include file="/WEB-INF/template/footer.jsp"%>