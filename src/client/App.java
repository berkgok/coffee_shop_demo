package client;

import domain.Customer;
import domain.Drink;
import domain.IWaitingCustomer;
import observable.CoffeeShopAttendant;

public class App {

	public static void main(String[] args) {
		
		CoffeeShopAttendant csa = new CoffeeShopAttendant();
		IWaitingCustomer c1 = new Customer("Emily", Drink.COFFE);
		IWaitingCustomer c2 = new Customer("Hayley", Drink.MILKSHAKE);
		IWaitingCustomer c3 = new Customer("Abigail", Drink.TEA);
		
		csa.addCustomerToQueue(c1);
		csa.addCustomerToQueue(c2);
		csa.addCustomerToQueue(c3);
		
		csa.callOutCompleteOrder();
		
	}

}
