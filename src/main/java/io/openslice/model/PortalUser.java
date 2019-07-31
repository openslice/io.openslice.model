package io.openslice.model;
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


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(value = { "products", "vfimages", "deployments", "subscribedResources" })
public class PortalUser {

	private int id = 0;

	
	private String organization = null;
	
	private String name = null;
	
	private String email = null;
	
	private String username = null;
	
	private String password = null;
//	
//	private String role = null;
		
	private Boolean active = false;
	
	private String currentSessionID = null;
	
	private String apikey = null;
	
	/**
	 * 
	 */
	private List<UserRoleType> roles = new ArrayList<UserRoleType>();
	


	public List<UserRoleType> getRoles() {
		return roles;
	}


	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String newOrganization) {
		organization = newOrganization;
	}


	public int getId() {
		return id;
	}

	public void setId(int newId) {
		id = newId;
	}

	@Override
	public String toString() {
		return "PortalUser " + " [organization: " + getOrganization() + "]" + " [id: " + getId() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	public void setPasswordUnencrypted(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCurrentSessionID() {
		return currentSessionID;
	}

	public void setCurrentSessionID(String currentSessionID) {
		this.currentSessionID = currentSessionID;
	}

	public void addRole(UserRoleType role ) {
		this.roles.add(role);		
	}
	
	public void removeRole(UserRoleType role ) {
		this.roles.remove(role);		
	}
	


	/**
	 * @return the apikey
	 */
	public String getApikey() {
		return apikey;
	}

	/**
	 * @param apikey the apikey to set
	 */
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	
}
