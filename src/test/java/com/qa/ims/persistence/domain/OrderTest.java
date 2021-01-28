package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	
	@Test
	public void firstConstructorTEST() {
		Customer customer = new Customer("John", "Smith");
		Order order = new Order(3L, customer);
		
		assertEquals(Long.valueOf(3), order.getId());
		assertEquals(customer, order.getFk_customer_id());
	}
	
	@Test
	public void secondConstructorTEST() {
		Customer customer = new Customer("Jane", "Smith");
		Order order = new Order(customer);
		
		assertEquals(customer, order.getFk_customer_id());
	}
	
	@Before
	public void thirdConstuctorTEST() {
		Order order = new Order();
		
		assertNotNull(order);
	}
	
	@Test
	public void fourthConstructorTEST() {
		Customer customer = new Customer("Abraham", "Lincoln");
		Item Axe = new Item("Axe", 9.99);
		Item Wood = new Item(3L, "Wood", 1.45);
		List<Item> ordersItems = new ArrayList<>();
		ordersItems.add(Axe);
		ordersItems.add(Wood);
		double totalPrice = Axe.getPrice() + Wood.getPrice();
		Order order = new Order(3L, customer, totalPrice, ordersItems);
		
		assertEquals(Long.valueOf(3), order.getId());
		assertEquals(totalPrice, order.getTotalPrice(), 0.01);
		assertEquals(ordersItems, order.getOrdersItems());
		assertEquals(customer, order.getFk_customer_id());
	}
	
	@Test
	public void fifthConstructorTEST() {
		Customer customer = new Customer("Abraham", "Lincoln");
		Item Axe = new Item("Axe", 9.99);
		Item Wood = new Item(3L, "Wood", 1.45);
		List<Item> ListOfItems = new ArrayList<>();
		ListOfItems.add(Axe);
		ListOfItems.add(Wood);
		double totalPrice = Axe.getPrice() + Wood.getPrice();
		Order order = new Order(3L, customer, ListOfItems, totalPrice);
		
		assertEquals(Long.valueOf(3), order.getId());
		assertEquals(totalPrice, order.getTotalPrice(), 0.01);
		assertEquals(ListOfItems, order.getOrdersItems());
		assertEquals(customer, order.getFk_customer_id());
	}
	
	@Test
	public void equalsTEST() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
	
	@Test
	public void toStringTEST() {
		Customer customer = new Customer(3L, "Abraham", "Lincoln");
		Item Axe = new Item(4L, "Axe", 9.99);
		Item Wood = new Item(3L, "Wood", 1.45);
		List<Item> ListOfItems = new ArrayList<>();
		ListOfItems.add(Axe);
		ListOfItems.add(Wood);
		double totalPrice = Axe.getPrice() + Wood.getPrice();
		Order order = new Order(3L, customer, ListOfItems, totalPrice);
		
		assertEquals("id=3, fk_customer_id=id:3 first name:Abraham surname:Lincoln, totalPrice=11.44, ordersItems=[id=4 name=Axe price=9.99, id=3 name=Wood price=1.45]", order.toString());
	}

}
