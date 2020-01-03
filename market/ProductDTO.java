package market;

import java.sql.Date;



public class ProductDTO {
	
	private int pno;
	private String pname;
	private String company;
	private int price;
	private int cnt;
	private Date hiredate;
	private String newPname;
	
	

	public ProductDTO() {}
	
	public ProductDTO(String pname, String company, int price, String newPname) {
		super();
		this.pname = pname;
		this.company = company;
		this.price = price;
		this.newPname = newPname;
	}
	
	public ProductDTO(int pno, String pname, String company, int price, int cnt, Date hiredate) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.company = company;
		this.price = price;
		this.cnt = cnt;
		this.hiredate = hiredate;
	}
	

	public ProductDTO(String pname, String company, int price) {
		super();
		this.pname = pname;
		this.company = company;
		this.price = price;
	}

	public ProductDTO(String pname, String company, int price, int cnt) {
		super();
		this.pname = pname;
		this.company = company;
		this.price = price;
		this.cnt = cnt;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return pno + "\t" + pname + "\t" + company + "\t" + price + "\t" + cnt + "\t" + hiredate;
	}


	 
	 
}

