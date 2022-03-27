package exam_practice2;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Body {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LocalDateTime nowDateTime = LocalDateTime.now();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter timeForamtter = DateTimeFormatter.ofPattern("HH:mm");
		Controller controller = new Controller();
		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
		
		while(true) {
			try {
//				String nowtime = simpleDateFormat.format(controller.pakringList.get(0).getCalendar().getTime());
				System.out.println("-----------------------주차 현황 표-----------------------");
				System.out.println("");
				System.out.println("\t\t현재시간 : "+nowDateTime.format(dateTimeFormatter));
				
				System.out.print(" 날짜\t\t차량번호\t\t입차시간\t\t출차시간\t\t금액\n\n");
				
				for(Parking tmp : controller.parkingList) {
					if(tmp.getOuttime()==null)
						System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\n",tmp.getDate(), tmp.getCarNum(), tmp.getIntime().format(timeForamtter), "주차중", "-");
					else if(tmp.getOuttime()!=null)
						System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\n", tmp.getDate(), tmp.getCarNum(), tmp.getIntime().format(timeForamtter),
								tmp.getOuttime().format(timeForamtter), decimalFormat.format(tmp.getPay()));
				}
				
				System.out.print("--------------------------------------------------------\n\n");
				System.out.print("\t\t\t1. 입차\t2. 출차\n");
				String ch = scanner.next();
				
				if(ch.equals("1")) {
					System.out.println("차량번호를 입력하시오.	");
					String carNum = scanner.next();
					boolean isParked = controller.carIn(carNum);
					if(isParked)
						System.out.println("정상적으로 주차되었습니다.");
					else 
						System.out.println("중복된 차량번호 입니다.");
				}
				
				else if(ch.equals("2")) {
					System.out.println("출차하실 차랑 번호를 입력하시오.");
					String carNum = scanner.next();
					int carOutResult = controller.carOut(carNum);
					
					if (carOutResult>0)
						System.out.println("정산하실 금액은 "+carOutResult+"원 입니다.");
					else if(carOutResult==0)
						System.out.println("정산하실 금액은 없습니다.");
					else if(carOutResult<0)
						System.out.println("에러발생. 관리자에게 문의하시오.");
					
				}else
					System.out.println("잘못 입력하셨습니다.");
				
			} catch (Exception e) {System.out.println(e);}
		}	// while END
	}	// main END
}	// class END
