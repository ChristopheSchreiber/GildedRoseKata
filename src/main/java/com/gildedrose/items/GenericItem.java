package com.gildedrose.items;

/**
 * Created by Christophe on 11/06/2016.
 */
public class GenericItem  extends SoldItem {

    public GenericItem(Item item) {
        super(item);
    }

    public GenericItem(Item item, boolean conjured) {
        super(item, conjured);
    }

    @Override
    public String getName() {
        return item.name;
    }

    @Override
    public void updateQuality() {
        if (hasPositiveQuality()) {
            decreaseQuality();
        }
        if (isSellinDatePassed()) {
            decreaseQuality();
        }
        decreaseSellInDate();
    }
}
