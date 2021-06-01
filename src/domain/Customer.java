package domain;

public class Customer implements IWaitingCustomer {

	private String name;
	private Drink orderedDrink;
	private boolean isOrderReady;
	
	public Customer(String name, Drink orderedDrink) {
		this.name = name;
		this.orderedDrink = orderedDrink;
		this.setOrderReady(false);
	}

	@Override
	public Drink getOrder() {
		return getOrderedDrink();
	}
	
	@Override
	public void orderReady(Drink preparedDrink) {
		if (orderedDrink == preparedDrink) {
			setOrderReady(true);
			System.out.println(name+" takes the drink and walks away...\n");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Drink getOrderedDrink() {
		return orderedDrink;
	}

	public void setOrderedDrink(Drink orderedDrink) {
		this.orderedDrink = orderedDrink;
	}

	public boolean isOrderReady() {
		return isOrderReady;
	}

	public void setOrderReady(boolean isOrderReady) {
		this.isOrderReady = isOrderReady;
	}
}
