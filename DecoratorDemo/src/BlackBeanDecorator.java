/**
 * 黑豆：具体装饰者对象
 * 
 * @author Administrator
 * 
 */
public class BlackBeanDecorator extends Decorator {

	public BlackBeanDecorator(Drink drink) {
		super(drink);
	}

	@Override
	public String description() {
		return super.description() + "+黑豆";
	}

	@Override
	public float cost() {
		return super.cost() + 1.5f;
	}
}
