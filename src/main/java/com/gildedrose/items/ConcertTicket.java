package com.gildedrose.items;

import com.gildedrose.Catalog;

/**
 * Created by Christophe on 11/06/2016.
 */
public class ConcertTicket extends SoldItem {

    public ConcertTicket(Item item) {
        super(item);
    }

    @Override
    public String getName() {
        return Catalog.CONCERT_TICKET;
    }

    @Override
    public void updateQuality() {
        if (isSellinDatePassed()) {
            setNullQuality();
        } else {
            if (!isMaxQuality()) {
                increaseQuality();
            }
            if (isSellDateClose()) {
                increaseQuality();
            }
            if (isSellDateVeryClose()) {
                increaseQuality();
            }
        }
        decreaseSellInDate();
    }

    private void setNullQuality() {
        item.quality = 0;
    }

    private boolean isSellDateVeryClose() {
        return item.sellIn <= 5;
    }

    private boolean isSellDateClose() {
        return item.sellIn <= 10;
    }
}
