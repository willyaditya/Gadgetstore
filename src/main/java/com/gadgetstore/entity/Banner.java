package com.gadgetstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banners")
public class Banner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private byte category;
	@Column(length = 255, nullable = false)
	private String bannerImage;
	@Column(nullable = false)
	private byte status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getCategory() {
		return category;
	}

	public void setCategory(byte category) {
		this.category = category;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

}
