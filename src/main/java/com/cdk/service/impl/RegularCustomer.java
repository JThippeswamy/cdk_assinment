package com.cdk.service.impl;

import com.cdk.service.Price;

public class RegularCustomer implements Price {

	@Override
	public Float calculate(float purchaseAmount) {
		return this.calculateDiscountedPrice(purchaseAmount);
	}

	private float calculateDiscountedPrice(float purchaseAmount) {
		float total = 0;
		if (purchaseAmount > 5000 && purchaseAmount <= 10000) {
			float firstSlab = purchaseAmount - 5000;
			firstSlab = firstSlab - (float) (firstSlab * 0.1);
			total = 5000 + firstSlab;
		}else if (purchaseAmount > 10000) {
			float secondSlab = purchaseAmount - 10000;
			secondSlab = secondSlab - (float) (secondSlab * 0.2);
			float firstSlab = 10000 - 5000;
			firstSlab = firstSlab - (float) (firstSlab * 0.1);
			System.out.println("firstSlab:" + firstSlab);
			total = 5000 + firstSlab;
			total = total + secondSlab;
		} else if (purchaseAmount <= 5000 && purchaseAmount >= 0) {
			total = purchaseAmount;
		} else {
			return purchaseAmount;
		}
		return total;
	}
}