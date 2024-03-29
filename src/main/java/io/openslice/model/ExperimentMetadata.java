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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author ctranoris
 *
 */
@Entity(name = "ExperimentMetadata")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperimentMetadata extends Product{


	/**
	 * 
	 */
	private boolean valid;


	/**
	 * 
	 */
	@Basic()
	private ValidationStatus validationStatus = ValidationStatus.NOT_STARTED;
	
	/**
	 * 
	 */
	private PackagingFormat packagingFormat = PackagingFormat.OSMvEIGHT;
	
	/**
	 * @return
	 */
	public PackagingFormat getPackagingFormat() {
		return packagingFormat;
	}

	/**
	 * @param packagingFormat
	 */
	public void setPackagingFormat(PackagingFormat packagingFormat) {
		this.packagingFormat = packagingFormat;
	}

	
	/**
	 * 
	 */
	@OneToMany( mappedBy ="experiment", cascade = {  CascadeType.ALL  } , orphanRemoval = true)	
	private Set<ExperimentOnBoardDescriptor> experimentOnBoardDescriptors = new HashSet<ExperimentOnBoardDescriptor>();
	
	/**
	 *	USE THE FOLLOWING TO DISABLE FOREIGN KEY RESTRICTION ALONG WITH THE RELATED CAHNGE TO DeploymentDescriptor CLASS
	 */
	//	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	//	@JoinColumn(name = "experiment", foreignKey = @jakarta.persistence.ForeignKey(name = "none"))	
	//	private Set<DeploymentDescriptor> DeploymentDescriptors = new HashSet<DeploymentDescriptor>();
	//
	//	public Set<DeploymentDescriptor> getDeploymentDescriptors() {
	//		return DeploymentDescriptors;
	//	}
	//
	//	public void setDeploymentDescriptors(Set<DeploymentDescriptor> deploymentDescriptors) {
	//		DeploymentDescriptors = deploymentDescriptors;
	//	}

	
	/**
	 * 
	 */
	@OneToMany( cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinTable()
	private List<ConstituentVxF> constituentVxF = new ArrayList<ConstituentVxF>();
	
	
	
	/**
	 * @return
	 */
	public List<ConstituentVxF> getConstituentVxF() {
		return constituentVxF;
	}

	/**
	 * @param constituentVxF
	 */
	public void setConstituentVxF(List<ConstituentVxF> constituentVxF) {
		this.constituentVxF = constituentVxF;
	}

	/**
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return
	 */
	public Set<ExperimentOnBoardDescriptor> getExperimentOnBoardDescriptors() {
		return experimentOnBoardDescriptors;
	}

	/**
	 * @param e
	 */
	public void setExperimentOnBoardDescriptors(Set<ExperimentOnBoardDescriptor> e) {
		this.experimentOnBoardDescriptors = e;
	}	
	
	/**
	 * @return
	 */
	public ValidationStatus getValidationStatus() {
		return validationStatus;
	}

	/**
	 * @param validationStatus
	 */
	public void setValidationStatus(ValidationStatus validationStatus) {
		this.validationStatus = validationStatus;
	}

	@JsonIgnore
	public ExperimentMetadata getSnippedDetails() {
		@JsonIgnoreProperties(value = { "iconsrc", "owner", "dateUpdated", "packageLocation", "longDescription", "version", 
				"experimentOnBoardDescriptors", "termsOfUse", "dateCreated", "shortDescription", "descriptor", "packagingFormat", 
				"valid", "categories", "screenshots", "vendor", "published", "extensions", "validationJobs", "descriptorHTML", "validationStatus"} )
		class SnipExperimentMetadata extends ExperimentMetadata{			
		}		
		
		SnipExperimentMetadata p = new SnipExperimentMetadata();
		p.setId( this.getId() );
		p.setName( this.getName() );
		p.setConstituentVxF( this.getConstituentVxF() );
		p.setUuid( this.getUuid() );
		
		return p;
	}	
	
}
