package com.manager.entity;

import java.io.Serializable;
import java.util.Date;

public class MaterialId implements Serializable{
	private static final long serialVersionUID = 1L;
	private String partnumber;
	private String partRev;
	private String partActive;
	public String getPartnumber() {
		return partnumber;
	}
	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}
	public String getPartRev() {
		return partRev;
	}
	public void setPartRev(String partRev) {
		this.partRev = partRev;
	}
	public String getPartActive() {
		return partActive;
	}
	public void setPartActive(String partActive) {
		this.partActive = partActive;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partActive == null) ? 0 : partActive.hashCode());
		result = prime * result + ((partRev == null) ? 0 : partRev.hashCode());
		result = prime * result + ((partnumber == null) ? 0 : partnumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialId other = (MaterialId) obj;
		if (partActive == null) {
			if (other.partActive != null)
				return false;
		} else if (!partActive.equals(other.partActive))
			return false;
		if (partRev == null) {
			if (other.partRev != null)
				return false;
		} else if (!partRev.equals(other.partRev))
			return false;
		if (partnumber == null) {
			if (other.partnumber != null)
				return false;
		} else if (!partnumber.equals(other.partnumber))
			return false;
		return true;
	}
	
}
