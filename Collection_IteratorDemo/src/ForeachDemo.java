import java.util.ArrayList;
import java.util.List;


public class ForeachDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> l=new ArrayList<String>();
		l.add("a");
		l.add("cc");
		l.add("bb");

		for(String s: l){
			System.out.println(s);
		}
	}

}
