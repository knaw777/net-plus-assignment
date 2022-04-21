package com.net.plus;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.net.plus.model.Cart;
import com.net.plus.model.Item;
import com.net.plus.util.BusinessRulesEngine;
import com.net.plus.util.BusinessRulesUtil;

public class NetPlusTestcases {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		List<Item> itemList = new ArrayList<Item>();
		Item item1 = new Item(000001, "A", 50.00f, 2);
		
		itemList.add(item1);	
		Cart cart = new Cart(itemList);
		BusinessRulesUtil businessRulesUtil = new BusinessRulesUtil();
		HashMap<String, String[]> specialPriceMap = businessRulesUtil.fechSpecialPriceDetails(cart);

		List<Item> itemsList = cart.getItemList();
		HashMap<String, Double> itemPriceMap = new HashMap<String, Double>();

		for (Item item : itemsList) {

			String itmName = item.getName();
			String selectedDiscountCreteria = "3 for 130";
			BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
			double discountedPrice = businessRulesEngine.calculateSpecialPrice(selectedDiscountCreteria, itmName);
			System.out.println("Dsicounted price.." + discountedPrice);
			double totalPrice = 0.0;

			if (discountedPrice > 0.0) {

				totalPrice = discountedPrice * item.getQuantity();

			} else {
				totalPrice = item.getPrice() * item.getQuantity();
			}
			System.out.println("total price.."+totalPrice);
		    Assert.assertEquals(86.66, totalPrice);

		}
	}

}
