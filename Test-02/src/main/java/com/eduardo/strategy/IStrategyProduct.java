package com.eduardo.strategy;

import com.eduardo.Item;
import com.eduardo.product.IProduct;

public interface IStrategyProduct {
    void setStrategy(IProduct iProduct);
    void updateQuality(Item item);
}
