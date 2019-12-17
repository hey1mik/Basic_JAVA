package problem;


import java.util.Scanner;

public class Star{
	static int[] data = new int[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("숫자 정렬해드립니다.");
		
		
		for(int i = 0; i < data.length; i++) {
			while(true) {
			System.out.println("▒"+(i+1)+"번수>>");
		// 사용자로부터 키보드로 정수값을 입력받아
		// data[i] 번지 배열에 값을 저장
		int num = sc.nextInt();
		// 중복값 판별
		
		 if(duplicateNum(num)) {
		// 중복체크해주는 함수의 입력값으로 사용자가 키보드로 입력한 값 전송	
		// 중복체크함수 실행결과 return값이 true이면 중복아님
		// false이면 중복	 
		//중복값이 아니면 break로 무한루프 빠져가가고
			// 다음 값을 입력하러 이동!
				 data[i] = num;
				 break;
			 	 }
			}
		}
		sort();

	
	
	}
	
	//중복값 판별부 : data 배열에 중복값이 입력되는지 여부를 체크
	// int num <- 사용자가 키보드로 입력한 값
	// num을 배열에 있는 값과 비교해서 중복인지 아닌지판단
	// 중복이면 false, 중보이 아니면 true를 리턴값으로 전달
	public static boolean duplicateNum(int num) {
		//return 값을 전달할 변수 선언 및 true로 초기화!
		boolean flag = true;
		for(int i = 0; i<data.length; i++) {
			//배열의 i번지값과 사용자가 입력한 값이 같은 지 체크
			if(data[i] == num) {
				// 같으면 flag변수에 false를 담음!
				flag = false;
			}
		}
		//나를 호출했던 곳으로 돌아가면서 boolean type의
		//return값 flag를 전달
		return flag;
		
		
	}
	
	public static void sort() {
		for(int j = data.length-1; j>0; j--) {
			for(int i = 0; i<j; i++) {
				if(data[i]>data[i+1]) {
					int temp = data[i+1];
					data[i+1] = data[i];
					data[i] = temp;
				}
			}
		 }
		viewData();
	}
	

		

	public static void viewData() {
		for(int i = 0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		
	}
	
	
}
	

