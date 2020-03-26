
public class AssertDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=10;
		
		assert x!=10:"输出结果不正确.";//断言,需配置vm参数 -ea: java -ea AssertDemo
	}

}
