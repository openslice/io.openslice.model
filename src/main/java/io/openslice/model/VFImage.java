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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ctranoris
 *
 */
@Entity(name = "VFImage")
@JsonIgnoreProperties(value = { "usedByVxFs"  })
public class VFImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;
	
	@Basic()
	private String name = null;
	
	@Basic()
	private String uuid = null;
	
	@Basic()
	private String shortDescription = null;

	@Basic()
	private String packageLocation = null;
	

	@Basic()
	private String publicURL = null;
	
	@Basic()
	private Date dateCreated;
	

	@Basic()
	private Date dateUpdated;
	
	@ManyToMany(mappedBy = "vfimagesVDU", cascade = {  CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH   })	 
	private List<VxFMetadata> usedByVxFs = new ArrayList<>();
	
	@Transient
	private Set<RefVxF> refVxFs = new HashSet<>();
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH  })
	@JoinColumns({ @JoinColumn() })
	private PortalUser owner = null;
	
	@Basic()
	private boolean published;
	
	@Lob
	@Column(name = "TERMS", columnDefinition = "LONGTEXT")
	private String termsOfUse;	
	
	@ManyToMany(cascade = {  CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH   })
	@JoinTable()
	private List<Infrastructure> deployedInfrastructures = new ArrayList<>();

	public VFImage(){
		
	}
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the packageLocation
	 */
	public String getPackageLocation() {
		return packageLocation;
	}

	/**
	 * @param packageLocation the packageLocation to set
	 */
	public void setPackageLocation(String packageLocation) {
		this.packageLocation = packageLocation;
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
	 * @return the usedByVxFs
	 */
	public List<VxFMetadata> getUsedByVxFs() {
		return usedByVxFs;
	}

	/**
	 * @param usedByVxFs the usedByVxFs to set
	 */
	public void setUsedByVxFs(List<VxFMetadata> usedByVxFs) {
		this.usedByVxFs = usedByVxFs;
	}

	/**
	 * @return the owner
	 */
	public PortalUser getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(PortalUser owner) {
		this.owner = owner;
	}

	/**
	 * @return the published
	 */
	public boolean isPublished() {
		return published;
	}

	/**
	 * @param published the published to set
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}

	/**
	 * @return the termsOfUse
	 */
	public String getTermsOfUse() {
		return termsOfUse;
	}

	/**
	 * @param termsOfUse the termsOfUse to set
	 */
	public void setTermsOfUse(String termsOfUse) {
		this.termsOfUse = termsOfUse;
	}

	/**
	 * @return the deployedInfrastructures
	 */
	public List<Infrastructure> getDeployedInfrastructures() {
		return deployedInfrastructures;
	}

	/**
	 * @param deployedInfrastructures the deployedInfrastructures to set
	 */
	public void setDeployedInfrastructures(List<Infrastructure> deployedInfrastructures) {
		this.deployedInfrastructures = deployedInfrastructures;
	}


	/**
	 * @return the publicURL
	 */
	public String getPublicURL() {
		return publicURL;
	}


	/**
	 * @param publicURL the publicURL to set
	 */
	public void setPublicURL(String publicURL) {
		this.publicURL = publicURL;
	}


	/**
	 * @return the refVxFs
	 */
	public Set<RefVxF> getRefVxFs() {
		refVxFs.clear();
		for (VxFMetadata vxf : usedByVxFs) {
			RefVxF ref = new RefVxF( vxf.getId(), vxf.getName());
			refVxFs.add( ref );
		}
		return refVxFs;
	}
	
	
	/**
	 * @param refVxFs the refVxFs to set
	 */
	public void setRefVxFs(Set<RefVxF> refVxFs) {
		this.refVxFs = refVxFs;
	}


	/**
	 * @return the dateUpdated
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}


	/**
	 * @param dateUpdated the dateUpdated to set
	 */
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}





	/**
	 * Locally used to report back objects, otherwise the response would be recursive
	 * @author ctranoris
	 *
	 */
	static class RefVxF {

		private long id;
		private String name;
		
		public RefVxF() {
					
		}
		
		public RefVxF(long id2, String name2) {
			id = id2;
			name = name2;
					
		}

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		
	}


	/**
	 * @param id2
	 * @return
	 */
	public Infrastructure getDeployedInfrastructureById(long id2) {
		
		for (Infrastructure infrastructure : deployedInfrastructures) {
			if ( infrastructure.getId() == id2 ){
				return infrastructure;
			}
		}
		return null;
	}
	
	
}
