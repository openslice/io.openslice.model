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
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ctranoris
 *
 */

@Entity(name = "Infrastructure")
@JsonIgnoreProperties(value = { "supportedImages"  })
public class Infrastructure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;

	@Basic()
	private String organization = null;
	@Basic()
	private String name = null;
	@Basic()
	private String email = null;
	@Basic()	
	private InfrastructureStatus infrastructureStatus = InfrastructureStatus.UNKNOWN;

	@Basic()
	private Date dateCreated;
	
	@Basic()
	private String datacentername = null;
	
	@Basic()
	private String vimid = null;

	@ManyToOne
	@JoinColumn(name = "mp_id")
	private MANOprovider mp = null;

	@ManyToMany(cascade = {  CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable()
	private List<VFImage> supportedImages = new ArrayList<>();
	

	@Transient
	private List<RefVFImage> refSupportedImages = new ArrayList<>();
	

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public String getDatacentername() {
		return datacentername;
	}

	public void setDatacentername(String datacentername) {
		this.datacentername = datacentername;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getVIMid() {
		return vimid;
	}

	public void setVIMid(String vimid) {
		this.vimid = vimid;
	}
	
	public MANOprovider getMp() {
		return mp;
	}

	public void setMp(MANOprovider mp) {
		this.mp = mp;
	}

	/**
	 * @return the supportedImages
	 */
	public List<VFImage> getSupportedImages() {
		return supportedImages;
	}

	/**
	 * @param supportedImages the supportedImages to set
	 */
	public void setSupportedImages(List<VFImage> supportedImages) {
		this.supportedImages = supportedImages;
	}	

	/**
	 * @return the refSupportedImages
	 */
	public List<RefVFImage> getRefSupportedImages() {
		refSupportedImages.clear();
		for (VFImage vfimg : supportedImages) {
			RefVFImage ref = new RefVFImage( vfimg.getId(), vfimg.getName());
			refSupportedImages.add( ref );
		}
		return refSupportedImages;
	}

	/**
	 * @param refSupportedImages the refSupportedImages to set
	 */
	public void setRefSupportedImages(List<RefVFImage> refSupportedImages) {
		this.refSupportedImages = refSupportedImages;
	}

	/**
	 * Locally used to report back objects, otherwise the response would be recursive
	 * @author ctranoris
	 *
	 */
	static class RefVFImage {
		
		/** */
		private long id;
		/** */
		private String name;
		
		public RefVFImage() {
			
		}
		
		public RefVFImage(long id2, String name2) {
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


	public InfrastructureStatus getInfrastructureStatus() {
		return infrastructureStatus;
	}

	public void setInfrastructureStatus(InfrastructureStatus infrastructureStatus) {
		this.infrastructureStatus = infrastructureStatus;
	}

	/**
	 * @param l
	 * @return
	 */
	public Object getSupportedImageById(long l) {
		for (VFImage refVFImage : supportedImages) {
			if ( refVFImage.getId() == l  ){
				return refVFImage;
			}
		}
		return null;
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
