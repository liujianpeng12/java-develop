import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args){

		List<String> list=new ArrayList<String>();
		list.add("2");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");

		remove(list);
		
		for (String string : list) {
			System.out.println(string);
		}
	}

	private static void remove(List<String> list) {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().equals("b")) {
				it.remove();
			}
		}
	}
}
