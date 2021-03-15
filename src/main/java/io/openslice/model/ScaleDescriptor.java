package io.openslice.model;

/**
 * @author ctranoris
 *
 */
public class ScaleDescriptor {

	private String deploymentRequestID;
	private String nsInstanceId;
	private String scaleType= "SCALE_VNF";
	private String memberVnfIndex;
	private String scalingGroupDescriptor;
	private String scaleVnfType ;
	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}
	/**
	 * @param nsInstanceId the nsInstanceId to set
	 */
	public void setNsInstanceId(String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
	}
	/**
	 * @return the scaleType
	 */
	public String getScaleType() {
		return scaleType;
	}
	/**
	 * @param scaleType the scaleType to set
	 */
	public void setScaleType(String scaleType) {
		this.scaleType = scaleType;
	}
	/**
	 * @return the memberVnfIndex
	 */
	public String getMemberVnfIndex() {
		return memberVnfIndex;
	}
	/**
	 * @param memberVnfIndex the memberVnfIndex to set
	 */
	public void setMemberVnfIndex(String memberVnfIndex) {
		this.memberVnfIndex = memberVnfIndex;
	}
	/**
	 * @return the scalingGroupDescriptor
	 */
	public String getScalingGroupDescriptor() {
		return scalingGroupDescriptor;
	}
	/**
	 * @param scalingGroupDescriptor the scalingGroupDescriptor to set
	 */
	public void setScalingGroupDescriptor(String scalingGroupDescriptor) {
		this.scalingGroupDescriptor = scalingGroupDescriptor;
	}
	/**
	 * @return the scaleVnfType
	 */
	public String getScaleVnfType() {
		return scaleVnfType;
	}
	/**
	 * @param scaleVnfType the scaleVnfType to set
	 */
	public void setScaleVnfType(String scaleVnfType) {
		this.scaleVnfType = scaleVnfType;
	}
	/**
	 * @return the deploymentRequestID
	 */
	public String getDeploymentRequestID() {
		return deploymentRequestID;
	}
	/**
	 * @param deploymentRequestID the deploymentRequestID to set
	 */
	public void setDeploymentRequestID(String deploymentRequestID) {
		this.deploymentRequestID = deploymentRequestID;
	}
	
	
	

}
