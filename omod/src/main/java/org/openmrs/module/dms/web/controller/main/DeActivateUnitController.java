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
import org.openmrs.module.dms.model.DmsOpdUnit;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("DeActivateUnitController")
@RequestMapping("/module/dms/deActivateUnit.form")
public class DeActivateUnitController {
	private Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		DmsService dmsService = Context.getService(DmsService.class);
		ConceptName owconid = dmsService.getOpdWardConceptId();
		Concept conid = owconid.getConcept();
		List<ConceptAnswer> lconans = dmsService.getAllOpdList(conid);
		List<ConceptName> lcname = new ArrayList<ConceptName>();
		for (ConceptAnswer conans : lconans) {
			Concept con = conans.getAnswerConcept();
			ConceptName conname = dmsService.getOpdWardNameByConceptId(con);
			lcname.add(conname);
		}
		model.addAttribute("cnamel", lcname);
		return "/module/dms/page/deActivateUnit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Model model, HttpServletRequest request) {
		DmsService dmsService = Context.getService(DmsService.class);
		DmsOpdUnit dmsopdunit = new DmsOpdUnit();
		
		Integer unitno = Integer.parseInt(request.getParameter("unitno"));
		String opdname = request.getParameter("selopd").toString();
		String day = request.getParameter("selday");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		
		ConceptName opdconid = dmsService.getOpdConcepIdByName(opdname);
		
		dmsopdunit = dmsService.getDmsOpd(unitno, opdconid.getConcept(),
				day, starttime, endtime);
		
		HttpSession httpSession = request.getSession();

		if (dmsopdunit!= null) {
			if(dmsopdunit.getUnitDeactiveDate()==null){
			dmsopdunit.setUnitActiveDate(null);
			dmsopdunit.setUnitDeactiveDate(new Date());
			dmsService.saveUnit(dmsopdunit);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,"dms.deactivate.success");
			}
			else{
				httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,"dms.deactivate.failure");
			}
			return "redirect:/module/dms/main.form";
		} else {
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,"dms.deactivateunitnotfound.failure");
			return "redirect:/module/dms/deActivateUnit.form";
		}
	}
}
