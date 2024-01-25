package ch17_collection.part1_list.sec03_Message;

import java.time.LocalDateTime;

public class Message {
	private int mid;
	private String content;
	private String writer;
	private LocalDateTime modTime;
	private int isDeleted;
	
	public Message() {}
	
	public Message(String content, String writer, LocalDateTime modTime) {
		this.content = content;
		this.writer = writer;
		this.modTime = modTime;
	}

	public Message(int mid, String content, String writer, LocalDateTime modTime, int isDeleted) {
		this.mid = mid;
		this.content = content;
		this.writer = writer;
		this.modTime = modTime;
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

	public String getModTime() {
		String now = this.modTime.toString();
		return now.substring(0, 10) + ", " + now.substring(11, 19);
	}

	public void setModTime(LocalDateTime modTime) {
		this.modTime = modTime;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Message [mid=" + mid + ", content=" + content + ", writer=" + writer +
				", modTime=" + modTime.toString().substring(0, 19).replace("T", " ")
				+ ", isDeleted=" + isDeleted + "]";
	}
	
	
}
