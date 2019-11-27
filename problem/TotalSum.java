package problem;

public class TotalSum {
//1~100까지 수중에 짝수만 더해서 출력하시오.
	public static void main(String[] args) {

		int odd = 0;
		int even = 0;
		
		for(int i = 1; i <= 100; i++) {
			if(i%2 == 0) { //짝수
				even = even + i;
			} else {
				odd = odd + i;
			}
			
		}
	System.out.println("1부터 100까지의 짝수 총합"+even);
	System.out.println("1부터 100까지의 홀수 총합"+odd);
	}

}
