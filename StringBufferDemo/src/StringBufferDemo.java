
public class StringBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="123";
		//默认字符数组的大小为16
		//同步的,多线程访问时安全
		StringBuffer sb=new StringBuffer();
		sb.append("456789");
		System.out.println(sb.toString());
		
		//StringBilder与 StringBuffer兼容,但比StringBuffer快,优先采用StringBuilder
		//非同步的,多线程访问时不安全,单线程时使用效率更高
		StringBuilder sbl=new StringBuilder();
		sbl.append("abc").append("def");
		System.out.println(sbl.toString());
		
		String sb2 = new String(new byte[]{'2','3'});
		System.out.println(sb2);
		
		long l1 = Long.parseLong(sb2);
		System.out.println(l1);
		
		byte b1 = (byte)333;
		System.out.println(b1);
	}

}
