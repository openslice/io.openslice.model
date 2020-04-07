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

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}
	
}
