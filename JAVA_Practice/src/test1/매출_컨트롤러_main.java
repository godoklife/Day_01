package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class ����_��Ʈ�ѷ�_main {
	public static void main(String[] args) {
		��Ʈ�ѷ� ������Ʈ�ѷ� = new ��Ʈ�ѷ�();
		
		Scanner scanner = new Scanner(System.in);
		������Ʈ�ѷ�.�������Ϸε�();
			
		while(true) {
			System.out.println("1. ����������ݾ� �Է� | 2. �˻�\n�Է� : ");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("��������ݾ� �Է�");
				int pay = scanner.nextInt();
				������Ʈ�ѷ�.����ݴ���(pay);
			}else if(ch==2) {
				System.out.println("���� �Է�\n�Է¿���)2022�� : 22)");
				int year = scanner.nextInt();
				System.out.println("�� �Է�\n�Է¿���)03�� : 3");
				int month = scanner.nextInt();
				ArrayList<����> �˻������¿븮��Ʈ =  new ArrayList<>(������Ʈ�ѷ�.�������(year, month));
				for(int i=0; i<�˻������¿븮��Ʈ.size(); i++) {
					System.out.println(�˻������¿븮��Ʈ.get(i).get����ݾ�()+"��");
				}
			}

			
		}
	}
}
