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

package org.openmrs.module.dms.model;

import java.util.Date;
import org.openmrs.Concept;
import org.openmrs.User;

public class DmsOpdUnit {
	private Integer id;
	private String unitName;
	private Concept opdConceptId;
	private String startTime;
	private String endTime;
	private String opdWorkingDay;
	private Date unitActiveDate;
	private Date unitDeactiveDate;
	private User userId;

	// setter and getter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Concept getOpdConceptId() {
		return opdConceptId;
	}

	public void setOpdConceptId(Concept opdConceptId) {
		this.opdConceptId = opdConceptId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOpdWorkingDay() {
		return opdWorkingDay;
	}

	public void setOpdWorkingDay(String opdWorkingDay) {
		this.opdWorkingDay = opdWorkingDay;
	}

	public Date getUnitActiveDate() {
		return unitActiveDate;
	}

	public void setUnitActiveDate(Date unitActiveDate) {
		this.unitActiveDate = unitActiveDate;
	}

	public Date getUnitDeactiveDate() {
		return unitDeactiveDate;
	}

	public void setUnitDeactiveDate(Date unitDeactiveDate) {
		this.unitDeactiveDate = unitDeactiveDate;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

}
