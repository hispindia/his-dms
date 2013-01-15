/**
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
 **/

package org.openmrs.module.dms.web.controller.main;

import java.util.ArrayList;
import java.util.Date;
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

@Controller("ActivateUnitController")
@RequestMapping("/module/dms/activateUnit.form")
public class ActivateUnitController {
	private Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		DmsCommonService dmsCommonService=Context.getService(DmsCommonService.class);
		DmsService dmsService = Context.getService(DmsService.class);
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
		return "/module/dms/page/activateUnit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Model model, HttpServletRequest request) {
		DmsService dmsService = Context.getService(DmsService.class);
		DmsOpdUnit dmsopdunit = new DmsOpdUnit();
		
		Integer unitno = Integer.parseInt(request.getParameter("unitno"));
		String opdname = request.getParameter("selopd").toString();
		String day = request.getParameter("selday");
		String starttime = request.getParameter("starttime");
		if(starttime.equals("00:00:00")){
			starttime="0:00:00";
		}
		String endtime = request.getParameter("endtime");
		if(endtime.equals("00:00:00")){
			endtime="0:00:00";
		}
		
		ConceptName opdconid = dmsService.getOpdConcepIdByName(opdname);
		
		dmsopdunit = dmsService.getDmsOpd(unitno, opdconid.getConcept(),
				day, starttime, endtime);
		
		HttpSession httpSession = request.getSession();
		
		if (dmsopdunit!= null) {
			if(dmsopdunit.getUnitActiveDate()==null){
			dmsopdunit.setUnitActiveDate(new Date());
			dmsopdunit.setUnitDeactiveDate(null);
			dmsService.saveOrUpdateUnit(dmsopdunit);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,"dms.activate.success");
			}
			else{
				httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,"dms.activate.failure");
			}
			return "redirect:/module/dms/main.form";
		} else {
			Integer unitno2 = Integer.parseInt(request.getParameter("unitno"));
			String opdname2 = request.getParameter("selopd").toString();
			String day2 = request.getParameter("selday");
			String starttime2 = request.getParameter("starttime");
			if(starttime2.equals("00:00:00")){
				starttime2="0:00:00";
			}
			String endtime2 = request.getParameter("endtime");
			if(endtime2.equals("00:00:00")){
				endtime2="0:00:00";
			}
			
			ConceptName opdconid2 = dmsService.getOpdConcepIdByName(opdname2);
			
			DmsOpdUnit dmsopdunit2 = new DmsOpdUnit();
			
			dmsopdunit2.setUnitNo(unitno2);
			dmsopdunit2.setOpdConceptId(opdconid2.getConcept());
			dmsopdunit2.setOpdWorkingDay(day2);
			dmsopdunit2.setStartTime(starttime2);
			dmsopdunit2.setEndTime(endtime2);
			dmsopdunit2.setUnitActiveDate(new Date());
			dmsopdunit2.setCreator(Context.getAuthenticatedUser().getUserId());
			dmsService.saveOrUpdateUnit(dmsopdunit2);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,"dms.activate.success");
			return "redirect:/module/dms/main.form";
		}
	}

}
