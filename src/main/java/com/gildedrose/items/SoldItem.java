package com.gildedrose.items;

/**
 * Created by Christophe on 11/06/2016.
 */

public abstract class SoldItem {

    static final int MAX_QUALITY = 50;

    final boolean conjured;

    public abstract String getName();

    protected Item item;

    public SoldItem(Item item) {
        this.item = item;
        this.conjured = false;
    }

    public SoldItem(Item item, boolean conjured) {
        this.item = item;
        this.conjured = conjured;
    }

    void decreaseQuality() {
        item.quality--;
        if (conjured) {
            item.quality--;
        }
    }

    void increaseQuality() {
        item.quality++;
    }

    boolean hasPositiveQuality() {
        return item.quality > 0;
    }

    boolean isSellinDatePassed() {
        return item.sellIn <= 0;
    }

    boolean isMaxQuality() {
        return item.quality >= MAX_QUALITY;
    }

    void decreaseSellInDate() {
        item.sellIn--;
    }

    public abstract void updateQuality();
}
