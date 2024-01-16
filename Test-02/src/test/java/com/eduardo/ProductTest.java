package com.eduardo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductTest {
    private Product product;
    private List<Item> data;

    @BeforeEach
    public void init() {
        product = new Product();
    }

    @Test
    public void verifyItemCommon() {
        product.items = new ArrayList<>(Arrays.asList(
                new Item("+5 Dexterity Vest Common", 2, 20),
                new Item("Elixir of the Mongoose Common", 3, 1)
        ));
        product.updateQuality();
        assertEquals(1, product.items.get(0).sellIn);
        assertEquals(2, product.items.get(1).sellIn);
        assertEquals(19, product.items.get(0).quality);
        assertEquals(0, product.items.get(1).quality);
        product.updateQuality();
        assertEquals(0, product.items.get(0).sellIn);
        assertEquals(1, product.items.get(1).sellIn);
        assertEquals(18, product.items.get(0).quality);
        assertEquals(0, product.items.get(1).quality);
        product.updateQuality();
        assertEquals(-1, product.items.get(0).sellIn);
        assertEquals(0, product.items.get(1).sellIn);
        assertEquals(16, product.items.get(0).quality);
        assertEquals(0, product.items.get(1).quality);
    }

    @Test
    public void verifyItemAgeBrie() {
        product.items = new ArrayList<>(Arrays.asList(
                new Item("Aged Brie", 2, 0),
                new Item("Aged Brie", 10, 49)
        ));
        product.updateQuality();
        assertEquals(1, product.items.get(0).sellIn);
        assertEquals(1, product.items.get(0).quality);
        assertEquals(9, product.items.get(1).sellIn);
        assertEquals(50, product.items.get(1).quality);
        product.updateQuality();
        assertEquals(0, product.items.get(0).sellIn);
        assertEquals(2, product.items.get(0).quality);
        assertEquals(8, product.items.get(1).sellIn);
        assertEquals(50, product.items.get(1).quality);
        product.updateQuality();
        assertEquals(-1, product.items.get(0).sellIn);
        assertEquals(4, product.items.get(0).quality);
        assertEquals(7, product.items.get(1).sellIn);
        assertEquals(50, product.items.get(1).quality);
        product.updateQuality();
        assertEquals(-2, product.items.get(0).sellIn);
        assertEquals(6, product.items.get(0).quality);
        assertEquals(6, product.items.get(1).sellIn);
        assertEquals(50, product.items.get(1).quality);
    }

    /*Revisar sellin question problem*/
    @Test
    public void verifySulfure() {
        product.items = new ArrayList<>(Arrays.asList(
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", 10, 80)
        ));
        product.updateQuality();
        assertEquals(0, product.items.get(0).sellIn);
        assertEquals(80, product.items.get(0).quality);
        assertEquals(10, product.items.get(1).sellIn);
        assertEquals(80, product.items.get(1).quality);
        product.updateQuality();
        assertEquals(0, product.items.get(0).sellIn);
        assertEquals(80, product.items.get(0).quality);
        assertEquals(10, product.items.get(1).sellIn);
        assertEquals(80, product.items.get(1).quality);
    }

    @Test
    public void verifyBacktage() {
        product.items = new ArrayList<>(Arrays.asList(
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 2, 46)
        ));
        product.updateQuality();
        assertEquals(10, product.items.get(0).sellIn);
        assertEquals(21, product.items.get(0).quality);
        assertEquals(5, product.items.get(1).sellIn);
        assertEquals(12, product.items.get(1).quality);
        assertEquals(1, product.items.get(2).sellIn);
        assertEquals(49, product.items.get(2).quality);
        product.updateQuality();
        assertEquals(9, product.items.get(0).sellIn);
        assertEquals(23, product.items.get(0).quality);
        assertEquals(4, product.items.get(1).sellIn);
        assertEquals(15, product.items.get(1).quality);
        assertEquals(0, product.items.get(2).sellIn);
        assertEquals(50, product.items.get(2).quality);
        product.updateQuality();
        assertEquals(-1, product.items.get(2).sellIn);
        assertEquals(0, product.items.get(2).quality);
        product.updateQuality();
        assertEquals(-2, product.items.get(2).sellIn);
        assertEquals(0, product.items.get(2).quality);
    }

    @Test
    public void verifyConjured() {
        product.items = new ArrayList<>(Arrays.asList(
                new Item("Conjured Mana Cake", 2, 10)
        ));
        product.updateQuality();
        assertEquals(1, product.items.get(0).sellIn);
        assertEquals(8, product.items.get(0).quality);
        product.updateQuality();
        assertEquals(0, product.items.get(0).sellIn);
        assertEquals(6, product.items.get(0).quality);
        product.updateQuality();
        assertEquals(-1, product.items.get(0).sellIn);
        assertEquals(2, product.items.get(0).quality);
        product.updateQuality();
        assertEquals(-2, product.items.get(0).sellIn);
        assertEquals(0, product.items.get(0).quality);
        product.updateQuality();
        assertEquals(-3, product.items.get(0).sellIn);
        assertEquals(0, product.items.get(0).quality);
    }

}
