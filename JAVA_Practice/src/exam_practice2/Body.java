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
				System.out.println("-----------------------���� ��Ȳ ǥ-----------------------");
				System.out.println("");
				System.out.println("\t\t����ð� : "+nowtime);
				for(int i=0; i<2; i++) {
					
				}
				System.out.print("\t\t\t1. ����\t2. ����\n");
				int ch = scanner.nextInt();
				
				
			} catch (Exception e) {System.out.println(e);}
		}	// while END
	}	// main END
}	// class END
