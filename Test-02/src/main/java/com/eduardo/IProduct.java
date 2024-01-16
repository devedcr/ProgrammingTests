package com.eduardo;

public interface IProduct {
    void incrementQuality(Item item, int increment);

    void decrementQuality(Item item, int decrement);

    void updateQuality();
}
