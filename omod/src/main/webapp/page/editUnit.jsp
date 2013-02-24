<%--
 *  Copyright 2013 Society for Health Information Systems Programmes, India (HISP India)
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
<script type="text/javascript">
function validate(){
if (StringUtils.isBlank(jQuery("#unitno").val())) {
				alert("Please enter unit no");
				return false;
			}
else{
if (!StringUtils.isDigit(jQuery("#unitno").val())) {
					alert("Please enter unit no in correct format(Ex:1)");
					return false;
				}
}			
if (StringUtils.isBlank(jQuery("#selopd").val())) {
				alert("Please select opd");
				return false;
			}
if (StringUtils.isBlank(jQuery("#selday").val())) {
				alert("Please select day");
				return false;
			}
if (StringUtils.isBlank(jQuery("#starttime").val())) {
				alert("Please enter start time");
				return false;
			}	
else{
value = jQuery("#starttime").val();
//var regex = /^(\d{1,2}):(\d{2}):(\d{2})?$/;
var regex = /^(\d{2}):(\d{2}):(\d{2})?$/;
var timArr = value.match(regex);
 
 if (timArr == null) {
 alert("Start Time is not in valid format.");
 return false;
 }
hour = timArr[1];
minute = timArr[2];
second = timArr[3];

if (hour < 0  || hour > 23) {
alert("Hour of Start Time must be between 0 and 23");
return false;
}
if (minute<0 || minute > 59) {
alert ("Minute of Start Time must be between 0 and 59");
return false;
}
if (second<0 || second > 59) {
alert ("Second of Start Time must be between 0 and 59");
return false;
}

}				
if (StringUtils.isBlank(jQuery("#endtime").val())) {
				alert("Please enter end time");
				return false;
			}
else{
value = jQuery("#endtime").val();
//var regex = /^(\d{1,2}):(\d{2}):(\d{2})?$/;
var regex = /^(\d{2}):(\d{2}):(\d{2})?$/;
var timArr = value.match(regex);
 
 if (timArr == null) {
 alert("End Time is not in valid format.");
 return false;
 }
hour = timArr[1];
minute = timArr[2];
second = timArr[3];

if (hour < 0  || hour > 23) {
alert("Hour of End Time must be between 0 and 23");
return false;
}
if (minute<0 || minute > 59) {
alert ("Minute of End Time must be between 0 and 59");
return false;
}
if (second<0 || second > 59) {
alert ("Second of End Time must be between 0 and 59");
return false;
}

}																	
return true;
}
</script>
<br />
<%@ include file="../page/localHeader.jsp"%>
<h2>Edit Unit</h2>
<form id="editUnitForm" action="editUnit.form?unitId=${dmsOpdUnit.id}"
	method="POST" onsubmit="javascript:return validate();">
	<table>
		<tr>
			<td>Unit No</td>
			<td><input type="text" id="unitno" name="unitno"
				value="${dmsOpdUnit.unitNo}">
			</td>
		</tr>
		<tr></tr>
		<tr>
			<td>OPD Name</td>
			<td><select id="selopd" name="selopd"><option value=""><---------------Select
						OPD---------------></option>
					<c:forEach items="${cnamel}" var="cnl">
						<option value="${cnl.name}">${cnl.name}</option>
					</c:forEach>
			</select>
			</td>
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
			</select></td>
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
				value="${dmsOpdUnit.startTime}">
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>End Time</td>
			<td><input type="text" id="endtime" name="endtime"
				value="${dmsOpdUnit.endTime}">
			</td>
			<td><font color="#FF0000">Enter Time in 24 hour
					format(Ex:09:32:56)</font></td>
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
			<td><input type="submit" value="Activate">
			</td>
			<td><input type="button" value="Reset"
				onclick="window.location.href=window.location.href">
			</td>
		</tr>
	</table>
</form>

<%@ include file="/WEB-INF/template/footer.jsp"%>