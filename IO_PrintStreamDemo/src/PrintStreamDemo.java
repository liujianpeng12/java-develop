
import java.io.*;

public class PrintStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print();
	}

	private static void print(){
		try {
			OutputStream out=new FileOutputStream("D:\\JAVA\\text.txt");
			BufferedOutputStream bos=new BufferedOutputStream(out);
			PrintStream ps=new PrintStream(bos);
			
			ps.println("×Ö·û´®");
			ps.println(123);
			ps.println(false);
			ps.println(3.14f);
			ps.flush();
			
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
