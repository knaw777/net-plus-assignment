/**
 * 
 */
package com.net.plus.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.net.plus.model.Cart;
import com.net.plus.model.Item;

/**
 * @author Khader
 *
 */
public class BusinessRulesUtil {

	@SuppressWarnings("unused")
	public HashMap<String, String[]> fechSpecialPriceDetails(Cart carts) {

		List<Item> itemsList = carts.getItemList();
		String[] specialPriceDetails;
		HashMap<String, String[]> specialPriceMap = new HashMap<String, String[]>();

		for (Item item : itemsList) {

			String itmName = item.getName();
			specialPriceDetails = getAllSpecialPriceDetailsForItem(itmName);
			specialPriceMap.put(itmName, specialPriceDetails);

		}
		return specialPriceMap;
	}

	private String[] getAllSpecialPriceDetailsForItem(String itmName) {

		HashMap<String, List> specialPriceMap = getAllSpecialPriceDetailsForItems();
		String[] specialpriceArray = null;

		Set<Map.Entry<String, List>> entrySet = specialPriceMap.entrySet();

		for (Map.Entry<String, List> e : entrySet) {
			
		if (itmName.equals(e.getKey())) {

				specialpriceArray = (String[]) e.getValue().toArray(new String[0]);
				return specialpriceArray;
			}
		}
		return specialpriceArray;

	}

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	private HashMap<String, List> getAllSpecialPriceDetailsForItems() {

		HashMap<String, List> specialPriceMap = new HashMap<String, List>();
		@SuppressWarnings("unchecked")
		List<String> specialPriceList = new <String>ArrayList();
		specialPriceList.add("3 for 130");
		specialPriceMap.put("A", specialPriceList);
		specialPriceList = new <String>ArrayList();
		specialPriceList.add("2 for 45");
		specialPriceMap.put("B", specialPriceList);
		specialPriceList = new <String>ArrayList();
		specialPriceList.add("2 for 45");
		specialPriceList.add("3 for 38");
		specialPriceMap.put("C", specialPriceList);
		specialPriceList = new <String>ArrayList();
		specialPriceList.add("5 if	purchased A");
		specialPriceMap.put("D", specialPriceList);
		specialPriceList = new <String>ArrayList();
		specialPriceList.add("null");

		return specialPriceMap;

	}
	
}
