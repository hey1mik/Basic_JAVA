package chapter05;

public class Constructor01 {
	// Default 생성자
	// Class에 생성자가 존재하지 않으면
	// JAVA에서 Default 생성자를 생성 
	// Default 생성자는 객체생성만 함
	//1. 매개변수의 갯수가 다르면 됨 (변수명이 다른건 소용없음. 순서를 따지는 것이기 때문.)
	//2. 매개변수의 갯수가 같으면 타입이 다르면 됨
	//3. 매개변수의 순서가 다르면 됨
	
	public Constructor01() {} //Default
	public Constructor01(String a) {}
	public Constructor01(int a) {}
	public Constructor01(int a, int b, String c){}
	public Constructor01(String c, int a, int b){}
	
	
	
	
	
	
}
