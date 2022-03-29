package board_package;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Control con = new Control();
		while(true) {	// 종료조건 : 없음
			System.out.println("회원제 게시판");
			System.out.println("1. 회원가입 2. 로그인 ");
			System.out.print("입력 >");
			String ch = scanner.next();
			
			if(ch.equals("1")) {	// 회원가입 매뉴
				System.out.println("회원가입 매뉴입니다.");
				System.out.println("신규 생성하실 아이디를 입력하세요.");
				System.out.println("아이디 생성 규칙");
				System.out.println("1. 영문 대소문자만 허용 | 2. 5자 이상, 16자 이하");
				System.out.print("입력 >");
				String newID = scanner.next();
				
				System.out.println("비밀번호를 입력하세요.");
				System.out.println("비밀번호 생성 규칙");
				System.out.println("1. 하나 이상의 숫자 포함 | 2. 5자 이상, 16자 이하");
				String newPW = scanner.next();
				byte joinResult = con.join(newID, newPW);
				/*
				 * 리턴값 정리
				 * 0 : 정상 가입
				 * 1 : 아이디 글자수 부적합
				 * 2 : 영문 대소문자 이외의 문자 들어감
				 * 3 : 비번 글자수 부적합
				 * 4 : 하나 이상의 숫자 미포함
				 */
				if(joinResult==0) System.out.println(newID+" 님의 가입을 환영합니다.");
				else if(joinResult==1) System.out.println("아이디 글자수를 확인하세요");
				else if(joinResult==2) System.out.println("아이디에는 영문만 허용됩니다.");
				else if(joinResult==3) System.out.println("비밀번호 글자수를 확인하세요");
				else if(joinResult==4) System.out.println("비밀번호에는 숫자가 포함되어야만 합니다.");
				
			}else if(ch.equals("2")) {	// 로그인 매뉴
				System.out.println("아이디를 입력하세요"); String id = scanner.next();
				System.out.println("비밀번호를 입력하세요"); String pw = scanner.next();
				boolean loginResult = con.login(id, pw);
				
				if(loginResult) {	// 로그인 성공시 게시판으로 진입
					System.out.println(id+" 님 환영합니다.");
					System.out.println("======================================================");
					System.out.printf("%04d\t\s\t\s\t\s\t\s",con.model_Boards.g);
					
					
					
				}else System.out.println("아이디와 비밀번호를 확인하세요.");
				
				
			}else System.out.println("잘못 선택하셨습니다.");
		}	// w e
	}	// m e
}	// c e
