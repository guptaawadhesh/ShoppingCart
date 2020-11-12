package com.shoppingcart.application;

import java.util.HashMap;
import java.util.Map;

import com.shoppingcart.dao.AddToShoppingCartDao;
import com.shoppingcart.entity.Products;

public class GetTotalCartPrice {	
	
	public static void main(String[] args) {
		AddToShoppingCartDao addToShoppingCartDao = new AddToShoppingCartDao();
		Map<String, Double> pricePerProductUnit = new HashMap<String, Double>();
		
		//Step 1: Add Five Dove Soaps to Shopping Cart
		int noOfUnitsToAddedStep1 = 5;
		double totalCartPriceStep1 = 0.00;
		pricePerProductUnit = addToShoppingCartDao.setPricePerProduct(Products.DoveSoap, 39.99, pricePerProductUnit);
		totalCartPriceStep1 = addToShoppingCartDao.addToShoppingCart(pricePerProductUnit, noOfUnitsToAddedStep1);
		
		//Step 2: Add Three Additional Dove Soaps to Shopping Cart
		int noOfExtraUnitsToAddedStep2 = 3, totalUnitsOfDoveSoapsStep2 = noOfUnitsToAddedStep1  + noOfExtraUnitsToAddedStep2;
		double totalCartPriceStep2 = 0.00;
		pricePerProductUnit = addToShoppingCartDao.setPricePerProduct(Products.DoveSoap, 39.99, pricePerProductUnit);
		totalCartPriceStep2 = addToShoppingCartDao.addToShoppingCart(pricePerProductUnit, totalUnitsOfDoveSoapsStep2);
		
		//Step3: Calculate Tax with multiple Items (2-2 units of each Dove Soap and Axe Deo)
		int noOfUnitsForEachProduct = 2;
		double totalCartPriceWithoutTaxStep3 = 0.00, totalCartPriceAfterTaxStep3 = 0.00, totalTaxAmount = 0.00;
		pricePerProductUnit = addToShoppingCartDao.setPricePerProduct(Products.AxeDeo, 99.99, pricePerProductUnit);
		totalCartPriceWithoutTaxStep3 = addToShoppingCartDao.addToShoppingCart(pricePerProductUnit, noOfUnitsForEachProduct);
		totalTaxAmount = addToShoppingCartDao.calculateTaxOnShoppingCart(totalCartPriceWithoutTaxStep3);
		totalCartPriceAfterTaxStep3 = addToShoppingCartDao.totalPriceInclucingTaxOnShoppingCart(totalCartPriceWithoutTaxStep3, totalTaxAmount);	
		
	}

}
