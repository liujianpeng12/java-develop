package intro.core;

public class Adult {
	protected int age;
	protected String name="bir";
	protected String race;
	protected String gender;
	
	public static void main(String[] args) {
		Adult myAdult = new Adult();
		
		System.out.println("Name: " + myAdult.name.concat("9"));
		System.out.println("Age: " + myAdult.age);
		System.out.println("Race: " + myAdult.race);
		System.out.println("Gender: " + myAdult.gender);
	}
}
