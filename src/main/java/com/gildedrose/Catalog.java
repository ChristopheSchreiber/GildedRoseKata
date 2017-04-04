package com.gildedrose;

import com.gildedrose.items.*;

/**
 * Created by Christophe on 11/06/2016.
 */
public class Catalog {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONCERT_TICKET = "Backstage passes to a TAFKAL80ETC concert";

    public static SoldItem getSoldItem(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie(item);
            case SULFURAS:
                return new Sulfuras(item);
            case CONCERT_TICKET:
                return new ConcertTicket(item);
            default:
                boolean conjured = item instanceof ConjuredItem;
                return new GenericItem(item, conjured);
        }
    }
}
