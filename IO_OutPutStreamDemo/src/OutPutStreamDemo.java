import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class OutPutStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testFileOutputStream();
	}

	private static void testFileOutputStream(){
		try {
			OutputStream stream=new FileOutputStream("D:\\Dev\\text.txt");
			String str="Hellow FileOutputStream!文件输出流是用于将数据写入";
			byte[] b=str.getBytes();

			stream.write(b);
//			for (int i = 0; i < b.length; i++) {
//				stream.write(b[i]);
//			}

			stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
