import java.util.*;


public class IteratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> l=new ArrayList<String>();
		l.add("a");
		l.add("cc");
		l.add("a23");
		l.add("sh");
		l.add("9o0s");
		iterator(l);
		
		System.out.println("--------------------------------");
		Set<String> set=new HashSet<String>();
		set.add("a");
		set.add("cc");
		set.add("a23");
		set.add("sh");
		set.add("9o0s");
		iterator(set);
	}

	public static void iterator(Collection<String> c){
		Iterator<String> iter=c.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
