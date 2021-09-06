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
import javax.persistence.ConstraintMode;
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
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "obddescriptor_uuid")
	private ExperimentOnBoardDescriptor obddescriptor_uuid = null;
	
	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	private String description = null;	

	@Lob
	@Column(name = "FEEDBACK", columnDefinition = "LONGTEXT")
	private String feedback = null;

	@Lob
	@Column(name = "INSTANTIATIONCONFIG", columnDefinition = "LONGTEXT")
	private String instantiationconfig = null;

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
	
	@Basic()	
	private String nsLcmOpOccId;

	public String getNsLcmOpOccId() {
		return nsLcmOpOccId;
	}

	public void setNsLcmOpOccId(String nsLcmOpOccId) {
		this.nsLcmOpOccId = nsLcmOpOccId;
	}

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "experiment_id")
	private ExperimentMetadata experiment = null;

//	USE THE FOLLOWING DISABLE FOREIGN KEY RESTRICTION
//	@ManyToOne(optional=true)
//	@JoinColumn(name="experiment_id", foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))	
//	private ExperimentMetadata experiment = null;


	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "owner_id")
	private PortalUser owner = null;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH  }, orphanRemoval = true)
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


	@Lob
	@Column(name = "LCONSITVNFRIPS", columnDefinition = "LONGTEXT")	
	private String constituentVnfrIps;

	@Lob
	@Column(name = "LNSR", columnDefinition = "LONGTEXT")
	private String nsr;
	
	@Lob
	@Column(name = "LNSLCM_DETAILS", columnDefinition = "LONGTEXT")
	private String ns_nslcm_details;
		
	public String getNs_nslcm_details() {
		return ns_nslcm_details;
	}

	public void setNs_nslcm_details(String ns_nslcm_details) {
		this.ns_nslcm_details = ns_nslcm_details;
	}

	public String getNsr() {
		return nsr;
	}

	public void setNsr(String nsr) {
		this.nsr = nsr;
	}

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
		if ( owner!=null ) {
			PortalUser p = owner.getSnippedDetails();			
			return p;			
		}
		
		return null;
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
	
	public ExperimentOnBoardDescriptor getObddescriptor_uuid() {
		return obddescriptor_uuid;
	}

	public void setObddescriptor_uuid(ExperimentOnBoardDescriptor obddescriptor_uuid) {
		this.obddescriptor_uuid = obddescriptor_uuid;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
	public String getInstantiationconfig() {
		return instantiationconfig;
	}

	public void setInstantiationconfig(String instantiationconfig) {
		this.instantiationconfig = instantiationconfig;
	}

	public String toJSON()
	{
		String jsonInString=null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return jsonInString;
	}
	
}
