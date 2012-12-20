package org.openmrs.module.dms.web.controller.main;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
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
public class addUnitController {
private Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(method=RequestMethod.GET)
	public String main(Model model){
		DmsService dmsService = Context.getService(DmsService.class);
		ConceptName con=dmsService.getOpdWardConceptId();
		Concept conid=con.getConcept();
		System.out.println(conid+"rrrrrrrrrrrrrrrr----------");
		//dmsService.getAllOpdList();
		return "/module/dms/page/addUnit";
}

	@RequestMapping(method=RequestMethod.POST)
	public String onSubmit(Model model,HttpServletRequest request){
		//System.out.println("EEEEEEEEEEEEEEEEE");
		DmsService dmsService = Context.getService(DmsService.class);	
		DmsOpdUnit dmsopdunit=new DmsOpdUnit();
		
		/*
		String name=request.getParameter("name");
		Integer age= Integer.parseInt(request.getParameter("age"));
		String postaladdress=request.getParameter("postaladdress");
		Integer phone= Integer.parseInt(request.getParameter("phone"));
		diareg.setName(name);
		diareg.setAge(age);
		diareg.setPostaladdress(postaladdress);
		diareg.setPhone(phone);
		System.out.println("name"+"AAAAAAAAAAAAA");
		System.out.println("age"+"BBBBBBBBBBBBB");
		System.out.println("postaladdress"+"CCCCCCCCCCCC");
		System.out.println("phone"+"DDDDDDDDDDDDDD");
		dialysisService.saveDialysisPatient(diareg);
		*/
		return "/module/dms/page/dmsMain";
	}	
	
}
