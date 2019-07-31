/**
 * Copyright 2017 University of Patras 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License.
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and limitations under the License.
 */

package io.openslice.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ctranoris
 *
 */
@Entity(name = "ValidationJob")
public class ValidationJob {

	/** */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;

	/** */
	@Basic()
	private String jobid = null;
	
	/** */
	@Basic()
	private Date dateCreated;
	
	/** */
	@Basic()
	private int vxfid;
	/** */
	@Basic()
	private Boolean validationStatus;
	/** */
	@Basic()
	private String outputLog;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the jobid
	 */
	public String getJobid() {
		return jobid;
	}
	/**
	 * @param jobid the jobid to set
	 */
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the vxfid
	 */
	public int getVxfid() {
		return vxfid;
	}
	/**
	 * @param vxfid the vxfid to set
	 */
	public void setVxfid(int vxfid) {
		this.vxfid = vxfid;
	}
	/**
	 * @return the validationStatus
	 */
	public Boolean getValidationStatus() {
		return validationStatus;
	}
	/**
	 * @param validationStatus the validationStatus to set
	 */
	public void setValidationStatus(Boolean validationStatus) {
		this.validationStatus = validationStatus;
	}
	/**
	 * @return the outputLog
	 */
	public String getOutputLog() {
		return outputLog;
	}
	/**
	 * @param outputLog the outputLog to set
	 */
	public void setOutputLog(String outputLog) {
		this.outputLog = outputLog;
	}
	

	
	
}
