package com.eduardo;

public class ProductStandard extends ProductCommon implements IProduct {
    @Override
    public void updateQuality(Item item) {
        super.decrementQuality(item, 1);
        item.sellIn -= 1;
        if (item.sellIn < 0)
            super.decrementQuality(item, 1);
    }
}
