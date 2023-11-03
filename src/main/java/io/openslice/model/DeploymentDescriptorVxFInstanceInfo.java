package io.openslice.model;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ichatzis
 *
 */
@Entity(name = "DeploymentDescriptorVxFInstanceInfo")
public class DeploymentDescriptorVxFInstanceInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2904593792014246094L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;
    
	@Basic()
	private String memberVnfIndexRef = null;	
	
	public String getMemberVnfIndexRef() {
		return memberVnfIndexRef;
	}

	public void setMemberVnfIndexRef(String memberVnfIndexRef) {
		this.memberVnfIndexRef = memberVnfIndexRef;
	}

	@Lob
	@Column(columnDefinition = "LONGTEXT")	
	private String vxfInstanceInfo = null;

	public String getVxfInstanceInfo() {
		return vxfInstanceInfo;
	}

	public void setVxfInstanceInfo(String vxfInstanceInfo) {
		this.vxfInstanceInfo = vxfInstanceInfo;
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
