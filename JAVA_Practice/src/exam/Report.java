package exam;

import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Student[] student = new Student[100];	// 성적 저장용 클래스형 배열
		int[] rank = new int[student.length];				// 석차 저정용 정수형 배열
		
		while(true) {	// 성적표 입력 프로그램, 종료조건 : 없음
			try {
			
				
				
				
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t\t\t성\t적\t표\t\t");
				System.out.println("-----------------------------------------------------------");
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				System.out.println("-----------------------------------------------------------");
				
				for(int i=0; i<rank.length;i++) {	// 석차 배열 초기화
					rank[i]=1;
				}
				
				//for(int i=0; )
				
				for(int i=0;i<student.length;i++) {
					if(student[i]!=null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\t\n",student[i].getNum(), student[i].getName(), 
								student[i].getKor(), student[i].getEng(), student[i].getMath(), student[i].getSum(), student[i].getAvg(), rank[i]);
					}
				}
				
				System.out.println("1. 성적 입력 | 2. 성적 삭제");
				System.out.print("선택 >");
				int ch=scanner.nextInt();
				
				if(ch==1) {
					System.out.print("번호 : ");
					int num = scanner.nextInt();
					System.out.print("이름 : ");
					String name = scanner.next();
					System.out.print("국어점수 : ");
					int kor = scanner.nextInt();
					System.out.print("영어점수 : ");
					int eng = scanner.nextInt();
					System.out.print("수학점수 : ");
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
					System.out.print("삭제할 학생 번호 입력 >");
					int ch2=scanner.nextInt();
					int i=0;	// 인덱스 카운트용 변수
					boolean thereIsNoNumber = true;
					for(Student tmp : student) {
						if(tmp!=null && tmp.getNum()==ch2) {
							System.out.println(ch2+"번 학생 삭제 완료.");
							student[i]=null;
							thereIsNoNumber = false;
							break;
						}
						i++;
					}
					if(thereIsNoNumber==true) {
						System.out.println("존재하지 않는 학생 번호입니다.");
					}else {
						for(int j=i; j<student.length;j++) {
							if(j==student.length-1) {	// 가장 끝 인덱스 초기화 하고 반복문 탈출
								student[student.length-1] = null;
								break;
							}
							student[j]=student[j+1];
						}
					}
					
				}	// 삭제 END
				else
					System.out.println("잘못 누르셨습니다.");
					
					
			}	// try END
			catch(Exception e){
				System.out.println("예외발생! 초기매뉴로 돌아갑니다.");
				System.out.println(e);
				scanner = new Scanner(System.in);
			}	// catch END
		}	// while END
	}	// main END
}	// class END
