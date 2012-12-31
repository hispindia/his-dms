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
<div
	style="border-bottom: 1px solid black; padding-bottom: 5px; margin-bottom: 10px;">
	<a href="activateUnit.form"><spring:message code="dms.activateunit" />
	</a> &nbsp; | &nbsp; <a href="deActivateUnit.form"><spring:message
			code="dms.deactivateunit" /> </a> &nbsp; | &nbsp; <a
		href="deActivatedUnitList.form"><spring:message
			code="dms.deactivatedunitlist" /> </a> &nbsp; | &nbsp; <a
		href="editUnit.form"><spring:message code="dms.editunit" /> </a>
	&nbsp; | &nbsp; <a href="deleteUnit.form"><spring:message
			code="dms.deleteunit" /> </a>
</div>
<%@ include file="/WEB-INF/template/footer.jsp"%>