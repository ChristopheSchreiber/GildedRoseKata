package com.gildedrose;

import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void testNormalDegradation()  {
        int originalQuality = 50;
        Item[] items = new Item[] { new Item("Anything", 10, originalQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(originalQuality-1, app.items[0].quality);
    }

    @Test
    public void testConjuredItemDegradation() {
        int originalQuality = 50;
        Item[] items = new Item[] { new ConjuredItem("Anything", 10, originalQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(originalQuality-2, app.items[0].quality);
    }

    @Test
    public void testDatePassed()  {
        int originalQuality = 50;
        Item[] items = new Item[] { new Item("Anything", 0, originalQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(originalQuality-2, app.items[0].quality);
    }

    @Test
    public void testQualityNotNegative() {
        Item[] items = new Item[] { new Item("Anything", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testAgedBrieIncrease()  {
        int originalQuality = 10;
        Item[] items = new Item[] { new Item("Aged Brie", 1, originalQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(originalQuality + 1, app.items[0].quality);
    }

    @Test
    public void testAgedBrieIncreaseUntil50()  {
        int originalQuality = 50;
        Item[] items = new Item[] { new Item("Aged Brie", 1, originalQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(originalQuality, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesIncrease()  {
        int originalQuality = 10;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, originalQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(originalQuality+1, app.items[0].quality);

        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(originalQuality + 1 + 2, app.items[0].quality);

        app.items[0].sellIn = 3;
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(originalQuality + 1 + 2 + 3, app.items[0].quality);

        app.items[0].sellIn = 0;
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

    }

    @Test
    public void testSulfurasNeverDegrades()  {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

}
