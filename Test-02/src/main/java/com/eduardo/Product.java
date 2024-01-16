package com.eduardo;

import java.util.List;

public class Product implements IProduct {
    public static final String AGE_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURUS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURE = "Conjured Mana Cake";
    public List<Item> items;

    public Product() {
    }

    public void incrementQuality(Item item, int increment) {
        if ((increment + item.quality) <= 50)
            item.quality += increment;
    }

    public void decrementQuality(Item item, int decrement) {
        if ((item.quality - decrement) >= 0)
            item.quality -= decrement;
    }

    public void updateQuality() {

        for (Item item : items) {
            if (item.name.equalsIgnoreCase(SULFURUS))
                continue;

            if (item.name.equalsIgnoreCase(AGE_BRIE)) {
                incrementQuality(item, 1);
            } else if (item.name.equalsIgnoreCase(BACKSTAGE)) {
                incrementQuality(item, 1);
                if (item.sellIn < 11)
                    incrementQuality(item, 1);
                if (item.sellIn < 6)
                    incrementQuality(item, 1);
            } else { //item normal
                decrementQuality(item, 1);
                if (item.name.equalsIgnoreCase(CONJURE))
                    decrementQuality(item, 1);
            }

            item.sellIn -= 1;

            if (item.sellIn < 0) {
                if (item.name.equalsIgnoreCase(AGE_BRIE)) {
                    incrementQuality(item, 1);
                } else if (item.name.equalsIgnoreCase(BACKSTAGE)) {
                    item.quality = 0;
                } else { //item normal
                    decrementQuality(item, 1);
                    if (item.name.equalsIgnoreCase(CONJURE))
                        decrementQuality(item, 1);
                }
            }

        }
    }
}
