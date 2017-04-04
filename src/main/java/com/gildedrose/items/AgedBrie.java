package com.gildedrose.items;

import com.gildedrose.Catalog;

/**
 * Created by Christophe on 11/06/2016.
 */
public class AgedBrie extends SoldItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public String getName() {
        return Catalog.AGED_BRIE;
    }

    @Override
    public void updateQuality() {
        if (!isMaxQuality()) {
            increaseQuality();
        }
        if (isSellinDatePassed()) {
            increaseQuality();
        }

        decreaseSellInDate();

    }

}
