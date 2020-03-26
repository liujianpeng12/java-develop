
public class TestClient extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("thread[" + Thread.currentThread().getName() + "]" + TestNum.getNextNum());
		}
	}
}
