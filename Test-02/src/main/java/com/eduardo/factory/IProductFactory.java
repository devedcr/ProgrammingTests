package com.eduardo.factory;

import com.eduardo.product.IProduct;

public interface IProductFactory {
    IProduct getProduct(String name);
}
