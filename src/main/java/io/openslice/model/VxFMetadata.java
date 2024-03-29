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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


/**
 * @author ctranoris
 *
 */
@Entity(name = "VxFMetadata")
public class VxFMetadata extends Product{


	/**
	 * 
	 */
	private boolean certified=false;
	
	/**
	 * 
	 */
	private String certifiedBy;	

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
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(
	        name = "PRODUCT_MANOPLATFORMS", 
	        joinColumns = { @JoinColumn(name = "PROD_ID") }, 
	        inverseJoinColumns = { @JoinColumn(name = "MANOPLATFORM_ID") }
	    )
	private Set<MANOplatform> supportedMANOPlatforms = new HashSet<MANOplatform>();

	/**
	 * 
	 */
	@OneToMany( mappedBy ="vxf", cascade = { CascadeType.ALL } , orphanRemoval = true )
	private List<VxFOnBoardedDescriptor> vxfOnBoardedDescriptors = new ArrayList<VxFOnBoardedDescriptor>();
	
	
	
	@ManyToMany(cascade = {   CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH } )
	@JoinTable(
	            name="VXF_VFIMAGES",
	            joinColumns = @JoinColumn( name="VXF_ID"),
	            inverseJoinColumns = @JoinColumn( name="IMAGE_ID")
	    )
	private Set<VFImage> vfimagesVDU = new HashSet<>();
	
	
	/**
	 * @return
	 */
	public List<VxFOnBoardedDescriptor> getVxfOnBoardedDescriptors() {
		return vxfOnBoardedDescriptors;
	}

	/**
	 * @param vxfOnBoardedDescriptors
	 */
	public void setVxfOnBoardedDescriptors(List<VxFOnBoardedDescriptor> vxfOnBoardedDescriptors) {
		this.vxfOnBoardedDescriptors = vxfOnBoardedDescriptors;
	}



	/**
	 * @return
	 */
	public boolean isCertified() {
		return certified;
	}

	/**
	 * @param certified
	 */
	public void setCertified(boolean certified) {
		this.certified = certified;
	}

	/**
	 * @return
	 */
	public boolean getCertified() {
		return this.certified;
	}

	
	/**
	 * @return
	 */
	public String getCertifiedBy() {
		return certifiedBy;
	}

	/**
	 * @param certifiedBy
	 */
	public void setCertifiedBy(String certifiedBy) {
		this.certifiedBy = certifiedBy;
	}

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
	 * @return
	 */
	public Set<MANOplatform> getSupportedMANOPlatforms() {
		return supportedMANOPlatforms;
	}

	/**
	 * @param supportedMANOPlatforms
	 */
	public void setSupportedMANOPlatforms(Set<MANOplatform> supportedMANOPlatforms) {
		this.supportedMANOPlatforms = supportedMANOPlatforms;
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

	/**
	 * @return the vfimagesVDU
	 */
	public Set<VFImage> getVfimagesVDU() {
		return vfimagesVDU;
	}

	/**
	 * @param vfimagesVDU the vfimagesVDU to set
	 */
	public void setVfimagesVDU(Set<VFImage> vfimagesVDU) {
		this.vfimagesVDU = vfimagesVDU;
	}

	
}
