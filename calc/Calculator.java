package problem.calc;

public class Calculator {
	int result; // 연산 결과를 저장할 변수
	//덧셈기능
	public int sum(int first, int second) {
		result = first+second;
		return result;
	}
	//뺄셈 기능
	public int sub(int first, int second) {
		result = first-second;
		return result;
	}
	
	//곱셈기능
	public int multi(int first, int second) {
		
		result = first*second;
		return result;
		
	}
	//나눗셈 기능
	public int div(int first, int second) {
		
		result = first/second;
		return result;
	}
	
}
