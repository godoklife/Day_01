package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class ����_��Ʈ�ѷ�_main {
	public static void main(String[] args) {
		��Ʈ�ѷ� ������Ʈ�ѷ� = new ��Ʈ�ѷ�();
		
		Scanner scanner = new Scanner(System.in);
		������Ʈ�ѷ�.�������Ϸε�();
			
		while(true) {
			System.out.println("��������ݾ� �Է�");
			int pay = scanner.nextInt();
			
			������Ʈ�ѷ�.����ݴ���(pay);
			������Ʈ�ѷ�.�׽�Ʈ���ϰ����();
		}
	}
}
