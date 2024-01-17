package com.eduardo;

import com.eduardo.factory.IProductFactory;
import com.eduardo.product.*;
import com.eduardo.strategy.IStrategyProduct;
import lombok.Builder;

import java.util.*;

@Builder
public class Problem implements IProblem {
    public List<Item> items;
    public IStrategyProduct strategyProduct;
    public IProductFactory productFactory;

    public void updateQualityProduct(Item item) {
        IProduct product = productFactory.getProduct(item.name);
        strategyProduct.setStrategy(product);
        strategyProduct.updateQuality(item);
    }

    public void updateQualityAllProduct() {
        for (Item item : items)
            updateQualityProduct(item);
    }
}
