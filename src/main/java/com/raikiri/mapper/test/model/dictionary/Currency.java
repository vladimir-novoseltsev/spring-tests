package com.raikiri.mapper.test.model.dictionary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency extends DetailDictionary {
	@Column(name = "decimal_digits", nullable = false)
	private int decimalDigits = 0;

	@Column(name = "uid", length = 20)
	private String uid;

	@Column(name = "sort_order", nullable = false)
	private int sortOrder = 6;

	public int getDecimalDigits() {
		return decimalDigits;
	}

	public void setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
}
