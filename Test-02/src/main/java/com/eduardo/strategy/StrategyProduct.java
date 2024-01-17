package com.eduardo.strategy;

import com.eduardo.Item;
import com.eduardo.product.IProduct;

public class StrategyProduct implements IStrategyProduct {
    private IProduct iProduct;

    public void setStrategy(IProduct iProduct) {
        this.iProduct = iProduct;
    }

    public void updateQuality(Item item) {
        this.iProduct.updateQuality(item);
    }
}
