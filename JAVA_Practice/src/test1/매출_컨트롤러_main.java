package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class 매출_컨트롤러_main {
	public static void main(String[] args) {
		컨트롤러 메인컨트롤러 = new 컨트롤러();
		
		Scanner scanner = new Scanner(System.in);
		메인컨트롤러.매출파일로딩();
			
		while(true) {
			System.out.println("1. 주차장정산금액 입력 | 2. 검색\n입력 : ");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("주차정산금액 입력");
				int pay = scanner.nextInt();
				메인컨트롤러.정산금누적(pay);
			}else if(ch==2) {
				System.out.println("연도 입력\n입력예시)2022년 : 22)");
				int year = scanner.nextInt();
				System.out.println("월 입력\n입력예시)03월 : 3");
				int month = scanner.nextInt();
				ArrayList<매출> 검색결과출력용리스트 =  new ArrayList<>(메인컨트롤러.매출출력(year, month));
				for(int i=0; i<검색결과출력용리스트.size(); i++) {
					System.out.println(검색결과출력용리스트.get(i).get매출금액()+"원");
				}
			}

			
		}
	}
}
