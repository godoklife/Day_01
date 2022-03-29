package test1;

import java.util.ArrayList;

public class test3 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(5);
		list.add("5");
		int i=(int)list.get(0);
		String a=(String)list.get(1);
		System.out.println(i);
		System.out.println(a);
		
	}
}
