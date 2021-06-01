package domain;

public interface IWaitingCustomer {
	public Drink getOrder();
	public void orderReady(Drink preparedDrink);
}
