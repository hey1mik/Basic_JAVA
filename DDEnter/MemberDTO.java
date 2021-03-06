package problem.DDEnter;

import java.sql.Date;

public class MemberDTO {
	//1.변수(DB Table 참조)
	private String ano;
	private String aname;
	private String major;
	private String groupyn;
	private int sal;
	private Date regdate;
	
	
	
	//2.생성자(Default, 전역변수 All)
	public MemberDTO() {}
	
	public MemberDTO(String ano, String aname, String major, String groupyn, int sal, Date regdate) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.sal = sal;
		this.regdate = regdate;
		
	}
	

	//3. getter(), setter()
	
	public MemberDTO(String aname, String major, String groupyn, int sal) {
		super();
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.sal = sal;
	}
	
	

	public MemberDTO(String ano, String aname, String major, String groupyn, int sal) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.sal = sal;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGroupyn() {
		return groupyn;
	}

	public void setGroupyn(String groupyn) {
		this.groupyn = groupyn;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	//4.toString() -> 값이 dto에 제대로 들어있는지 확인하는 역할
	@Override
	public String toString() {
		return ano + "\t" + aname + "\t" + major + "\t" + groupyn +"\t"+ sal + "\t"
				   + regdate;
	}

	
	

}
