
/**
 * 豆浆：具体的被装饰者对象
 * @author Administrator
 *
 */
public class SoyaBeanMilk implements Drink {

	@Override
	public String description() {
		return "纯豆浆";
	}

	@Override
	public float cost() {
		return 5.0f;
	}

}
