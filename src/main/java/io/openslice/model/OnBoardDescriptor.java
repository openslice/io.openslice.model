/*-
 * ========================LICENSE_START=================================
 * io.openslice.model
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */


package io.openslice.model;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ctranoris
 * maintains information and status of a VNF or NSD on which MANO providers is on-boarded
 * see https://github.com/5GinFIRE/eu.5ginfire.portal.api/issues/10 
 */
@Entity(name = "OnBoardDescriptor")
@JsonIgnoreProperties(value = { "vxf" })

public class OnBoardDescriptor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn() })
	private MANOprovider obMANOprovider;

	private  OnBoardingStatus onBoardingStatus = OnBoardingStatus.UNKNOWN;
	
	private Date lastOnboarding;
	
	private String deployId = "(N/A)";
	
	@Lob
	@Column(name = "LDETAILEDSTATUS", columnDefinition = "LONGTEXT")	
	private String feedbackMessage;

	@Basic()
	@Column(unique=true)
	private String uuid = null;

	public OnBoardDescriptor() {		
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MANOprovider getObMANOprovider() {
		return obMANOprovider;
	}

	public void setObMANOprovider(MANOprovider obMANOprovider) {
		this.obMANOprovider = obMANOprovider;
	}

	
	public OnBoardingStatus getOnBoardingStatus() {
		return onBoardingStatus;
	}

	public void setOnBoardingStatus(OnBoardingStatus onBoardingStatus) {
		this.onBoardingStatus = onBoardingStatus;
	}

	public Date getLastOnboarding() {
		return lastOnboarding;
	}

	public void setLastOnboarding(Date lastOnboarding) {
		this.lastOnboarding = lastOnboarding;
	}

	public String getDeployId() {
		return deployId;
	}

	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
		
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the feedbackMessage
	 */
	public String getFeedbackMessage() {
		return feedbackMessage;
	}

	/**
	 * @param feedbackMessage the feedbackMessage to set
	 */
	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}
	
	public String toJSON() {
		String jsonInString = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonInString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonInString;
	}	
}
