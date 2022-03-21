package exam_practice2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Body {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Parking> parkingList = new ArrayList<>();
		
		while(true) {
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
				String nowtime = simpleDateFormat.format(parkingList.get(0).getCalendar().getTime());
				System.out.println("-----------------------주차 현황 표-----------------------");
				System.out.println("");
				System.out.println("\t\t현재시간 : "+nowtime);
				for(int i=0; i<2; i++) {
					
				}
				System.out.print("\t\t\t1. 입차\t2. 출차\n");
				int ch = scanner.nextInt();
				
				
			} catch (Exception e) {System.out.println(e);}
		}	// while END
	}	// main END
}	// class END
