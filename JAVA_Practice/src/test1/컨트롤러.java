package test1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ��Ʈ�ѷ� {
	
	public static ArrayList<����> �Ѹ������帮��Ʈ = new ArrayList<>();
	
	// �������� ��ü������ ���� �� �μ��� ���� ����ݰ� ���� ����Ʈ�� �����ϴ� �޼���
	public void ����ݴ���(int �����) {
		int ����ݾ� = �����;
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yy��");
		String ���� = dateformat.format(date);
		dateformat = new SimpleDateFormat("M��");	// 03�� : 3��, 12�� : 12��
		String �� = dateformat.format(date);
		dateformat = new SimpleDateFormat("d��");
		String ��¥ = dateformat.format(date);
		���� ����ݴ��� = new ����(����ݾ�, ��¥, ��, ����);
		�Ѹ������帮��Ʈ.add(����ݴ���);
		������������();
	}
	
	// �ֿܼ��� �Է¹��� ������ ���� �������� ���� ���⳻���� ArrayList�� ����
	public static ArrayList<����> �������(int ����, int ��) {	
		ArrayList<����> ���ϸ��� = new ArrayList<>();
		
		String ã������ = ����+"��";	
		String ã���� = ��+"��";	
		
		for(���� tmp : �Ѹ������帮��Ʈ) {	
			// ��� ��¥�� ����ݾ��� �ִ� �Ѹ������帮��Ʈ���� �Է¹��� ��, ���� ���⸸ �� ���ͼ� ���ϸ��� ����Ʈ�� �ݾװ� ��¥ ����
			if(tmp.get����().contains(ã������) && tmp.get��().contains(ã����)) {	
				���� �ӽð�ü = new ����(tmp.get����ݾ�(), tmp.get��¥());
				���ϸ���.add(�ӽð�ü);
			}
		}
		System.out.println();
		for(int i=0; i<���ϸ���.size(); i++) {
			
			String tmp="";	// null ������ �������Ϳ��������� �׳� �������� �ʱ�ȭ
			int �ӽø��⴩��=0;
			tmp = ���ϸ���.get(i).get��¥();
			for(int j=i; j<���ϸ���.size(); j++) {
				if(tmp.equals(���ϸ���.get(j).get��¥())) {
					�ӽø��⴩�� += ���ϸ���.get(j).get����ݾ�();
					���ϸ���.get(j).set����ݾ�(0);
				}
			}
			���ϸ���.get(i).set����ݾ�(�ӽø��⴩��);
		}
		
		for(int i=0; i<���ϸ���.size(); i++){	// ���� Ŭ������ ������ �˻���� ����Ʈ���� ����ݾ��� 0���� �ε��� ���� �ݺ���
			if(���ϸ���.get(���ϸ���.size()-1).get����ݾ�()==0) {	// ���ϸ����� ���� �� �ε������� 0������ Ȯ��
				���ϸ���.remove(���ϸ���.size()-1);
			}
		}
		
		���ϸ���.remove(���ϸ���.size()-1);	// ������ �𸣰ڴµ� 0���� �ε����� �ϳ��� ����. �����ϴ� ����. �� ������ Ȯ���ʿ�
		return ���ϸ���;
	}
	
	// txt���Ͽ��� java�� �о���̴� �޼���
	public void �������Ϸε�() {
		try {	// FileInputStream ������ �Ϲݿ��� �߻�
			FileInputStream fileInputStream = new FileInputStream("D:/java/���������.txt");
			byte[] �ӽù���Ʈ�迭 = new byte[4096];	// �˳��ϰ� 4KB¥�� �ӽ������ ����Ʈ�� �迭 ����
			fileInputStream.read(�ӽù���Ʈ�迭);	// ���������.txt ���� �о���� ���� ����Ʈ�� �迭�� ����
			String ���ϳ��� = new String(�ӽù���Ʈ�迭);	// ����Ʈ�迭-> ���ڿ��� �̵�
			
			String[] ���ϳ���迭 = ���ϳ���.split("\n");	
			
			for(String tmp : ���ϳ���迭) {
				String[] �ӽù迭 = tmp.split(",");
					���� ���� = new ����(Integer.parseInt(�ӽù迭[0]), �ӽù迭[1], �ӽù迭[2], �ӽù迭[3]);
					�Ѹ������帮��Ʈ.add(����);	// �Ѹ������帮��Ʈ ����Ʈ�� ����.
			}
		} catch (Exception e) { }
	}	// �������Ϸε� �޼��� END
	
	public void �׽�Ʈ���ϰ����() {
		for(���� tmp : �Ѹ������帮��Ʈ)
			System.out.println(tmp.get����ݾ�()+"��"+tmp.get��¥()+tmp.get��()+tmp.get����());
	}
	
	// java���� txt���Ϸ� �������� �޼���
	public void ������������() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/���������.txt");	// 1. ���� ��� ��ü ����
			for(���� tmp : �Ѹ������帮��Ʈ) {
				String �������Ͽ������ڿ� = tmp.get����ݾ�() + "," + tmp.get��¥() + "," + tmp.get��() + "," + tmp.get����() + "\n";
				fileOutputStream.write(�������Ͽ������ڿ�.getBytes());
			}
		}catch(Exception e) {System.out.println("������������ �޼��� ���� �߻�");}
	}	// ������������ END
}