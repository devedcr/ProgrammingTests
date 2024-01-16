package com.eduardo;

public abstract class ProductCommon {
    protected void incrementQuality(Item item, int increment) {
        for (int i = 0; i < increment; i++) {
            if (item.quality >= 50) break;
            item.quality += 1;
        }
    }

    protected void decrementQuality(Item item, int decrement) {
        for (int i = 0; i < decrement; i++) {
            if (item.quality == 0) break;
            item.quality -= 1;
        }
    }
}
