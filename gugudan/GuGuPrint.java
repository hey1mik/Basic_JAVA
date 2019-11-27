package gugudan;

public class GuGuPrint {
	
	public void guGuDan(int num2) {
		
		System.out.println();
		System.out.println("구구단" + num2 + "단 출력!");
		System.out.println();

		int result;
		for (int num1 = 1; num1 <= 19; num1++) {
			result = num1 * num2;
			System.out.printf("%d x %d = %d\n", num2, num1, result);

		}

	} 
	/*
	 * 메서드가 끝나는 시점에는 두 가지가 있다. 
	 * 중괄호를 만났을 때와, return을 만났을 때....
	 */

 }
