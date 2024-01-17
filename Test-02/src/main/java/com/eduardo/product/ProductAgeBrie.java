package com.eduardo.product;

import com.eduardo.Item;
import lombok.Builder;

@Builder
public class ProductAgeBrie extends ProductCommon implements IProduct {
    @Override
    public void updateQuality(Item item) {
        super.incrementQuality(item, 1);
        item.sellIn -= 1;
        if (item.sellIn < 0)
            super.incrementQuality(item, 1);
    }
}