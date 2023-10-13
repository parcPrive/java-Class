package com.mok.dto;

public class BoardDto {
	private int num;
	private int no;
	private String userID;
	private String name;
	private String title;
	private String content;
	private String regDate;
	private int hit;
	private int regroup;
	private int relevel;
	private int restep;
	private int available;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRegroup() {
		return regroup;
	}
	public void setRegroup(int regroup) {
		this.regroup = regroup;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int no, String userID, String name, String title, String content, String regDate, int hit,
			int regroup, int relevel, int restep, int available) {
		super();
		this.no = no;
		this.userID = userID;
		this.name = name;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.regroup = regroup; //댓글들의 시작
		this.relevel = relevel; //대댓글의 모음
		this.restep = restep; //
		this.available = available;
	}
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", userID=" + userID + ", name=" + name + ", title=" + title + ", content="
				+ content + ", regDate=" + regDate + ", hit=" + hit + ", regroup=" + regroup + ", relevel=" + relevel
				+ ", restep=" + restep + ", available=" + available + "]";
	}
	
	
	
}
