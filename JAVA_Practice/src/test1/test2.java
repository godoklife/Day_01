package test1;

public class test2 {
	public static void main(String[] args) {
		String test="21��";
		test = test.replace("��", "");
		System.out.println(test);
		int i=Integer.parseInt(test);
		
		System.out.println(i);
		
	}
}
