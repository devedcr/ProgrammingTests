package com.eduardo;

import java.util.LinkedList;
import java.util.List;

public class Product {
    public List<Item> items;

    public Product() {
    }

    public void updateQuality() {
        for (var i = 0; i < items.size(); i++) {
            if (!"Aged Brie".equalsIgnoreCase(items.get(i).name) && !"Backstage passes to a TAFKAL80ETC concert".equalsIgnoreCase(items.get(i).name)) {
                if (items.get(i).quality > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equalsIgnoreCase(items.get(i).name)) {
                        items.get(i).quality = items.get(i).quality - 1; //Item normal
                    }
                }
            } else {
                if (items.get(i).quality < 50) {
                    items.get(i).quality = items.get(i).quality + 1;
                    if ("Backstage passes to a TAFKAL80ETC concert".equalsIgnoreCase(items.get(i).name)) { //Validacion Type Backtasge
                        if (items.get(i).sellIn < 11) {
                            if (items.get(i).quality < 50) {
                                items.get(i).quality = items.get(i).quality + 1;
                            }
                        }
                        if (items.get(i).sellIn < 6) {
                            if (items.get(i).quality < 50) {
                                items.get(i).quality = items.get(i).quality + 1;
                            }
                        }
                    }
                }
            }
            if (!"Sulfuras, Hand of Ragnaros".equalsIgnoreCase(items.get(i).name)) { //REVISAR validar selling>0
                items.get(i).sellIn = items.get(i).sellIn - 1;
            }
            if (items.get(i).sellIn < 0) {
                if (!"Aged Brie".equals(items.get(i).name)) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equalsIgnoreCase(items.get(i).name)) {
                        if (items.get(i).quality > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equalsIgnoreCase(items.get(i).name)) { //Item normal o Conjured
                                items.get(i).quality = items.get(i).quality - 1;
                            }
                        }
                    } else {
                        items.get(i).quality = items.get(i).quality - items.get(i).quality; //anulando calidad
                    }
                } else {
                    if (items.get(i).quality < 50) {
                        items.get(i).quality = items.get(i).quality + 1;
                    }
                }
            }
           /*ADD*/
            if ("Conjured Mana Cake".equalsIgnoreCase(items.get(i).name)) {
                if (items.get(i).quality > 0) {
                    items.get(i).quality = items.get(i).quality - 1;
                    if (items.get(i).sellIn < 0 && items.get(i).quality > 0) {
                        items.get(i).quality = items.get(i).quality - 1;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        var product = new Product();
    }
}
