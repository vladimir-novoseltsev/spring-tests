package com.raikiri.mapper.test.model.dictionary;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.raikiri.mapper.test.model.AbstractEntity;

@MappedSuperclass
public class BaseDictionary extends AbstractEntity {
	public final static int MAX_CODE_LEN = 255;

	@Column(name = "code", nullable = false, length = MAX_CODE_LEN, unique = true)
	private String code;

	@Column(name = "is_disabled", nullable = false)
	private boolean disabled;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}
