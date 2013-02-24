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

import java.util.List;
import org.openmrs.api.context.Context;
import org.openmrs.module.dms.DmsService;
import org.openmrs.module.hospitalcore.model.DmsOpdUnit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("ViewEditUnitListController")
@RequestMapping("/module/dms/viewEditUnitList.form")
public class ViewEditUnitListController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showList(Model model) {
		
		DmsService dmsService = Context.getService(DmsService.class);
		DmsOpdUnit dmsOpdUnit = new DmsOpdUnit();
		List<DmsOpdUnit> dmsopdunits = dmsService.getDmsOpdList();
		model.addAttribute("dmsopdunitls", dmsopdunits);
		return "/module/dms/page/viewEditUnitList";
	}
}
