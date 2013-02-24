<%--
 *  Copyright 2012 Society for Health Information Systems Programmes, India (HISP India)
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
<div
	style="border-bottom: 1px solid black; padding-bottom: 5px; margin-bottom: 10px;">
	<ul id="menu">
		<li class="first"><span
			style="font-weight: bold; font-size: large;">Department
				Management System</span></li>
		<openmrs:hasPrivilege privilege="Manage DMS Activate Unit">
			<li id="ActivateId"><a href="activateUnit.form">Activate
					Unit </a></li>
		</openmrs:hasPrivilege>
		<openmrs:hasPrivilege privilege="Manage DMS DeActivate Unit">
			<li id="DeActivateId"><a href="deActivateUnit.form">DeActivate
					Unit</a></li>
		</openmrs:hasPrivilege>
		<openmrs:hasPrivilege privilege="Manage DMS DeActivated Unit List">
			<li id="DeActivatedListId"><a href="deActivatedUnitList.form">DeActivated
					Unit List</a></li>
		</openmrs:hasPrivilege>
		<openmrs:hasPrivilege privilege="Edit DMS Unit">
			<li id="EditId"><a href="viewEditUnitList.form">Edit Unit </a></li>
		</openmrs:hasPrivilege>
		<openmrs:hasPrivilege privilege="Delete DMS Unit">
			<li id="DeleteId"><a href="deleteUnit.form">Delete Unit </a></li>
		</openmrs:hasPrivilege>
	</ul>
</div>

<script type="text/javascript">
	
	// activate the <li> with @id by adding the css class named "active"
	function activate(id){
		$("#" + id).addClass("active");		
	}
	
	// return true whether the @str contains @searchText, otherwise return false
	function contain(str, searchText){
		return str.indexOf(searchText)>-1;
	}
	
	// choose which <li> will be activated using @url
	var url = location.href;
	if(contain(url, "activateUnit.form")){
		activate("ActivateId");
	} else if(contain(url, "deActivateUnit.form")){
		activate("DeActivateId");
	} else if(contain(url, "deActivatedUnitList.form")){
		activate("DeActivatedListId");
	} else if(contain(url, "viewEditUnitList.form")){
		activate("EditId");
	} else if(contain(url, "deleteUnit.form")){
		activate("DeleteId");
	} 
	
	// get the context path
	function getContextPath() {
		pn = location.pathname;
		len = pn.indexOf("/", 1);
		cp = pn.substring(0, len);
		return cp;
	}
</script>