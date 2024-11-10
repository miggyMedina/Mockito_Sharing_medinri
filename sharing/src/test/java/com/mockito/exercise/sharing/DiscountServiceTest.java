package com.mockito.exercise.sharing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountServiceTest {


    @Mock
    private PricingService pricingServiceMock;

    @InjectMocks
    private DiscountService discountService;

    @BeforeEach
    public void setUp() {
        // Stub the getPrice method to return a controlled value
        when(pricingServiceMock.getPrice("PRODUCT123")).thenReturn(100.0);
    }

    @Test
    public void testCalculateDiscountedPrice() {

//        PricingService pricingServiceMock = mock(PricingService.class);
//
//        when(pricingServiceMock.getPrice("PRODUCT123")).thenReturn(100.0);
//
//        DiscountService discountService = new DiscountService(pricingServiceMock);

        double discountedPrice = discountService.calculateDiscountedPrice("PRODUCT123", 0.2);

        assertEquals(80.0, discountedPrice);

        verify(pricingServiceMock).getPrice("PRODUCT123");

    }


}
