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
	
	public DmsOpdUnit getDmsOpd(Integer unitid) throws APIException {
		return dao.getDmsOpd(unitid);
	}
	
	public DmsOpdUnit getDmsOpd(Integer unitno,Concept opdconid,String day,String starttime,String endtime) throws APIException {
		return dao.getDmsOpd(unitno,opdconid,day,starttime,endtime);
	}
	
	public List<DmsOpdUnit> getDmsOpdList() throws APIException {
		return dao.getDmsOpdList();
	}
	
	public List<DmsOpdUnit> getDmsOpdActivatedList() throws APIException {
		return dao.getDmsOpdActivatedList();
	}
	
	public List<DmsOpdUnit> getDmsOpdDeActivatedList() throws APIException {
		return dao.getDmsOpdDeActivatedList();
	}

	public DmsOpdUnit saveOrUpdateUnit(DmsOpdUnit dounit) throws APIException {
		return dao.saveOrUpdateUnit(dounit);
	}
	
	public void deleteDmsOpdUnit(DmsOpdUnit dounit) throws APIException {
		dao.deleteDmsOpdUnit(dounit);
	}
}