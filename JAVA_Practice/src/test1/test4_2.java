package test1;

public class test4_2 {
	// 1. 필드
		private t t;	// super class [ 최상위 클래스 ]
		// 2. 생성자
		// 안 만들면 컴파일러가 알아서 기본생성자 만듦
		
		// 3. 메서드
		public t get() {
			return this.t;
		}
		
		public void set(t t) {
			System.out.println("test");
			this.t = t;
		}
		
}
