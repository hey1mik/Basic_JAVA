package shop;

public class Member {

	// 회원가입
	
	public String memInsert(String id, String pw, String name){
		System.out.println(id + "," + pw + "," + name + "로 회원가입 성공");
		String status = "success";
		return status;
	}
	
	// 회원수정
	
	public void memUpdate() {
		System.out.println("회원수정 되셨습니다");
	}
	 
	// 회원탈퇴
	public String memDelete(String id, String pw) {
		return "";
	}
}
