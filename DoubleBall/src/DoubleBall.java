import java.util.Random;
import java.util.Scanner;

public class DoubleBall {
	public static void main(String[] args){
		int sysBuleBallNumber;
		int[] sysRedBallNumber=new int[6];
		int userBlueBallNumber;
		int[] userRedBallNumber=new int[6];
		
		Random r=new Random();
		Scanner input=new Scanner(System.in);
		
		int[] redNumber={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		
		sysBuleBallNumber=r.nextInt(16)+1;
		
		for(int i=0; i<sysRedBallNumber.length;i++){
			while(true){
				int index=r.nextInt(33);
				if(redNumber[index] != 0){
					sysRedBallNumber[i]=redNumber[index];
					redNumber[index]=0;
					break;
				}
			}
		}
		
		System.out.print("请输入1个蓝色球:");
		userBlueBallNumber=input.nextInt();
		System.out.println("请输入6个红色球 :");
		for(int i=0;i<userRedBallNumber.length;i++){
			userRedBallNumber[i]=input.nextInt();
		}
		
		int blueBall=0;
		int redBall=0;
		if(userBlueBallNumber==sysBuleBallNumber){
			blueBall=1;
		}
		for(int i=0;i<userRedBallNumber.length;i++){
			for(int j=0;j<sysRedBallNumber.length;j++){
				if(userRedBallNumber[i]==sysRedBallNumber[j]){
					redBall++;
					break;
				}
			}
		}
		
		if(blueBall==1&&redBall==6){
			System.out.println("恭喜你,中了一等奖 500万.");
		}else if(redBall==6){
			System.out.println("恭喜你,中了二等奖.");
		}else if(blueBall==1&&redBall==5){
			System.out.println("恭喜你,中了三等奖 3000元.");
		}else if(redBall==5||(blueBall==1&&redBall==4)){
			System.out.println("恭喜你,中了四等奖 200元.");
		}else if(redBall==4||(blueBall==1&&redBall==3)){
			System.out.println("恭喜你,中了五等奖 10元.");
		}else if(blueBall==1){
			System.out.println("恭喜你,中了六等奖 5元.");
		}else{
			System.out.println("很遗憾,您没有中奖.");
		}
		
		int temp;
		System.out.println("本期中奖号码:");
		System.out.println("蓝色球: "+sysBuleBallNumber);
		for(int i=0;i<sysRedBallNumber.length-1;i++){
			for(int j=0;j<sysRedBallNumber.length-i-1;j++){
				if(sysRedBallNumber[j]>sysRedBallNumber[j+1]){
					temp=sysRedBallNumber[j];
					sysRedBallNumber[j]=sysRedBallNumber[j+1];
					sysRedBallNumber[j+1]=temp;
				}
			}
		}
		System.out.print("红色球: ");
		for(int i=0;i<sysRedBallNumber.length;i++){
			System.out.print(sysRedBallNumber[i]+" ");
		}
	}
}
