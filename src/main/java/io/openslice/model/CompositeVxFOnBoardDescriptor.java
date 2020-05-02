package io.openslice.model;

public class CompositeVxFOnBoardDescriptor {
	private VxFOnBoardedDescriptor obd;
	private String filename;
	private byte[] allBytes;
	public VxFOnBoardedDescriptor getObd() {
		return obd;
	}
	public void setObd(VxFOnBoardedDescriptor obd) {
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
