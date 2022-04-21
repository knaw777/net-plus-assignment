package com.net.plus.util;

public  class BusinessRulesEngine {

	public double calculateSpecialPrice(String specialPriceDetails, String itemName) {

		return getUnitPriceBasedOnDiscount(specialPriceDetails, itemName);

	}

	private double getUnitPriceBasedOnDiscount(String specialPriceCreteria, String itemName) {

		double discountedUnitPrice = 0.0;

		if (specialPriceCreteria.equalsIgnoreCase("3 for 130") && itemName.equals("A")) {
			discountedUnitPrice = 130.0 / 3.0;

		} else if (specialPriceCreteria.equalsIgnoreCase("2 for 45") && itemName.equals("B")) {
			discountedUnitPrice = 45.0 / 2.0;

		} else if (specialPriceCreteria.equalsIgnoreCase("2 for 38") && itemName.equals("C")) {
			discountedUnitPrice = 38.0 / 2.0;

		} else if (specialPriceCreteria.equalsIgnoreCase("3 for 50") && itemName.equals("C")) {
			discountedUnitPrice = 50.0 / 3.0;
		} else if (specialPriceCreteria.equalsIgnoreCase("if purchaed with A")) {
			discountedUnitPrice = 5.0;
		} else {
			discountedUnitPrice = 0.0;
		}

		return discountedUnitPrice;

	}

}
