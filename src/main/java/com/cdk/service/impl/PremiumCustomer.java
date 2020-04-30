package com.cdk.service.impl;

import com.cdk.service.Price;

public class PremiumCustomer implements Price {

	@Override
	public Float calculate(float purchaseAmount) {
		return this.calculateDiscountedPrice(purchaseAmount);	
	}
	
	private float calculateDiscountedPrice(float purchaseAmount) {
		float total = 0;
		if (purchaseAmount <= 4000) {
			total = purchaseAmount - (float) (purchaseAmount * 0.1);
		}
		if (purchaseAmount > 4000 && purchaseAmount <= 8000) {
			float secondSlab = purchaseAmount - 4000;
			secondSlab = secondSlab - (float) (secondSlab * 0.15);
			float firstSlab = 8000 - 4000;
			total = firstSlab - (float) (firstSlab * 0.1);
			total = total + secondSlab;
		}
		if (purchaseAmount > 8000 && purchaseAmount <= 12000) {
			float thirdSlab = purchaseAmount - 8000;
			thirdSlab = thirdSlab - (float) (thirdSlab * 0.20);
			float secondSlab = 8000 - 4000;
			secondSlab = secondSlab - (float) (secondSlab * 0.15);
			float firstSlab = 8000 - 4000;
			total = firstSlab - (float) (firstSlab * 0.1);
			total = total + secondSlab + thirdSlab;
		}
		if (purchaseAmount > 12000) {
			float fourthSlab = purchaseAmount - 12000;
			fourthSlab = fourthSlab - (float) (fourthSlab * 0.30);
			float thirdSlab = 8000 - 4000;
			thirdSlab = thirdSlab - (float) (thirdSlab * 0.20);
			float secondSlab = 8000 - 4000;
			secondSlab = secondSlab - (float) (secondSlab * 0.15);
			float firstSlab = 8000 - 4000;
			total = firstSlab - (float) (firstSlab * 0.1);
			total = total + secondSlab + thirdSlab + fourthSlab;
		}	
		return total;
	}
}