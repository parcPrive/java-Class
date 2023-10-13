package com.mok.dto;

public class ModalDto {
	private String state;
	private String msg;
	public ModalDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModalDto(String state, String msg) {
		super();
		this.state = state;
		this.msg = msg;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
