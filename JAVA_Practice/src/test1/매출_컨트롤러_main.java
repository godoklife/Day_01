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
					String tmp="";	// null 넣으면 널포인터에러때문에 그냥 공백 저장.
					int 임시매출누적=0;
					tmp = 검색결과출력용리스트.get(i).get날짜();
					for(int j=0; j<검색결과출력용리스트.size(); j++) {
						if(tmp.equals(검색결과출력용리스트.get(j).get날짜())) {
							임시매출누적 += 검색결과출력용리스트.get(j).get매출금액();
							검색결과출력용리스트.get(j).set매출금액(0);
						}
					}
					검색결과출력용리스트.get(i).set매출금액(임시매출누적);
				}
				
				
				for(매출 tmp : 검색결과출력용리스트) {
					if(tmp.get매출금액()!=0){
						System.out.printf("%d년 %2d월 %s일 매출 : %s원\n", year, month, tmp.get날짜(), tmp.get매출금액());
					}else {
						System.out.println("입력하신 날짜에는 매출이 없습니다.");
					}
				}
				
			}	
		}
	}
}
