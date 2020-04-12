
public class pibonacci {

	public static void main(String[] args) {
		int start = 1;
		int end = 1;
		int sum = 2;
		
		System.out.println(start);
		for(int i = 1; i <= 8; i++) {
			sum = start + end;
			System.out.println(sum);
			start = end;
			end = sum;
		}
	}
}
