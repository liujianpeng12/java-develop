import java.io.*;

public class WriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Writer();
	}

	private static void Writer() {
		try {
			Writer out = new FileWriter("D:\\JAVA\\text.txt", true);
			String info="good good study,day day up!好好学习天天向上!";
			//out.write(info.toCharArray());
			out.write(info);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
