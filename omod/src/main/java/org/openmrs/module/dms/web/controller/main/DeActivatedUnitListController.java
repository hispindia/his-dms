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

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.dms.DmsService;
import org.openmrs.module.dms.model.DmsOpdUnit;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("DeActivatedUnitListController")
@RequestMapping("/module/dms/deActivatedUnitList.form")
public class DeActivatedUnitListController {
	private Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		DmsService dmsService = Context.getService(DmsService.class);
		List<DmsOpdUnit> dmsopdunit = dmsService.getDmsOpdDeActivatedList();
		model.addAttribute("dmsopdunitl", dmsopdunit);
		return "/module/dms/page/deActivatedUnitList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Model model, HttpServletRequest request) {
		DmsService dmsService = Context.getService(DmsService.class);
		DmsOpdUnit dmsopdunit = new DmsOpdUnit();
		String select[] = request.getParameterValues("showResultsn"); 
		if (select != null && select.length != 0) {
			for (int i = 0; i < select.length; i++) {
				Integer unitid=Integer.parseInt(select[i]);
				dmsopdunit = dmsService.getDmsOpd(unitid);
				dmsopdunit.setUnitActiveDate(new Date());
				dmsopdunit.setUnitDeactiveDate(null);
				dmsService.saveOrUpdateUnit(dmsopdunit);
				}
		}
		
		HttpSession httpSession = request.getSession();
		
		httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,"dms.activate.success");
		return "redirect:/module/dms/deActivatedUnitList.form";
	}
}
