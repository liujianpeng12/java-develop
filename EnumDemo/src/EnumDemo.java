public class EnumDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(EnumColor.Red);
		System.out.println(EnumColor.Red.getColor());
		System.out.println(EnumColor.Green);
		System.out.println(EnumColor.Green.getColor());
		
		System.out.println("---------------------------------");
		System.out.println(Enum1.ON);
		System.out.println(Enum1.OFF);

	}

}

interface IColor{
	String getColor();
}
enum EnumColor implements IColor{
	Red{
		@Override
		public String getColor() {
			return "red color";
		}
	},
	Green{
		public String getColor(){
			return "green color";
		}
	}
}

enum Enum1 {
	ON {
		@Override
		public Enum1 fun() {
			return OFF;
		}
	},
	OFF {
		@Override
		public Enum1 fun() {
			return ON;
		}
	};

	public abstract Enum1 fun();
}