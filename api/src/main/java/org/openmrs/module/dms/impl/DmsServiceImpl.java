/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.dms.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptName;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.dms.DmsService;
import org.openmrs.module.dms.db.DmsDAO;
import org.openmrs.module.dms.model.DmsOpdUnit;

/**
 * It is a default implementation of {@link DmsService}.
 */
public class DmsServiceImpl extends BaseOpenmrsService implements DmsService {

	protected final Log log = LogFactory.getLog(this.getClass());

	private DmsDAO dao;

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(DmsDAO dao) {
		this.dao = dao;
	}

	/**
	 * @return the dao
	 */
	public DmsDAO getDao() {
		return dao;
	}

	public ConceptName getOpdWardConceptId() throws APIException {
		return dao.getOpdWardConceptId();
	}

	public List<ConceptAnswer> getAllOpdList(Concept conid) throws APIException {
		return dao.getAllOpdList(conid);
	}

	public ConceptName getOpdWardNameByConceptId(Concept con)
			throws APIException {
		return dao.getOpdWardNameByConceptId(con);
	}

	public ConceptName getOpdConcepIdByName(String opdname) throws APIException {
		return dao.getOpdConcepIdByName(opdname);
	}
	
	public DmsOpdUnit getDmsOpd(Integer unitno,Concept opdconid,String day,String starttime,String endtime) throws APIException {
		return dao.getDmsOpd(unitno,opdconid,day,starttime,endtime);
	}

	public DmsOpdUnit saveUnit(DmsOpdUnit dounit) throws APIException {
		return dao.saveUnit(dounit);
	}
}