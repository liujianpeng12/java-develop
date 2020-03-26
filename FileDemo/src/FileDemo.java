import java.io.File;
import java.io.IOException;

public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("D:" + File.separator + "JAVA" + File.separator
				+ "text.txt");
		if (!file.exists()) {
			try {
				boolean b = file.createNewFile();
				System.out.println("创建文件:" + b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			File newDir = new File("D:\\JAVA\\Test1");
			boolean bNew = newDir.mkdir();
			System.out.println("创建文件夹:" + bNew);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
