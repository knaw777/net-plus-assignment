package com.net.plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.net.plus.model.Cart;
import com.net.plus.model.Item;
import com.net.plus.util.BusinessRulesEngine;
import com.net.plus.util.BusinessRulesUtil;

/**
 * @author Khader
 *
 */
public class App {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<Item> itemList = new ArrayList<Item>();
		Item item1 = new Item(000001, "A", 50.00f, 2);
		itemList.add(item1);
		Item item2 = new Item(000002, "B", 30.00f, 3);
		itemList.add(item2);
		Item item3 = new Item(000003, "C", 20.00f, 1);
		itemList.add(item3);
		Item item4 = new Item(000004, "D", 15.00f, 4);
		itemList.add(item4);
		Item item5 = new Item(000005, "E", 5.00f, 6);
		itemList.add(item5);
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

			itemPriceMap.put(itmName, (double) (Math.round(totalPrice * 100) / 100));

		}

		System.out.println("totalPrice.." + itemPriceMap);

	}
}
