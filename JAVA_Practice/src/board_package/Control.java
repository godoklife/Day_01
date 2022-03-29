package board_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Control {
	
	ArrayList<Model_Member> model_Members = new ArrayList<>();
	ArrayList<Model_Board>model_Boards = new ArrayList<>();
	LinkedList<Model_Reply>model_Replies = new LinkedList<>();
	LocalDateTime ldt = LocalDateTime.now();
	DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("MM.dd");
	int 글번호카운트=0;
	
	
	
	// 1-1 계정 정보 저장
	public void memberSave() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/계정.txt");
			for(Model_Member tmp : model_Members) {
				String stringToSave = tmp.getId()+","+tmp.getPw()+"\n";
				fileOutputStream.write(stringToSave.getBytes());
			}
		} catch (Exception e) {}
	}
	
	// 1-2 계정 파일 읽어들이기
	public void memberLoad() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/계정.txt");
			byte[] byteToLoad = new byte[65536];	//64KB
			fileInputStream.read(byteToLoad);	// 계정.txt를 바이트 배열에 저장
			String tmp = new String(byteToLoad);	// 바이트 배열을 문자열로 바꿔서 저
			String[] tmp2 = tmp.split("\n");	// 줄 단위로 문자열 배열 단위 저장
			
			for(String tmp3 : tmp2) {
				String[] tmp4 = tmp3.split(",");
				System.out.println(tmp4[0]+", "+tmp4[1]);
				model_Members.add(new Model_Member(tmp4[0], tmp4[1]));
			}
					
		} catch (Exception e) {}
	}
	
	//2-1 글 파일 읽어들이기
	public void boardSave() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/게시글.txt");
			for(Model_Board tmp : model_Boards) {
				String stringToSave = tmp.getId()+","+tmp.getPw()+","+tmp.getTitle()+","+tmp.getNum()+","+
				tmp.getViewcount()+","+tmp.getContents()+","+tmp.getSubmitDateTime()+"\n";
				fileOutputStream.write(stringToSave.getBytes());
			}
		} catch (Exception e) {}
	}
	
	// 2-2 글 파일 읽어들이기
	public void boardLoad() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/게시글.txt");
			byte[] byteToLoad = new byte[65536];	//64KB
			fileInputStream.read(byteToLoad);	// 계정.txt를 바이트 배열에 저장
			String tmp = new String(byteToLoad);	// 바이트 배열을 문자열로 바꿔서 저
			String[] tmp2 = tmp.split("\n");	// 줄 단위로 문자열 배열 단위 저장
			
			for(String tmp3 : tmp2) {
				String[] tmp4 = tmp3.split(",");
				model_Boards.add(new Model_Board(tmp4[0], tmp4[1], tmp4[2], Integer.parseInt(tmp4[3]), 
						Integer.parseInt(tmp4[4]), tmp4[5], tmp4[6]));
			}
		} catch (Exception e) {}
	}
	
	// 리플은 아직 미완성.
	
	
	// 1. 회원가입
	public byte join (String id, String pw) {
		// 아이디 조건 충족 여부 검사 시작
		if(id.length()<5 || id.length() > 16) {
			return 1;	// 아이디 글자수가 5자 미만이거나 16자 초과인 경우 1을 리턴
		}
		char[] tmp1 = new char[id.length()];	// 아이디 글자수 만큼의 길이를 가진 char 배열을 선언
		for(Model_Member tmp : model_Members) {	// 중복검사 반복문을 따로 돌려야 하나?? 시간날때 수정하자
			if(tmp.getId().equals(id)){
				return 5;
			}
		}
		for(int i=0; i<id.length(); i++) {
			tmp1[i]=id.charAt(i);
			if(tmp1[i] < 0x41 || (0x5A < tmp1[i] && tmp1[i] < 0x61) || tmp1[i] > 0x7A) {
					// A~Z 가 아니거나 a~z가 아닌지 검사해서
				return 2;	// 아이디에 영어 소문자나 영어 대문자가 아닌게 들어간 경우 2을 리턴
			}
		}	// 아이디 조건 충족 여부 검사 종료
		// 비밀번호 조건 충족 여부 검사 시작
		if(pw.length()<5 || pw.length() > 16) return 3;	// 비번 글자수 5자 미만 또는 16자 초과 여부 확인
		tmp1 = new char[pw.length()];
		boolean pwCheck=false;	// 반복문 끝나고도 false이면 가입 실패 처리
		
		for(int i=0; i<pw.length(); i++) {	// 비번에 숫자가 있는지 검사하는 반복문
			tmp1[i] = pw.charAt(i);
			if(0x30 < tmp1[i] && tmp1[i] < 0x39) pwCheck = true;
		}
		if (pwCheck==false) return 4;	// 비번에 숫자가 없음.
		model_Members.add(new Model_Member(id, pw));	// 리스트 객체에 추가.
		memberSave();	// txt파일로 내보내기
		return 0;	// 정상적으로 가입 성공시 0 리턴
	}	// join END
	
	// 2. 로그인
	public boolean login (String id, String pw) {
		for(Model_Member tmp : model_Members) {
			if(tmp.getId().equals(id) && tmp.getPw().equals(pw))
				return true;
		}
		return false;
	}
	
	// 3. 글쓰기
	public void write(String id, String pw, String title, String content) {
		글번호카운트++;
		model_Boards.add(new Model_Board(id, pw, title, 글번호카운트, 0, content, ldt.format(yearFormat)));
		boardSave();
	}
	
}	// c e
