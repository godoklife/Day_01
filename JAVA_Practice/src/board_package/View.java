package board_package;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Control con = new Control();
		con.memberLoad();
		con.boardLoad();
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
				 * 5 : ���̵� �ߺ�
				 */
				if(joinResult==0) System.out.println(newID+" ���� ������ ȯ���մϴ�.");
				else if(joinResult==1) System.out.println("���̵� ���ڼ��� Ȯ���ϼ���");
				else if(joinResult==2) System.out.println("���̵𿡴� ������ ���˴ϴ�.");
				else if(joinResult==3) System.out.println("��й�ȣ ���ڼ��� Ȯ���ϼ���");
				else if(joinResult==4) System.out.println("��й�ȣ���� ���ڰ� ���ԵǾ�߸� �մϴ�.");
				else if(joinResult==5) System.out.println("�ش� ���̵�� �̹� �ֽ��ϴ�.");
				
			}else if(ch.equals("2")) {	// �α��� �Ŵ�
				System.out.println("���̵� �Է��ϼ���"); String id = scanner.next();
				System.out.println("��й�ȣ�� �Է��ϼ���"); String pw = scanner.next();
				boolean loginResult = con.login(id, pw);
				
				if(loginResult) {	// �α��� ������ �Խ������� ����
					System.out.println(id+" �� ȯ���մϴ�.");
					while(true)	{// �Խ��� �Ŵ� ���ѹݺ�, ���� ���� : 4��, �α׾ƿ�
						System.out.println();
						System.out.println("======================================================");
						System.out.printf("%s\t%s\t\t%s\t\t%s\t%s\n","��ȣ", "�۾���", "����", "�����", "��ȸ��");
						for(Model_Board tmp : con.model_Boards) {
							System.out.printf("%03d\t%s\t%s\t\t%s\t%s\n",tmp.getNum(), tmp.getId(), tmp.getTitle(),
									tmp.getSubmitDateTime(), tmp.getViewcount());
						}
						System.out.println("======================================================");
						System.out.println("1. �۾��� | 2. �� �б� | 3. �� �˻� | 4. �α׾ƿ�" );
						System.out.print("���� >");
						String ch2=scanner.next();
						
						if(ch2.equals("1")) {	// �� ����
							System.out.print("���� : ");
							String newTitle = scanner.next();
							System.out.print("���� : ");
							String newContent = scanner.next();
							con.write(id, pw, newTitle, newContent);
							
							
						}else if(ch2.equals("2")) {	// �� �б�
							System.out.println("�� ��ȣ�� �����ϼ���.");
							System.out.print("���� >");
							String ch3=scanner.next();
//							for()
						}else if(ch2.equals("3")) {
							
						}else if(ch2.equals("4")) {
							System.out.println("�α׾ƿ� �մϴ�.");
							break;
						}else System.out.println("�߸� �����̽��ϴ�.");
					}	// w e
					
				}else System.out.println("���̵�� ��й�ȣ�� Ȯ���ϼ���.");
				
				
			}else System.out.println("�߸� �����ϼ̽��ϴ�.");
		}	// w e
	}	// m e
}	// c e
