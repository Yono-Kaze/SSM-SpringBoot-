package com.imooc.myo2o.dto;

import java.io.InputStream;

public class ImageHolderDED {
	
	private String imageName;
	private InputStream image;
	
	public ImageHolderDED(String imageName, InputStream image) {
		super();
		this.imageName = imageName;
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}
		
	
}
