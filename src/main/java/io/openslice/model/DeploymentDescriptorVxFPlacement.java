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

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author ctranoris
 *
 */
/**
 * @author ctranoris
 *
 */
@Entity(name = "DeploymentDescriptorVxFPlacement")
public class DeploymentDescriptorVxFPlacement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;



	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH }, orphanRemoval = true )
	@JoinColumn(name = "constituent_vxf_id")
	private ConstituentVxF constituentVxF = null;
	

	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH } )
	@JoinColumn(name = "infrastructure_id")
	private Infrastructure infrastructure = null;


	public ConstituentVxF getConstituentVxF() {
		return constituentVxF;
	}


	public void setConstituentVxF(ConstituentVxF constituentVxF) {
		this.constituentVxF = constituentVxF;
	}


	public Infrastructure getInfrastructure() {
		return infrastructure;
	}


	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}
	
	
	
}
