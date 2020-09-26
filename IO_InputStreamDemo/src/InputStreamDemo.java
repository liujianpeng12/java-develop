import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testFileInputStream();
		testFileInputStream2();
		testFileInputStream3();
	}

	private static void testFileInputStream() {
		try {
			InputStream input = new FileInputStream("D:\\Dev\\Git.txt");
			int b = -1;
			while ((b = input.read()) != -1) {
				// System.out.println(b);
				System.out.print((char) b);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testFileInputStream2() {
		try {
			File file = new File("D:\\Dev\\Git.txt");
			InputStream input = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			//合适比较小文件
			int len = input.read(bytes);
			input.close();

			System.out.println("");
			System.out.println(new String(bytes));
			System.out.println("len="+len);
			//for (int i = 0; i < bytes.length; i++) {
			//	System.out.print((char) bytes[i]);
			//}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//每次读取指定大小的字节
	private static void testFileInputStream3() {
		try {
			System.out.println("");
			File file = new File("D:\\Dev\\Git.txt");
			InputStream input = new FileInputStream(file);
			byte[] bytes = new byte[7];//汉字为2个字节,单数时为乱码
			int len = -1;//每次读取的实际长度
			StringBuilder sb=new StringBuilder();
			while((len=input.read(bytes))!=-1){
				sb.append(new String(bytes, 0, len));
			}
			System.out.println(sb.toString());
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
