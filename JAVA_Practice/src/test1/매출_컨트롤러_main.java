package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class ����_��Ʈ�ѷ�_main {
	public static void main(String[] args) {
		��Ʈ�ѷ� ������Ʈ�ѷ� = new ��Ʈ�ѷ�();
		
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		������Ʈ�ѷ�.�������Ϸε�();
		������Ʈ�ѷ�.�׽�Ʈ���ϰ����();
		
		while(true) {
			System.out.println("1. ����������ݾ� �Է� | 2. �˻�");
			System.out.print("�Է� >");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("��������ݾ� �Է�");
				int �����ϸ鼭�����ݾ� = scanner.nextInt();
				������Ʈ�ѷ�.����ݴ���(�����ϸ鼭�����ݾ�);
			}	
			
			// ������ ����ݾ��Է� if�� END @@@ ������Ʈ ���� Ŭ������ ��ĥ�� �����ѵ� ��Ʈ�ѷ� ��ü�� ����ݴ��� ��ü�� �μ����·� �����ָ��
			
			else if(ch==2) {	// ������� �˻��Ŵ����� else if END ���� ������Ʈ ���� Ŭ������ ��ĥ�� �״�� ����
				System.out.println("�˻��� ������ ������ �Է��ϼ���.\n�Է¿���) 2022�� : 22");
				System.out.print("�Է� >");
				int year = scanner.nextInt();
				System.out.println(year+"�⿡�� �˻��� ���� ������ �Է��ϼ���.\n�Է¿���)03�� : 3");
				System.out.print("�Է� >");

				int month = scanner.nextInt();
				ArrayList<����> �˻������¿븮��Ʈ =  new ArrayList<>(������Ʈ�ѷ�.�������(year, month));
				for(���� tmp : �˻������¿븮��Ʈ) {
					System.out.printf("%d�� %2d�� %3s ���� : %s��\n", year, month, tmp.get��¥(), tmp.get����ݾ�());
				}
			}	// �˻��Ŵ����� else if END
		}	// while END
	}	// main END
}	// class END
