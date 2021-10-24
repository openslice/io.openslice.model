package io.openslice.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

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
