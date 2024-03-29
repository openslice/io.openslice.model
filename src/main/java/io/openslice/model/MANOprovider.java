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
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ctranoris
 * 
 * Describes a MANO provider that can be accessed via an API
 *
 */
/**
 * @author ctranoris
 *
 */
@Entity(name = "MANOprovider")
public class MANOprovider implements IMANOprovider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;

	@Basic()
	private String name = null;

	@Basic()
	private String description = null;

	@OneToMany(mappedBy ="mp", fetch = FetchType.EAGER)
	private List<Infrastructure> vims = new ArrayList<Infrastructure>();


	@JsonProperty("vims")
	public List<Infrastructure> getVimsID() {
		
		List<Infrastructure> vimsids = new ArrayList<>();
		if(this.vims!=null)
		{
			for (Infrastructure infrastructure : vims) {
				Infrastructure in = new Infrastructure();
				in.setName( infrastructure.getName() );
				in.setId(infrastructure.getId());
				in.setVIMid(infrastructure.getVIMid());
				in.setDatacentername(infrastructure.getDatacentername());
				vimsids.add(in);
			}
		}
		return vimsids;
	}

	
    public List<Infrastructure> getVims() {
		return vims;
	}


	public void setVims(List<Infrastructure> vims) {
		this.vims = vims;
	}


	@ManyToOne
    @JoinColumn(name="MP_ID", nullable=false)
	private MANOplatform supportedMANOplatform;
	

	@Basic()
	private String apiEndpoint = null;
	
	
	/**
	 * base64-encoding of username:password
	 */
	@Basic()
	private String authorizationBasicHeader = null;
	
	
	/**
	 * username to connect
	 */
	@Basic()
	private String username = null;
	
	/**
	 * password to connect
	 */
	@Basic()
	private String password = null;

	/**
	 * OSM MANO project to use
	 */
	@Basic()
	private String project = null;
	
	/**
	 * password to connect
	 */
	@Basic()
	private Boolean enabledForONBOARDING = null;
	@Basic()
	private Boolean enabledForSYNC = null;


	public String getAuthorizationBasicHeader() {
		return authorizationBasicHeader;
	}


	public void setAuthorizationBasicHeader(String authorizationBasicHeader) {
		this.authorizationBasicHeader = authorizationBasicHeader;
	}


	public String getApiEndpoint() {
		return apiEndpoint;
	}


	public void setApiEndpoint(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public MANOplatform getSupportedMANOplatform() {
		return supportedMANOplatform;
	}


	public void setSupportedMANOplatform(MANOplatform supportedMANOplatform) {
		this.supportedMANOplatform = supportedMANOplatform;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the enabledForONBOARDING
	 */
	public Boolean getEnabledForONBOARDING() {
		return enabledForONBOARDING;
	}
	/**
	 * @param enabledForONBOARDING the enabledForONBOARDING to set
	 */
	public void setEnabledForONBOARDING( Boolean enabledForONBOARDING) {
		this.enabledForONBOARDING = enabledForONBOARDING;
	}
	
	/**
	 * @return the enabledForSYNC
	 */
	public Boolean getEnabledForSYNC() {
		return enabledForSYNC;
	}
	/**
	 * @param enabledForSYNC the enabledForSYNC to set
	 */
	public void setEnabledForSYNC( Boolean enabledForSYNC) {
		this.enabledForSYNC = enabledForSYNC;
	}
	
	
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
}
