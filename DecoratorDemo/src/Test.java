/**
 * 装饰者设计模式
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		// 生成豆浆
		Drink soya = new SoyaBeanMilk();
		// 豆浆加糖
		SugarDecorator sugarSoya = new SugarDecorator(soya);
		// 豆浆加黑豆
		BlackBeanDecorator blackSugarSoya = new BlackBeanDecorator(sugarSoya);
		// 豆浆加鸡蛋
		EggDecorator eggBlackSugarSoya = new EggDecorator(blackSugarSoya);

		// 结账
		System.out.println(eggBlackSugarSoya.description());
		System.out.println("需付 " + eggBlackSugarSoya.cost() + " 元");
	}
}
