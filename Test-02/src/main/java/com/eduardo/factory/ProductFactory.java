package com.eduardo.factory;

import com.eduardo.product.*;

import java.util.Map;
import java.util.Objects;

public class ProductFactory implements IProductFactory {
    public static final String AGE_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURO = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURE = "Conjured Mana Cake";
    public static IProduct DEFAULT_PRODUCT = ProductStandard.builder().build();
    public static Map<String, IProduct> factory = Map.of(
            AGE_BRIE, ProductAgeBrie.builder().build(),
            BACKSTAGE, ProductBackStage.builder().build(),
            CONJURE, ProductConjure.builder().build(),
            SULFURO, ProductSulfuro.builder().build()
    );

    public IProduct getProduct(String name) {
        IProduct instance = factory.get(name);
        if (Objects.isNull(instance))
            return DEFAULT_PRODUCT;
        return instance;
    }
}
