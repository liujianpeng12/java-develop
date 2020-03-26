import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class ReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		stringReader();
		byteReader();
	}

	private static void stringReader() {
		File f = new File("D:\\JAVA\\text.txt");
		Reader reader;
		try {
			reader = new FileReader(f);
			char[] chars = new char[9];
			int len = -1;
			StringBuilder sb = new StringBuilder();
			while ((len = reader.read(chars)) != -1) {
				sb.append(new String(chars, 0, len));
			}
			reader.close();

			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void byteReader() {
		try {
			InputStream in = new FileInputStream("D:\\JAVA\\text.txt");
			byte[] bytes = new byte[9];// ยาย๋
			int len = -1;
			StringBuilder sb = new StringBuilder();
			while ((len = in.read(bytes)) != -1) {
				sb.append(new String(bytes, 0, len));
			}
			in.close();

			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
