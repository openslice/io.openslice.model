package io.openslice.model;

public class CompositeExperimentOnBoardDescriptor {
	private ExperimentOnBoardDescriptor obd;
	private String filename;
	private byte[] allBytes;
	public ExperimentOnBoardDescriptor getObd() {
		return obd;
	}
	public void setObd(ExperimentOnBoardDescriptor obd) {
		this.obd = obd;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getAllBytes() {
		return allBytes;
	}
	public void setAllBytes(byte[] allBytes) {
		this.allBytes = allBytes;
	}
}
