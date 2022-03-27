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
				System.out.println("-----------------------���� ��Ȳ ǥ-----------------------");
				System.out.println("");
				System.out.println("\t\t����ð� : "+nowDateTime.format(dateTimeFormatter));
				
				System.out.print(" ��¥\t\t������ȣ\t\t�����ð�\t\t�����ð�\t\t�ݾ�\n\n");
				
				for(Parking tmp : controller.parkingList) {
					if(tmp.getOuttime()==null)
						System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\n",tmp.getDate(), tmp.getCarNum(), tmp.getIntime().format(timeForamtter), "������", "-");
					else if(tmp.getOuttime()!=null)
						System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\n", tmp.getDate(), tmp.getCarNum(), tmp.getIntime().format(timeForamtter),
								tmp.getOuttime().format(timeForamtter), decimalFormat.format(tmp.getPay()));
				}
				
				System.out.print("--------------------------------------------------------\n\n");
				System.out.print("\t\t\t1. ����\t2. ����\n");
				String ch = scanner.next();
				
				if(ch.equals("1")) {
					System.out.println("������ȣ�� �Է��Ͻÿ�.	");
					String carNum = scanner.next();
					boolean isParked = controller.carIn(carNum);
					if(isParked)
						System.out.println("���������� �����Ǿ����ϴ�.");
					else 
						System.out.println("�ߺ��� ������ȣ �Դϴ�.");
				}
				
				else if(ch.equals("2")) {
					System.out.println("�����Ͻ� ���� ��ȣ�� �Է��Ͻÿ�.");
					String carNum = scanner.next();
					int carOutResult = controller.carOut(carNum);
					
					if (carOutResult>0)
						System.out.println("�����Ͻ� �ݾ��� "+carOutResult+"�� �Դϴ�.");
					else if(carOutResult==0)
						System.out.println("�����Ͻ� �ݾ��� �����ϴ�.");
					else if(carOutResult<0)
						System.out.println("�����߻�. �����ڿ��� �����Ͻÿ�.");
					
				}else
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				
			} catch (Exception e) {System.out.println(e);}
		}	// while END
	}	// main END
}	// class END
