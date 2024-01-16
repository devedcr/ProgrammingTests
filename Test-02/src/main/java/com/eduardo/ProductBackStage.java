package com.eduardo;

public class ProductBackStage extends ProductCommon implements IProduct {
    @Override
    public void updateQuality(Item item) {
        super.incrementQuality(item, 1);
        if (item.sellIn < 11)
            super.incrementQuality(item, 1);
        if (item.sellIn < 6)
            super.incrementQuality(item, 1);
        item.sellIn -= 1;
        if (item.sellIn < 0)
            item.quality = 0;
    }
}
