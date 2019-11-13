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

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author ctranoris
 *
 */
@Entity(name = "DeploymentDescriptor")
@JsonIgnoreProperties(ignoreUnknown=true, value = { "ExperimentFullDetails" })
public class DeploymentDescriptor {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;
	

	@Basic()
	private String uuid = null;

	@Basic()
	private String name = null;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "mentor_id")
	private PortalUser mentor = null;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "infrastructure_for_all_id")
	private Infrastructure infrastructureForAll = null;
	
	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	private String description = null;	

	@Lob
	@Column(name = "FEEDBACK", columnDefinition = "LONGTEXT")
	private String feedback = null;

	@Basic()
	private DeploymentDescriptorStatus status = DeploymentDescriptorStatus.UNDER_REVIEW;			

	@Basic()
	private Date dateCreated;

	@Basic()
	private Date startReqDate;

	@Basic()	
	private Date endReqDate;

	@Basic()	
	private Date startDate;
	@Basic()	
	private Date endDate;

	@Basic()	
	private String instanceId;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "experiment_id")
	private ExperimentMetadata experiment = null;


	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "owner_id")
	private PortalUser owner = null;
	
	@OneToMany(mappedBy ="id", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DeploymentDescriptorVxFPlacement> vxfPlacements = new ArrayList<DeploymentDescriptorVxFPlacement>();

	@Basic()	
	private String operationalStatus;
	
	public String getOperationalStatus() {
		return operationalStatus;
	}

	public void setOperationalStatus(String operationalStatus) {
		this.operationalStatus = operationalStatus;
	}

	@Basic()	
	private String configStatus;
	public String getConfigStatus() {
		return configStatus;
	}

	public void setConfigStatus(String configStatus) {
		this.configStatus = configStatus;
	}

	@Lob
	@Column(name = "LDETAILEDSTATUS", columnDefinition = "LONGTEXT")	
	private String detailedStatus;
	public String getDetailedStatus() {
		return detailedStatus;
	}

	public void setDetailedStatus(String detailedStatus) {
		this.detailedStatus = detailedStatus;
	}

	@Basic()	
	private String constituentVnfrIps;
	
	public String getConstituentVnfrIps() {
		return constituentVnfrIps;
	}

	public void setConstituentVnfrIps(String constituentVnfrIps) {
		this.constituentVnfrIps = constituentVnfrIps;
	}

	public DeploymentDescriptor() {
	}

	public DeploymentDescriptor(String uuid, String name) {
		super();
		this.name = name;
		this.uuid = uuid;
	}

	public List<DeploymentDescriptorVxFPlacement> getVxfPlacements() {
		return vxfPlacements;
	}

	public void setVxfPlacements(List<DeploymentDescriptorVxFPlacement> vxfPlacements) {
		this.vxfPlacements = vxfPlacements;
	}
	

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public PortalUser getOwner() {

		
		
		PortalUser p = owner.getSnippedDetails();
		
		return p;
	}

	public void setOwner(PortalUser owner) {
		this.owner = owner;
	}

	//@JsonIgnore
	public ExperimentMetadata getExperimentFullDetails() {
		return experiment;
	}	
	
	public ExperimentMetadata getExperiment() {
		
		if (experiment!=null) {
			return experiment.getSnippedDetails();
		}
		
		return experiment;
	}

	public void setExperiment(ExperimentMetadata e) {
		this.experiment = e;
	}
	
	public DeploymentDescriptorStatus getStatus() {
		return status;
	}

	public void setStatus(DeploymentDescriptorStatus status) {
		this.status = status;
	}

	public Date getStartReqDate() {
		return startReqDate;
	}

	public void setStartReqDate(Date startReqDate) {
		this.startReqDate = startReqDate;
	}

	public Date getEndReqDate() {
		return endReqDate;
	}

	public void setEndReqDate(Date endReqDate) {
		this.endReqDate = endReqDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public Date getStartDate() {
		return startDate;
	}
	
	
	public void setScheduledStartDate() {
		
	}
	
	public String getScheduledStartDate() {
		if (startDate!=null ) {
			Instant instant= startDate.toInstant();
			Instant ins3 = Instant.from( instant.atOffset(ZoneOffset.UTC).withHour(0).withMinute(0).withSecond(0) );
			return ins3.toString();
		}
		return null;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public void setScheduledEndDate() {
		
	}
	public String getScheduledEndDate() {
		if (endDate!=null ) {
			Instant instant= endDate.toInstant();
			Instant ins3 = Instant.from( instant.atOffset(ZoneOffset.UTC).withHour(23).withMinute(59).withSecond(59) );
			return ins3.toString();			
		}
		return null;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public PortalUser getMentor() {
		return mentor;
	}

	public void setMentor(PortalUser mentor) {
		this.mentor = mentor;
	}

	public Infrastructure getInfrastructureForAll() {
		return infrastructureForAll;
	}

	public void setInfrastructureForAll(Infrastructure infrastructureForAll) {
		this.infrastructureForAll = infrastructureForAll;
	}
	
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
}
