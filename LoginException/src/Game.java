import java.util.Scanner;


public class Game {
	
	public void play() throws LogicException{
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.println("input 0 to throws LogicException:");
			int in=input.nextInt();
			if(in==0){
				throw new LogicException("“Ï≥£");
			}
		}
	}
	
	public static void main(String[] args){
		Game g=new Game();
		try {
			g.play();
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
