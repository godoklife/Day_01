package exam;

import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Student[] student = new Student[100];	// 성적 저장용 클래스형 배열
		int[] rank = new int[100];				// 석차 저정용 정수형 배열
		
		while(true) {	// 성적표 입력 프로그램, 종료조건 : 없음
			try {
			
				
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t\t\t성\t적\t표\t\t");
				System.out.println("-----------------------------------------------------------");
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				System.out.println("-----------------------------------------------------------");
				
				for(int i=0;i<student.length;i++) {
					if(student!=null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\t%d\t", student[i].g);
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
						if(tmp!=null) {
							student[i]=newstudent;
							break;
						}
						i++;
					}
					
					
				}
				else if(ch==2) {
					System.out.println("2번 입력");
				}
				else
					System.out.println("잘못 누르셨습니다.");
					
					
			}	// try END
			catch(Exception e){
				System.out.println("예외발생! 초기매뉴로 돌아갑니다.");
				scanner = new Scanner(System.in);
			}	// catch END
		}	// while END
	}	// main END
}	// class END
