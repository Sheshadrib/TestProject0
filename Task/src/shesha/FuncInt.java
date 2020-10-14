package shesha;

public class FuncInt {
	
	@FunctionalInterface
	interface methods{
		
		void add();
		
		default void print(int a,int b) {
			
			System.out.println(a+b);
			
		}
	}
	
	public static void main(String[] args) {
		
		FuncInt str = new FuncInt();
		
		String name = "Sheshadri";
		int age=23;
		int phone=12345;
		
		int a=5;
		int b=6;
		
//		String str1="Hello";
//		String str2="Hello";
//		String str3=new String("Hello");
//		
//		System.out.println(str1==str2);
//		System.out.println(str1.equals(str2));
//
//		System.out.println(str1==str3);
//		System.out.println(str1.equals(str3));
		
		methods me = ()-> System.out.println("Addition is ...");
		me.add();
		me.print(a, b);
			}
}
