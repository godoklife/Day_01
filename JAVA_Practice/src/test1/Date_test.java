package test1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Date_test {
	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy년");
		
		String year = dateFormat.format(date);
		System.out.println(year);
		
		dateFormat = new SimpleDateFormat("M월");
		String month = dateFormat.format(date);
		System.out.println(month);
		
		dateFormat = new SimpleDateFormat("d일");
		String day = dateFormat.format(date);
		System.out.println(day);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력 : ");
		
		String input = scanner.next()+"월";
		
		if(month.equals(input))
			System.out.println("같습니다.");
		else
			System.out.println("같지 않습니다");
		
		
	}
}
