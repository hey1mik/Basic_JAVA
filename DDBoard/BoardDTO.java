package problem.DDBoard;

import java.sql.Date;

public class BoardDTO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	public BoardDTO() {}//기본룰, 혹시 모르니까 만드는 애

	public BoardDTO(int bno, String title, String content, String writer, Date regdate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}
	

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return bno + "\t" + title+ "\t" + content + "\t" + writer
				+ "\t"+ regdate;
	}

	public BoardDTO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardDTO(int bno, String title, String content, String writer) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	
	
	
}
