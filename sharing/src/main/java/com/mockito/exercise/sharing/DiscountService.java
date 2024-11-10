package com.mockito.exercise.sharing;

// The DiscountService class we want to test
public class DiscountService {
    private PricingService pricingService;

    public DiscountService(PricingService pricingService) {

        this.pricingService = pricingService;
    }

    public double calculateDiscountedPrice(String productCode, double discountRate) {
        double originalPrice = pricingService.getPrice(productCode);
        return originalPrice * (1 - discountRate);
    }
}
