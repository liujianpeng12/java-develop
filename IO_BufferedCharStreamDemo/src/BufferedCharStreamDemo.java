
import java.io.*;

public class BufferedCharStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		writer();
		reader();
	}
	
	private static void writer(){
		try {
			Writer w=new FileWriter("D:\\JAVA\\text.txt");
			BufferedWriter bw=new BufferedWriter(w);
			
			bw.write("good good study,day day up! 天天向上2!");
			bw.flush();
			
			bw.close();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private static void reader(){
		try {
			Reader r=new FileReader("D:\\JAVA\\text.txt");
			char[] chars=new char[512];
			int len=-1;
			StringBuilder sb=new StringBuilder();
			BufferedReader br=new BufferedReader(r);
			while((len=br.read(chars))!=-1){
				sb.append(new String(chars,0,len));
			}
			
			br.close();
			r.close();
			
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
