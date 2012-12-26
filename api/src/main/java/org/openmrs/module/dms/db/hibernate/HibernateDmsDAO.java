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