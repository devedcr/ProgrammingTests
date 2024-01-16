package com.eduardo;

public class StrategyProduct implements IStrategyProduct {
    private IProduct iProduct;

    public void setStrategy(IProduct iProduct) {
        this.iProduct = iProduct;
    }

    public void updateQuality(Item item) {
        this.iProduct.updateQuality(item);
    }
}
