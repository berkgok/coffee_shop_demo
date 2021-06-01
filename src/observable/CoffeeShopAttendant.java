package observable;

import java.util.ArrayList;
import java.util.List;

import domain.Drink;
import domain.IWaitingCustomer;

public class CoffeeShopAttendant {
	
	private List<IWaitingCustomer> customers;
	private Drink drinkInProgress;
	
	public CoffeeShopAttendant() {
		customers = new ArrayList<IWaitingCustomer>();
	}
	
	public void addCustomerToQueue(IWaitingCustomer customer) {
		customers.add(customer);
	}
	
	public void removeCustomerFromQueue(IWaitingCustomer customer) {
		customers.remove(customer);
	}
	
	private void prepareDrink(Drink orderedDrink) {
		this.drinkInProgress = orderedDrink;
		System.out.println("Coffee Attendant is preparing the "+this.drinkInProgress);
	}
	
	public void callOutCompleteOrder() {
		for (IWaitingCustomer customer : this.customers) {
			prepareDrink(customer.getOrder());
			customer.orderReady(drinkInProgress);
		}
	}
	
	public List<IWaitingCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<IWaitingCustomer> customers) {
		this.customers = customers;
	}
	
}
