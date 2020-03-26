
//适合器模式
public class AdapterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerA powerA=new PowerAImpl();
		start(powerA);
		
		//PowerB powerB=new PowerBImpl();
		//start(powerB);
		
		PowerB powerB=new PowerBImpl();
		PowerAAdapter adapterA=new PowerAAdapter(powerB);
		start(adapterA);
	}
	public static void start(PowerA p){
		//其他操作...
		p.insert();
		//其他操作...
	}
	/*
	public static void start(PowerB p){
		//其他操作...
		p.connect();
		//其他操作...
	}*/

}
//适合器
class PowerAAdapter implements PowerA{
	private PowerB powerB;
	public PowerAAdapter(PowerB p){
		powerB=p;
	}
	public void insert(){
		powerB.connect();
	}
}

interface PowerA{
	void insert();
}
class PowerAImpl implements PowerA{
	public void insert(){
		System.out.println("insert");
	}
}

interface PowerB{
	void connect();
}
class PowerBImpl implements PowerB{
	public void connect(){
		System.out.println("connect");
	}
}

