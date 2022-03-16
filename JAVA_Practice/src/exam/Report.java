package exam;

import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Student[] student = new Student[100];	// ���� ����� Ŭ������ �迭
		int[] rank = new int[student.length];				// ���� ������ ������ �迭
		
		while(true) {	// ����ǥ �Է� ���α׷�, �������� : ����
			try {
			
				
				
				
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t\t\t��\t��\tǥ\t\t");
				System.out.println("-----------------------------------------------------------");
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
				System.out.println("-----------------------------------------------------------");
				
				for(int i=0; i<rank.length;i++) {	// ���� �迭 �ʱ�ȭ
					rank[i]=1;
				}
				
				//for(int i=0; )
				
				for(int i=0;i<student.length;i++) {
					if(student[i]!=null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\t\n",student[i].getNum(), student[i].getName(), 
								student[i].getKor(), student[i].getEng(), student[i].getMath(), student[i].getSum(), student[i].getAvg(), rank[i]);
					}
				}
				
				System.out.println("1. ���� �Է� | 2. ���� ����");
				System.out.print("���� >");
				int ch=scanner.nextInt();
				
				if(ch==1) {
					System.out.print("��ȣ : ");
					int num = scanner.nextInt();
					System.out.print("�̸� : ");
					String name = scanner.next();
					System.out.print("�������� : ");
					int kor = scanner.nextInt();
					System.out.print("�������� : ");
					int eng = scanner.nextInt();
					System.out.print("�������� : ");
					int math = scanner.nextInt();
					int sum = kor+eng+math;
					double avg = (kor+eng+math)/3.0;
					Student newstudent = new Student(num, name, kor, eng, math, sum, avg);
					int i=0;
					for(Student tmp : student) {
						if(tmp==null) {
							student[i]=newstudent;
							break;
						}
						i++;
					}
					
					
				}
				else if(ch==2) {
					System.out.print("������ �л� ��ȣ �Է� >");
					int ch2=scanner.nextInt();
					int i=0;	// �ε��� ī��Ʈ�� ����
					boolean thereIsNoNumber = true;
					for(Student tmp : student) {
						if(tmp!=null && tmp.getNum()==ch2) {
							System.out.println(ch2+"�� �л� ���� �Ϸ�.");
							student[i]=null;
							thereIsNoNumber = false;
							break;
						}
						i++;
					}
					if(thereIsNoNumber==true) {
						System.out.println("�������� �ʴ� �л� ��ȣ�Դϴ�.");
					}else {
						for(int j=i; j<student.length;j++) {
							if(j==student.length-1) {	// ���� �� �ε��� �ʱ�ȭ �ϰ� �ݺ��� Ż��
								student[student.length-1] = null;
								break;
							}
							student[j]=student[j+1];
						}
					}
					
				}	// ���� END
				else
					System.out.println("�߸� �����̽��ϴ�.");
					
					
			}	// try END
			catch(Exception e){
				System.out.println("���ܹ߻�! �ʱ�Ŵ��� ���ư��ϴ�.");
				System.out.println(e);
				scanner = new Scanner(System.in);
			}	// catch END
		}	// while END
	}	// main END
}	// class END
