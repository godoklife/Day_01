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
					String tmp="";	// null ������ �������Ϳ��������� �׳� ���� ����.
					int �ӽø��⴩��=0;
					tmp = �˻������¿븮��Ʈ.get(i).get��¥();
					for(int j=0; j<�˻������¿븮��Ʈ.size(); j++) {
						if(tmp.equals(�˻������¿븮��Ʈ.get(j).get��¥())) {
							�ӽø��⴩�� += �˻������¿븮��Ʈ.get(j).get����ݾ�();
							�˻������¿븮��Ʈ.get(j).set����ݾ�(0);
						}
					}
					�˻������¿븮��Ʈ.get(i).set����ݾ�(�ӽø��⴩��);
				}
				
				
				for(���� tmp : �˻������¿븮��Ʈ) {
					if(tmp.get����ݾ�()!=0){
						System.out.printf("%d�� %2d�� %s�� ���� : %s��\n", year, month, tmp.get��¥(), tmp.get����ݾ�());
					}else {
						System.out.println("�Է��Ͻ� ��¥���� ������ �����ϴ�.");
					}
				}
				
			}	
		}
	}
}
