package com.kh.springdb.model;

import java.util.Date;

public class User {
	private int mno;
	private String mname;
	private String memail;
	private Date mBirth;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public Date getmBirth() {
		return mBirth;
	}
	public void setmBirth(Date mBirth) {
		this.mBirth = mBirth;
	}
}
