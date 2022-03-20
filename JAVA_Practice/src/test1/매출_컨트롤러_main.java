package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class 매출_컨트롤러_main {
	public static void main(String[] args) {
		컨트롤러 메인컨트롤러 = new 컨트롤러();
		
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		메인컨트롤러.매출파일로딩();
		메인컨트롤러.테스트용일괄출력();
		
		while(true) {
			System.out.println("1. 주차장정산금액 입력 | 2. 검색");
			System.out.print("입력 >");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("주차정산금액 입력");
				int 출차하면서받은금액 = scanner.nextInt();
				메인컨트롤러.정산금누적(출차하면서받은금액);
			}	
			
			// 주차장 정산금액입력 if문 END @@@ 프로젝트 메인 클래스에 합칠때 삭제한뒤 컨트롤러 객체의 정산금누적 객체로 인수형태로 던져주면됨
			
			else if(ch==2) {	// 여기부터 검색매뉴진입 else if END 까지 프로젝트 메인 클래스에 합칠때 그대로 복붙
				System.out.println("검색할 연도를 정수로 입력하세요.\n입력예시) 2022년 : 22");
				System.out.print("입력 >");
				int year = scanner.nextInt();
				System.out.println(year+"년에서 검색할 달을 정수로 입력하세요.\n입력예시)03월 : 3");
				System.out.print("입력 >");

				int month = scanner.nextInt();
				ArrayList<매출> 검색결과출력용리스트 =  new ArrayList<>(메인컨트롤러.매출출력(year, month));
				for(매출 tmp : 검색결과출력용리스트) {
					System.out.printf("%d년 %2d월 %3s 매출 : %s원\n", year, month, tmp.get날짜(), tmp.get매출금액());
				}
			}	// 검색매뉴진입 else if END
		}	// while END
	}	// main END
}	// class END
