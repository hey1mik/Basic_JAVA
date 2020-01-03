package market;

import java.sql.Date;

public class SaleDTO {
	
	private int sno;
	private String sname;
	private int sCnt;
	private int sPrice;
	private Date regdate;
	
	public SaleDTO() {}

	public SaleDTO(int sno, String sname, int sCnt, int sPrice, Date regdate) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sCnt = sCnt;
		this.sPrice = sPrice;
		this.regdate = regdate;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getsCnt() {
		return sCnt;
	}

	public void setsCnt(int sCnt) {
		this.sCnt = sCnt;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return sno + "\t" + sname + "\t" + sCnt + "\t" + sPrice + "\t" + regdate;
	}
	
	
}
