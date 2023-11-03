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

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ctranoris
 * maintains information and status of a VNF on which MANO providers is on-boarded
 * see https://github.com/5GinFIRE/eu.5ginfire.portal.api/issues/10 
 */
@Entity(name = "VxFOnBoardedDescriptor")
@JsonIgnoreProperties(value = { "vxf" })

public class VxFOnBoardedDescriptor extends OnBoardDescriptor{

		
	@ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "vxf_id")
	private VxFMetadata vxf;
		
	
	private String vxfMANOProviderID;	
		
	private long tempvxfID;

	public VxFOnBoardedDescriptor() {		
	}
	
	public VxFOnBoardedDescriptor(VxFMetadata v) {
		this.vxf = v;
	}

	

	public VxFMetadata getVxf() {
		return vxf;
	}

	public void setVxf(VxFMetadata vxf) {
		this.vxf = vxf;
		this.tempvxfID = vxf.getId();
	}
	
		
	public long getVxfid() {
		if ( vxf != null ) {
			return vxf.getId();
		}else {
			return this.tempvxfID;
		}
	}

	public void setVxfid(long vxfid) {
		this.tempvxfID = vxfid; 
	}

	public String getVxfMANOProviderID() {
		return vxfMANOProviderID;
	}

	public void setVxfMANOProviderID(String vxfMANOProviderID) {
		this.vxfMANOProviderID = vxfMANOProviderID;
	}
}
