/**
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
 **/

package org.openmrs.module.dms;

import java.util.List;

import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptName;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.hospitalcore.model.DmsOpdUnit;
import org.springframework.transaction.annotation.Transactional;

/**
 * This service exposes module's core functionality. It is a Spring managed bean
 * which is configured in moduleApplicationContext.xml.
 * <p>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(DmsService.class).someMethod();
 * </code>
 * 
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface DmsService extends OpenmrsService {

	/*
	 * Add service methods here
	 */
	public ConceptName getOpdWardConceptId() throws APIException;

	public List<ConceptAnswer> getAllOpdList(Concept conid) throws APIException;

	public ConceptName getOpdConcepIdByName(String opdname) throws APIException;
	
	public DmsOpdUnit getDmsOpd(Integer unitid) throws APIException;
	
	public DmsOpdUnit getDmsOpd(Integer unitno,Concept opdconid,String day,String starttime,String endtime) throws APIException;
	
	public List<DmsOpdUnit> getDmsOpdList() throws APIException;
	
	public List<DmsOpdUnit> getDmsOpdActivatedList() throws APIException;
	
	public List<DmsOpdUnit> getDmsOpdDeActivatedList() throws APIException;

	public DmsOpdUnit saveOrUpdateUnit(DmsOpdUnit dounit) throws APIException;
	
	public void deleteDmsOpdUnit(DmsOpdUnit dounit) throws APIException;
}