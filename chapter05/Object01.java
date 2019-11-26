package chapter05;

public class Object01 {

	public static void main(String[] args) {
		// 프로그램의 메인 부분!
		
		//객체사용3단계 : 2. 객체 생성
		// 객체생성 >> 인스턴스(결과물) 생성
		Cooking cook = new Cooking();
		//객체사용3단계 : 3.인스턴스(결과물) 사용
		
		cook.makeCake("초코");
		cook.makeCake("딸기");
		cook.makeCake("뉴욕치즈");
		cook.makeCake("티라미수");
		cook.makeCake("청포도");
		cook.makeCake("생크림");
	
	}
}
