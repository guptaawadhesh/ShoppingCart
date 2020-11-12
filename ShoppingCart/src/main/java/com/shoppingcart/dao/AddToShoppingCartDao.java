package com.shoppingcart.dao;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddToShoppingCartDao {

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public double addToShoppingCart(Map<String, Double> pricePerProductUnit, int noOfUnitsToAdded) {
		double totalCartPrice = 0.00;
		List<String> shoppingCart = new ArrayList<String>();
		String product = null;
		double productPrice = 0.00;
		double productTotalPrice = 0.00;
		
		if(pricePerProductUnit.size()==1) {
			for(String proudctName: pricePerProductUnit.keySet()) {
				product = proudctName;
			}
			for(int i=1;i<=noOfUnitsToAdded;i++) {
				shoppingCart.add(product);
			}
			
			productPrice = pricePerProductUnit.get(product);
			totalCartPrice = shoppingCart.size() * productPrice;
			
		} else if(pricePerProductUnit.size()==2) {
			for(String proudctName: pricePerProductUnit.keySet()) {
				product = proudctName;
				
				for(int i=1;i<=noOfUnitsToAdded;i++) {
					shoppingCart.add(product);
				}
				
				productPrice = pricePerProductUnit.get(product);			
				productTotalPrice = noOfUnitsToAdded * productPrice;
				totalCartPrice = totalCartPrice + productTotalPrice;
			}
		}		
		
		totalCartPrice = Double.parseDouble(df2.format(totalCartPrice));		
		
		return totalCartPrice;
	}

	public double calculateTaxOnShoppingCart(double totalCartPriceWithoutTaxStep3) {
		double taxRate = 12.5/100;
		double totalTaxAmount = 0.00;

		df2.setRoundingMode(RoundingMode.CEILING);
		totalTaxAmount = Double.parseDouble(df2.format(totalCartPriceWithoutTaxStep3 * taxRate));
		
		return totalTaxAmount;
	}
	
	public double totalPriceInclucingTaxOnShoppingCart(double totalCartPriceWithoutTaxStep3, double totalTaxAmount) {
		double totalCartPrice = 0.00;
		
		totalCartPrice = totalCartPriceWithoutTaxStep3 + totalTaxAmount;
		totalCartPrice = Double.parseDouble(df2.format(totalCartPrice));
		
		return totalCartPrice;
	}

	public Map<String, Double> setPricePerProduct(String productName, double pricePerUnit, Map<String, Double> pricePerProductUnit) { 

		pricePerProductUnit.put(productName, pricePerUnit);

		return pricePerProductUnit;
	}

}
