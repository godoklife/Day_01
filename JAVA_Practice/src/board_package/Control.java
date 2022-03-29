package board_package;

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
	
	// 1. ȸ������
	public byte join (String id, String pw) {
		// ���̵� ���� ���� ���� �˻� ����
		if(id.length()<5 || id.length() > 16) {
			return 1;	// ���̵� ���ڼ��� 5�� �̸��̰ų� 16�� �ʰ��� ��� 1�� ����
		}
		char[] tmp1 = new char[id.length()];	// ���̵� ���ڼ� ��ŭ�� ���̸� ���� char �迭�� ����
		
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
	}
	
}	// c e
