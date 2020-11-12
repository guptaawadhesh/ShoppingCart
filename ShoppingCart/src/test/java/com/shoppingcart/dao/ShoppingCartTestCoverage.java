package com.shoppingcart.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.shoppingcart.entity.Products;

public class ShoppingCartTestCoverage {

	@Test
	public void test() {
		final double DELTA = 1e-15;
		Map<String, Double> pricePerProductUnit = new HashMap<String, Double>();
		AddToShoppingCartDao addToShoppingCartDao = new AddToShoppingCartDao();

		// Step 1: Add Five Dove Soaps to Shopping Cart
		int noOfUnitsToAddedStep1 = 5;
		double totalCartPriceStep1 = 0.00;
		pricePerProductUnit = addToShoppingCartDao.setPricePerProduct(Products.DoveSoap, 39.99, pricePerProductUnit);
		totalCartPriceStep1 = addToShoppingCartDao.addToShoppingCart(pricePerProductUnit, noOfUnitsToAddedStep1);
		assertEquals(199.95, totalCartPriceStep1, DELTA);

		// Step 2: Add Three Additional Dove Soaps to Shopping Cart
		int noOfExtraUnitsToAddedStep2 = 3, totalUnitsOfDoveSoapsStep2 = noOfUnitsToAddedStep1 + noOfExtraUnitsToAddedStep2;
		double totalCartPriceStep2 = 0.00;
		pricePerProductUnit = addToShoppingCartDao.setPricePerProduct(Products.DoveSoap, 39.99, pricePerProductUnit);
		totalCartPriceStep2 = addToShoppingCartDao.addToShoppingCart(pricePerProductUnit, totalUnitsOfDoveSoapsStep2);
		assertEquals(319.92, totalCartPriceStep2, DELTA);

		// Step3: Calculate Tax with multiple Items (2-2 units of each Dove Soap and Axe Deo)
		int noOfUnitsForEachProduct = 2;
		double totalCartPriceWithoutTaxStep3 = 0.00, totalCartPriceAfterTaxStep3 = 0.00, totalTaxAmount = 0.00;
		pricePerProductUnit = addToShoppingCartDao.setPricePerProduct(Products.AxeDeo, 99.99, pricePerProductUnit);
		totalCartPriceWithoutTaxStep3 = addToShoppingCartDao.addToShoppingCart(pricePerProductUnit,	noOfUnitsForEachProduct);
		totalTaxAmount = addToShoppingCartDao.calculateTaxOnShoppingCart(totalCartPriceWithoutTaxStep3);
		assertEquals(35.00, totalTaxAmount, DELTA);
		totalCartPriceAfterTaxStep3 = addToShoppingCartDao.totalPriceInclucingTaxOnShoppingCart(totalCartPriceWithoutTaxStep3, totalTaxAmount);
		assertEquals(314.96, totalCartPriceAfterTaxStep3, DELTA);

	}

}
