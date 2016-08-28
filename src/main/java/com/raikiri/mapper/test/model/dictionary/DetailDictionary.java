package com.raikiri.mapper.test.model.dictionary;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DetailDictionary extends BaseDictionary {
	public final static int MAX_DESCRIPTION_LEN = 255;

	@Column(name = "description", length = MAX_DESCRIPTION_LEN)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
