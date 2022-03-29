package board_package;

import java.time.LocalDateTime;

public class Model_Board {
	
	// 1. ÇÊµå
	private String id;
	private String pw;
	private String title;
	private int num;
	private String viewcount;
	private String contents;
	private LocalDateTime submitDateTime;
	
	
	public Model_Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Model_Board(String id, String pw, String title, int num, String viewcount, String contents,
			LocalDateTime submitDateTime) {
		super();
		this.id = id;
		this.pw = pw;
		this.title = title;
		this.num = num;
		this.viewcount = viewcount;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getViewcount() {
		return viewcount;
	}

	public void setViewcount(String viewcount) {
		this.viewcount = viewcount;
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
