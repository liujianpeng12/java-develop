import java.io.*;

public class ConvertStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		writer();
		reader();
	}

	//字符输出流转换成字节输出流:字符->转成字节流->文件
	private static void writer() {
		try {
			OutputStream out = new FileOutputStream("D:\\JAVA\\text.txt");
			String info = "公元 2014-06-11 ";
			//通过字节输出流构造字符输出流
			Writer writer = new OutputStreamWriter(out);
			writer.write(info);

			writer.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//字节输入流转换成字符输入流:文件->转成字符流->程序
	private static void reader() {
		try {
			InputStream in = new FileInputStream("D:\\JAVA\\text.txt");
			//通过字节输入流构造字符输入流
			Reader reader = new InputStreamReader(in);
			
			char[] chars = new char[7];
			int len = -1;
			StringBuilder sb = new StringBuilder();
			while ((len = reader.read(chars)) != -1) {
				sb.append(new String(chars, 0, len));
			}

			in.close();
			reader.close();

			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
