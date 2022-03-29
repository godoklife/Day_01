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
	int �۹�ȣī��Ʈ=0;
	
	
	
	// 1-1 ���� ���� ����
	public void memberSave() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/����.txt");
			for(Model_Member tmp : model_Members) {
				String stringToSave = tmp.getId()+","+tmp.getPw()+"\n";
				fileOutputStream.write(stringToSave.getBytes());
			}
		} catch (Exception e) {}
	}
	
	// 1-2 ���� ���� �о���̱�
	public void memberLoad() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/����.txt");
			byte[] byteToLoad = new byte[65536];	//64KB
			fileInputStream.read(byteToLoad);	// ����.txt�� ����Ʈ �迭�� ����
			String tmp = new String(byteToLoad);	// ����Ʈ �迭�� ���ڿ��� �ٲ㼭 ��
			String[] tmp2 = tmp.split("\n");	// �� ������ ���ڿ� �迭 ���� ����
			
			for(String tmp3 : tmp2) {
				String[] tmp4 = tmp3.split(",");
				System.out.println(tmp4[0]+", "+tmp4[1]);
				model_Members.add(new Model_Member(tmp4[0], tmp4[1]));
			}
					
		} catch (Exception e) {}
	}
	
	//2-1 �� ���� �о���̱�
	public void boardSave() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/�Խñ�.txt");
			for(Model_Board tmp : model_Boards) {
				String stringToSave = tmp.getId()+","+tmp.getPw()+","+tmp.getTitle()+","+tmp.getNum()+","+
				tmp.getViewcount()+","+tmp.getContents()+","+tmp.getSubmitDateTime()+"\n";
				fileOutputStream.write(stringToSave.getBytes());
			}
		} catch (Exception e) {}
	}
	
	// 2-2 �� ���� �о���̱�
	public void boardLoad() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/�Խñ�.txt");
			byte[] byteToLoad = new byte[65536];	//64KB
			fileInputStream.read(byteToLoad);	// ����.txt�� ����Ʈ �迭�� ����
			String tmp = new String(byteToLoad);	// ����Ʈ �迭�� ���ڿ��� �ٲ㼭 ��
			String[] tmp2 = tmp.split("\n");	// �� ������ ���ڿ� �迭 ���� ����
			
			for(String tmp3 : tmp2) {
				String[] tmp4 = tmp3.split(",");
				model_Boards.add(new Model_Board(tmp4[0], tmp4[1], tmp4[2], Integer.parseInt(tmp4[3]), 
						Integer.parseInt(tmp4[4]), tmp4[5], tmp4[6]));
			}
		} catch (Exception e) {}
	}
	
	// ������ ���� �̿ϼ�.
	
	
	// 1. ȸ������
	public byte join (String id, String pw) {
		// ���̵� ���� ���� ���� �˻� ����
		if(id.length()<5 || id.length() > 16) {
			return 1;	// ���̵� ���ڼ��� 5�� �̸��̰ų� 16�� �ʰ��� ��� 1�� ����
		}
		char[] tmp1 = new char[id.length()];	// ���̵� ���ڼ� ��ŭ�� ���̸� ���� char �迭�� ����
		for(Model_Member tmp : model_Members) {	// �ߺ��˻� �ݺ����� ���� ������ �ϳ�?? �ð����� ��������
			if(tmp.getId().equals(id)){
				return 5;
			}
		}
		for(int i=0; i<id.length(); i++) {
			tmp1[i]=id.charAt(i);
			if(tmp1[i] < 0x41 || (0x5A < tmp1[i] && tmp1[i] < 0x61) || tmp1[i] > 0x7A) {
					// A~Z �� �ƴϰų� a~z�� �ƴ��� �˻��ؼ�
				return 2;	// ���̵� ���� �ҹ��ڳ� ���� �빮�ڰ� �ƴѰ� �� ��� 2�� ����
			}
		}	// ���̵� ���� ���� ���� �˻� ����
		// ��й�ȣ ���� ���� ���� �˻� ����
		if(pw.length()<5 || pw.length() > 16) return 3;	// ��� ���ڼ� 5�� �̸� �Ǵ� 16�� �ʰ� ���� Ȯ��
		tmp1 = new char[pw.length()];
		boolean pwCheck=false;	// �ݺ��� ������ false�̸� ���� ���� ó��
		
		for(int i=0; i<pw.length(); i++) {	// ����� ���ڰ� �ִ��� �˻��ϴ� �ݺ���
			tmp1[i] = pw.charAt(i);
			if(0x30 < tmp1[i] && tmp1[i] < 0x39) pwCheck = true;
		}
		if (pwCheck==false) return 4;	// ����� ���ڰ� ����.
		model_Members.add(new Model_Member(id, pw));	// ����Ʈ ��ü�� �߰�.
		memberSave();	// txt���Ϸ� ��������
		return 0;	// ���������� ���� ������ 0 ����
	}	// join END
	
	// 2. �α���
	public boolean login (String id, String pw) {
		for(Model_Member tmp : model_Members) {
			if(tmp.getId().equals(id) && tmp.getPw().equals(pw))
				return true;
		}
		return false;
	}
	
	// 3. �۾���
	public void write(String id, String pw, String title, String content) {
		�۹�ȣī��Ʈ++;
		model_Boards.add(new Model_Board(id, pw, title, �۹�ȣī��Ʈ, 0, content, ldt.format(yearFormat)));
		boardSave();
	}
	
}	// c e
