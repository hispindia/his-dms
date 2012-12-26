package org.openmrs.module.dms.web.controller.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptName;
import org.openmrs.api.context.Context;
import org.openmrs.module.dms.DmsService;
import org.openmrs.module.dms.model.DmsOpdUnit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/module/dms/addUnit.form")
public class AddUnitController {
	private Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
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
		return "/module/dms/page/addUnit";
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
		
		if (dmsopdunit!= null) {
			dmsopdunit.setUnitActiveDate(new Date());
			dmsopdunit.setUnitDeactiveDate(null);
			dmsService.saveUnit(dmsopdunit);
			return "redirect:/module/dms/addUnit.form";
		} else {
			Integer unitno2 = Integer.parseInt(request.getParameter("unitno"));
			String opdname2 = request.getParameter("selopd").toString();
			String day2 = request.getParameter("selday");
			String starttime2 = request.getParameter("starttime");
			String endtime2 = request.getParameter("endtime");
			
			ConceptName opdconid2 = dmsService.getOpdConcepIdByName(opdname2);
			
			DmsOpdUnit dmsopdunit2 = new DmsOpdUnit();
			
			dmsopdunit2.setUnitNo(unitno2);
			dmsopdunit2.setOpdConceptId(opdconid2.getConcept());
			dmsopdunit2.setOpdWorkingDay(day2);
			dmsopdunit2.setStartTime(starttime2);
			dmsopdunit2.setEndTime(endtime2);
			dmsopdunit2.setUnitActiveDate(new Date());
			//dmsopdunit.setUserId(11);
			dmsService.saveUnit(dmsopdunit2);
			return "/module/dms/page/dmsMain";
		}
	}

}
