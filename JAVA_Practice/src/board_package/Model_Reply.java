package board_package;

import java.time.LocalDateTime;

public class Model_Reply {
	
	// 1. 필드
	private String id;
	private String pw;
	private int num;
	private String contents;
	private LocalDateTime submitDateTime;
	
	// 2. 생성자
	public Model_Reply() {
		// TODO Auto-generated constructor stub
	}

	public Model_Reply(String id, String pw, int num, String contents, LocalDateTime submitDateTime) {
		super();
		this.id = id;
		this.pw = pw;
		this.num = num;
		this.contents = contents;
		this.submitDateTime = submitDateTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDateTime getSubmitDateTime() {
		return submitDateTime;
	}

	public void setSubmitDateTime(LocalDateTime submitDateTime) {
		this.submitDateTime = submitDateTime;
	}
	
	
}
