
public class TestNum {
	//通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		@Override
		public Integer initialValue(){
			return 0;
		}
	};
	
	public static int getNextNum(){
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
}
