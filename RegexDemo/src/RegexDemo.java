
/**
 * 正则表达式
 * @author Administrator
 *
 */
public class RegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "1232821";
		fun1(str);
		//使用正则表达式
		fun2(str);
	}

	private static void fun1(String str) {
		boolean flag = true;
		char[] chars = str.toCharArray();
		for (char c : chars) {
			if (c < '0' || c > '9') {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println(str + " 全是数字.");
		} else {
			System.out.println(str + " 不全是数字.");
		}
	}
	
	private static void fun2(String str){
		if (str.matches("\\d+")) {
			System.out.println(str + " 全是数字.");
		} else {
			System.out.println(str + " 不全是数字.");
		}
	}
}
