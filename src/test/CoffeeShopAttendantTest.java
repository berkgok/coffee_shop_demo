package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Customer;
import domain.Drink;
import domain.IWaitingCustomer;
import observable.CoffeeShopAttendant;

public class CoffeeShopAttendantTest {
	
	CoffeeShopAttendant csa;
	IWaitingCustomer c1;
	IWaitingCustomer c2;
	IWaitingCustomer c3;
	
	@Before
	public void setUp() throws Exception {
		csa = new CoffeeShopAttendant();
		c1 = new Customer("Emily", Drink.COFFE);
		c2 = new Customer("Hayley", Drink.MILKSHAKE);
		c3 = new Customer("Abigail", Drink.TEA);
	}

	@Test
	public final void testAddCustomerToQueue() {
		assertEquals(0, csa.getCustomers().size());
		
		csa.addCustomerToQueue(c1);
		assertEquals(1, csa.getCustomers().size());
		assertEquals(new ArrayList<>(Arrays.asList(c1)), csa.getCustomers());
	}
	
	@Test
	public final void testRemoveCustomerToQueue() {
		List<IWaitingCustomer> customers = new ArrayList<>(Arrays.asList(c1));
		csa.setCustomers(customers);
		assertEquals(1, csa.getCustomers().size());
		
		csa.removeCustomerFromQueue(c1);
		assertEquals(0, csa.getCustomers().size());
		assertEquals(new ArrayList<>(), csa.getCustomers());
	}
	
	@Test
	public final void testCallOutCompleteOrder() {
		List<IWaitingCustomer> customers = new ArrayList<>(Arrays.asList(c1, c2, c3));
		csa.setCustomers(customers);
		assertEquals(false, ((Customer) c1).isOrderReady());
		assertEquals(false, ((Customer) c2).isOrderReady());
		assertEquals(false, ((Customer) c3).isOrderReady());
		
		csa.callOutCompleteOrder();
		
		assertEquals(true, ((Customer) c1).isOrderReady());
		assertEquals(true, ((Customer) c2).isOrderReady());
		assertEquals(true, ((Customer) c3).isOrderReady());
	}

}
