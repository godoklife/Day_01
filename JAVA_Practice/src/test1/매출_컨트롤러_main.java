package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class 매출_컨트롤러_main {
	public static void main(String[] args) {
		컨트롤러 메인컨트롤러 = new 컨트롤러();
		
		Scanner scanner = new Scanner(System.in);
		메인컨트롤러.매출파일로딩();
			
		while(true) {
			System.out.println("주차정산금액 입력");
			int pay = scanner.nextInt();
			
			메인컨트롤러.정산금누적(pay);
			메인컨트롤러.테스트용일괄출력();
		}
	}
}
