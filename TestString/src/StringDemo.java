
public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="a1";
		String a1="a"+1;
		System.out.println(a==a1);
		
		String b="b1";
		int bb=1;
		String b1="b"+bb;
		System.out.println(b==b1);
		
		String c="c1";
		final int cc =1;
		String c1="c"+cc;
		System.out.println(c==c1);
		
		String d="d1";
		final int dd=getDD();
		String d1="d"+dd;
		System.out.println(d==d1);
	}
	private static int getDD(){
		return 1;
	}
}
