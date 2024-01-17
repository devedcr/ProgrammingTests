package com.eduardo.product;

import com.eduardo.Item;
import lombok.Builder;

@Builder
public class ProductSulfuro extends ProductCommon implements IProduct {
    @Override
    public void updateQuality(Item item) {
    }
}
