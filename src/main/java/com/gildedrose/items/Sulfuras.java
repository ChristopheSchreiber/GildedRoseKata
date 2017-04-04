package com.gildedrose.items;

import com.gildedrose.Catalog;

/**
 * Created by Christophe on 11/06/2016.
 */
public class Sulfuras extends SoldItem {

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public String getName() {
        return Catalog.SULFURAS;
    }

    @Override
    public void updateQuality() {

    }
}
