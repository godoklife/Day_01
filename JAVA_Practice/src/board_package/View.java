package board_package;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Control con = new Control();
		while(true) {	// �������� : ����
			System.out.println("ȸ���� �Խ���");
			System.out.println("1. ȸ������ 2. �α��� ");
			System.out.print("�Է� >");
			String ch = scanner.next();
			
			if(ch.equals("1")) {	// ȸ������ �Ŵ�
				System.out.println("ȸ������ �Ŵ��Դϴ�.");
				System.out.println("�ű� �����Ͻ� ���̵� �Է��ϼ���.");
				System.out.println("���̵� ���� ��Ģ");
				System.out.println("1. ���� ��ҹ��ڸ� ��� | 2. 5�� �̻�, 16�� ����");
				System.out.print("�Է� >");
				String newID = scanner.next();
				
				System.out.println("��й�ȣ�� �Է��ϼ���.");
				System.out.println("��й�ȣ ���� ��Ģ");
				System.out.println("1. �ϳ� �̻��� ���� ���� | 2. 5�� �̻�, 16�� ����");
				String newPW = scanner.next();
				byte joinResult = con.join(newID, newPW);
				/*
				 * ���ϰ� ����
				 * 0 : ���� ����
				 * 1 : ���̵� ���ڼ� ������
				 * 2 : ���� ��ҹ��� �̿��� ���� ��
				 * 3 : ��� ���ڼ� ������
				 * 4 : �ϳ� �̻��� ���� ������
				 */
				if(joinResult==0) System.out.println(newID+" ���� ������ ȯ���մϴ�.");
				else if(joinResult==1) System.out.println("���̵� ���ڼ��� Ȯ���ϼ���");
				else if(joinResult==2) System.out.println("���̵𿡴� ������ ���˴ϴ�.");
				else if(joinResult==3) System.out.println("��й�ȣ ���ڼ��� Ȯ���ϼ���");
				else if(joinResult==4) System.out.println("��й�ȣ���� ���ڰ� ���ԵǾ�߸� �մϴ�.");
				
			}else if(ch.equals("2")) {	// �α��� �Ŵ�
				System.out.println("���̵� �Է��ϼ���"); String id = scanner.next();
				System.out.println("��й�ȣ�� �Է��ϼ���"); String pw = scanner.next();
				boolean loginResult = con.login(id, pw);
				
				if(loginResult) {	// �α��� ������ �Խ������� ����
					System.out.println(id+" �� ȯ���մϴ�.");
					System.out.println("======================================================");
					System.out.printf("%04d\t\s\t\s\t\s\t\s",con.model_Boards.g);
					
					
					
				}else System.out.println("���̵�� ��й�ȣ�� Ȯ���ϼ���.");
				
				
			}else System.out.println("�߸� �����ϼ̽��ϴ�.");
		}	// w e
	}	// m e
}	// c e
