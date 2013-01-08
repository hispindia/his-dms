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

package org.openmrs.module.dms.db;

import java.util.List;

import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptName;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.dms.DmsService;
import org.openmrs.module.hospitalcore.model.DmsOpdUnit;

/**
 * Database methods for {@link DmsService}.
 */
public interface DmsDAO {

	/*
	 * Add DAO methods here
	 */
	public ConceptName getOpdWardConceptId() throws DAOException;

	public List<ConceptAnswer> getAllOpdList(Concept conid) throws DAOException;

	public ConceptName getOpdConcepIdByName(String opdname) throws DAOException;
	
	public DmsOpdUnit getDmsOpd(Integer unitid) throws DAOException;
	
	public DmsOpdUnit getDmsOpd(Integer unitno,Concept opdconid,String day,String starttime,String endtime) throws DAOException;
	
	public List<DmsOpdUnit> getDmsOpdList() throws DAOException;
	
	public List<DmsOpdUnit> getDmsOpdActivatedList() throws DAOException;
	
	public List<DmsOpdUnit> getDmsOpdDeActivatedList() throws DAOException;

	public DmsOpdUnit saveOrUpdateUnit(DmsOpdUnit dounit) throws DAOException;
	
	public void deleteDmsOpdUnit(DmsOpdUnit dounit) throws DAOException;
}