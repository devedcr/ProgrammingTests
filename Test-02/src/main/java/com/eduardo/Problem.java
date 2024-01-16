package com.eduardo;

import lombok.Builder;

import java.util.*;

@Builder
public class Problem implements IProblem {
    public static final String AGE_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURUS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURE = "Conjured Mana Cake";
    public List<Item> items;
    public IStrategyProduct strategyProduct;
    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(SULFURUS))
                continue;
            switch (item.name) {
                case AGE_BRIE -> {
                    strategyProduct.setStrategy(new ProductAgeBrie());
                    strategyProduct.updateQuality(item);
                }
                case BACKSTAGE -> {
                    strategyProduct.setStrategy(new ProductBackStage());
                    strategyProduct.updateQuality(item);
                }
                case CONJURE -> {
                    strategyProduct.setStrategy(new ProductConjure());
                    strategyProduct.updateQuality(item);
                }
                default -> {
                    strategyProduct.setStrategy(new ProductStandard());
                    strategyProduct.updateQuality(item);
                }
            }
        }
    }
}
