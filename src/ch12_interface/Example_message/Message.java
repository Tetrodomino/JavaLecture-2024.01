package ch12_interface.Example_message;

import java.time.LocalDateTime;

public class Message {
	private int mid;
	private String content;
	private String writer;
	private LocalDateTime genTime;
	private int isDeleted = 0;
	
	public Message() {}
	
	public Message(String content, String writer, LocalDateTime genTime) {
		this.content = content;
		this.writer = writer;
		this.genTime = genTime;
	}
	
	public Message(int mid, String content, String writer, LocalDateTime genTime) {
		this.mid = mid;
		this.content = content;
		this.writer = writer;
		this.genTime = genTime;
	}
	
	public Message(int mid, String content, String writer, LocalDateTime genTime, int isDeleted) {
		this.mid = mid;
		this.content = content;
		this.writer = writer;
		this.genTime = genTime;
		this.isDeleted = isDeleted;
	}



	public int getMid() {
		return mid;
	}



	public void setMid(int mid) {
		this.mid = mid;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getGenTime() {
		String now = this.genTime.toString();
		return now.substring(0, 10) + ", " + now.substring(11, 19);
	}



	public void setGenTime(LocalDateTime genTime) {
		this.genTime = genTime;
	}



	public int getIsDeleted() {
		return isDeleted;
	}



	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}
