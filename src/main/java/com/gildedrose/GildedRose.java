package com.gildedrose;

import com.gildedrose.items.Item;
import com.gildedrose.items.SoldItem;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            SoldItem soldItem = Catalog.getSoldItem(item);
            soldItem.updateQuality();

        }
    }
}
