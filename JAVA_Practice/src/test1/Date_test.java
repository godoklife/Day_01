package test1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Date_test {
	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy��");
		
		String year = dateFormat.format(date);
		System.out.println(year);
		
		dateFormat = new SimpleDateFormat("M��");
		String month = dateFormat.format(date);
		System.out.println(month);
		
		dateFormat = new SimpleDateFormat("d��");
		String day = dateFormat.format(date);
		System.out.println(day);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("�Է� : ");
		
		String input = scanner.next()+"��";
		
		if(month.equals(input))
			System.out.println("�����ϴ�.");
		else
			System.out.println("���� �ʽ��ϴ�");
		
		
	}
}
