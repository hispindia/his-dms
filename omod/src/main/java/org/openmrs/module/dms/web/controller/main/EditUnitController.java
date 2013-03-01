/**
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
 **/

package org.openmrs.module.dms.web.controller.main;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptName;
import org.openmrs.api.context.Context;
import org.openmrs.module.dms.DmsService;
import org.openmrs.module.hospitalcore.DmsCommonService;
import org.openmrs.module.hospitalcore.model.DmsOpdUnit;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("EditUnitController")
@RequestMapping("/module/dms/editUnit.form")
public class EditUnitController {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(@RequestParam(value = "unitId", required = false) Integer unitId, Model model) {
		DmsCommonService dmsCommonService = Context.getService(DmsCommonService.class);
		DmsService dmsService = Context.getService(DmsService.class);
		DmsOpdUnit dmsOpdUnit = new DmsOpdUnit();
		ConceptName owconid = dmsService.getOpdWardConceptId();
		Concept conid = owconid.getConcept();
		List<ConceptAnswer> lconans = dmsService.getAllOpdList(conid);
		List<ConceptName> lcname = new ArrayList<ConceptName>();
		for (ConceptAnswer conans : lconans) {
			Concept con = conans.getAnswerConcept();
			ConceptName conname = dmsCommonService.getOpdWardNameByConceptId(con);
			lcname.add(conname);
		}
		model.addAttribute("cnamel", lcname);
		dmsOpdUnit = dmsService.getDmsOpd(unitId);
		String starttime = dmsOpdUnit.getStartTime();
		String endtime = dmsOpdUnit.getEndTime();
		String starttimep1 = starttime.substring(0, 2);
		String starttimep2 = starttime.substring(2, 4);
		String endtimep1 = endtime.substring(0, 2);
		String endtimep2 = endtime.substring(2, 4);
		if (starttimep1.equals("0:")) {
			starttime = "0" + starttimep1 + starttimep2;
			dmsOpdUnit.setStartTime(starttime);
		} else {
			starttime = starttime.substring(0, 5);
			dmsOpdUnit.setStartTime(starttime);
		}
		if (endtimep1.equals("0:")) {
			endtime = "0" + endtimep1 + endtimep2;
			dmsOpdUnit.setEndTime(endtime);
		} else {
			endtime = endtime.substring(0, 5);
			dmsOpdUnit.setEndTime(endtime);
		}
		
		model.addAttribute("dmsOpdUnit", dmsOpdUnit);
		return "/module/dms/page/editUnit";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@RequestParam(value = "unitId", required = false) Integer unitId, Model model,
	                       HttpServletRequest request) {
		DmsService dmsService = Context.getService(DmsService.class);
		DmsOpdUnit dmsopdunit = new DmsOpdUnit();
		
		dmsopdunit = dmsService.getDmsOpd(unitId);
		
		//Integer unitno = Integer.parseInt(request.getParameter("unitno"));
		//String opdname = request.getParameter("selopd").toString();
		String day = request.getParameter("selday");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String starttimep1 = starttime.substring(0, 2);
		String starttimep2 = starttime.substring(3, 5);
		String endtimep1 = endtime.substring(0, 2);
		String endtimep2 = endtime.substring(3, 5);
		if (starttimep1.equals("00")) {
			starttime = "0:" + starttimep2 + ":00";
		} else {
			starttime = starttime + ":00";
		}
		if (endtimep1.equals("00")) {
			endtime = "0:" + endtimep2 + ":00";
		} else {
			endtime = endtime + ":00";
		}
		
		HttpSession httpSession = request.getSession();
		
		//ConceptName opdconid = dmsService.getOpdConcepIdByName(opdname);
		
		//dmsopdunit.setUnitNo(unitno);
		//dmsopdunit.setOpdConceptId(opdconid.getConcept());
		dmsopdunit.setOpdWorkingDay(day);
		dmsopdunit.setStartTime(starttime);
		dmsopdunit.setEndTime(endtime);
		dmsService.saveOrUpdateUnit(dmsopdunit);
		httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "dms.edit.success");
		return "redirect:/module/dms/viewEditUnitList.form";
	}
}
