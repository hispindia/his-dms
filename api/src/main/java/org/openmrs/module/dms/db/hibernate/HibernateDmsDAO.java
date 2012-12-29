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

package org.openmrs.module.dms.db.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptName;
import org.openmrs.api.ConceptNameType;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.dms.db.DmsDAO;
import org.openmrs.module.dms.model.DmsOpdUnit;

/**
 * It is a default implementation of {@link DmsDAO}.
 */
public class HibernateDmsDAO implements DmsDAO {
	protected final Log log = LogFactory.getLog(this.getClass());

	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public ConceptName getOpdWardConceptId() throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ConceptName.class);
		criteria.add(Restrictions.like("name", "OPD WARD"));
		criteria.add(Restrictions.like("conceptNameType",
				ConceptNameType.FULLY_SPECIFIED));
		return (ConceptName) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ConceptAnswer> getAllOpdList(Concept conid) throws DAOException {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ConceptAnswer.class);
		criteria.add(Restrictions.eq("concept", conid));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public ConceptName getOpdWardNameByConceptId(Concept con)
			throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ConceptName.class);
		criteria.add(Restrictions.eq("concept", con));
		criteria.add(Restrictions.like("conceptNameType",
				ConceptNameType.FULLY_SPECIFIED));
		return (ConceptName) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public ConceptName getOpdConcepIdByName(String opdname) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ConceptName.class);
		criteria.add(Restrictions.eq("name", opdname));
		criteria.add(Restrictions.like("conceptNameType",
				ConceptNameType.FULLY_SPECIFIED));
		return (ConceptName) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
		public DmsOpdUnit getDmsOpd(Integer unitno,Concept opdconid,String day,String starttime,String endtime) throws DAOException {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
					DmsOpdUnit.class);
			criteria.add(Restrictions.eq("unitNo", unitno));
			criteria.add(Restrictions.eq("opdConceptId", opdconid));
			criteria.add(Restrictions.eq("opdWorkingDay", day));
			criteria.add(Restrictions.eq("startTime", starttime));
			criteria.add(Restrictions.eq("endTime", endtime));
			return (DmsOpdUnit) criteria.uniqueResult();
		}

	public DmsOpdUnit saveUnit(DmsOpdUnit dounit) throws DAOException {
		sessionFactory.getCurrentSession().saveOrUpdate(dounit);
		return dounit;
	}
}