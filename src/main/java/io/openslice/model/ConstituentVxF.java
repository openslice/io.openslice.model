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

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "ConstituentVxF")
@JsonIgnoreProperties(value = { "vxfref"  })
public class ConstituentVxF {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;

	@Basic()
	private int membervnfIndex;

	@Basic()
	private String vnfdidRef;
	
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH } )
	@JoinColumn(name = "vxf_id")
	private VxFMetadata vxfref;

	public int getMembervnfIndex() {
		return membervnfIndex;
	}

	public void setMembervnfIndex(int membervnfIndex) {
		this.membervnfIndex = membervnfIndex;
	}

	public String getVnfdidRef() {
		return vnfdidRef;
	}

	public void setVnfdidRef(String vnfdidRef) {
		this.vnfdidRef = vnfdidRef;
	}

	public VxFMetadata getVxfref() {
		return vxfref;
	}

	public void setVxfref(VxFMetadata vxfref) {
		this.vxfref = vxfref;
	}
    
	
	
}
