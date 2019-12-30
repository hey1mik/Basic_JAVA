package bank;

import java.util.Date;

public class BankDTO {
	
	private int bno;
	private String bname;
	private String pw;
	private String money;
	private Date regdate;

	public BankDTO() {}

	public BankDTO(int bno, String bname, String pw, String money, Date regdate) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.pw = pw;
		this.money = money;
		this.regdate = regdate;
	}


	public int getBno() {
		return bno;
	}

	

	public BankDTO(int bno, String pw) {
		super();
		this.bno = bno;
		this.pw = pw;
	}



	public BankDTO(int bno, String bname, String pw) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.pw = pw;
	}

	public BankDTO(String bname, String pw) {
		super();
		this.bname = bname;
		this.pw = pw;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return bno +"\t" + bname + "\t" + pw + "\t" + money + "\t" + regdate;
	}
	
	
}
