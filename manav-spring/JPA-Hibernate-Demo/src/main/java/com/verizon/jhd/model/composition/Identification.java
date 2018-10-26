package com.verizon.jhd.model.composition;

import javax.persistence.Embeddable;

@Embeddable
public class Identification {
	private String photoFileName;
	private String fingerPrint;
	public Identification() {
		super();
	}
	public Identification(String photoFileName, String fingerPrint) {
		super();
		this.photoFileName = photoFileName;
		this.fingerPrint = fingerPrint;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getFingerPrint() {
		return fingerPrint;
	}
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	

}
