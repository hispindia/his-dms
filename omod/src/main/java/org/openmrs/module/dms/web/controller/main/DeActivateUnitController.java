package org.openmrs.module.dms.web.controller.main;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ConceptName;
import org.openmrs.api.context.Context;
import org.openmrs.module.dms.DmsService;
import org.openmrs.module.dms.model.DmsOpdUnit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/module/dms/deActivateUnit.form")
public class DeActivateUnitController {
	private Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String onSubmit(
			@RequestParam(value = "unitno", required = false) Integer dunitno,
			@RequestParam(value = "selopd", required = false) String dselopd,
			@RequestParam(value = "selday", required = false) String dselday,
			@RequestParam(value = "starttime", required = false) String dstarttime,
			@RequestParam(value = "endtime", required = false) String dendtime,
			Model model, HttpServletRequest request) {
		DmsService dmsService = Context.getService(DmsService.class);
		DmsOpdUnit dmsopdunit = new DmsOpdUnit();
		
		ConceptName opdconid = dmsService.getOpdConcepIdByName(dselopd);
		dmsopdunit=dmsService.getDmsOpd(dunitno, opdconid.getConcept(), dselday, dstarttime, dendtime);
		if(dmsopdunit.getId()!=null){
		dmsopdunit.setUnitActiveDate(null);
		dmsopdunit.setUnitDeactiveDate(new Date());
		dmsService.saveUnit(dmsopdunit);
		return "redirect:/module/dms/addUnit.form";
	}
		else{
			return "/module/dms/page/dmsMain";
			}
		}
}
