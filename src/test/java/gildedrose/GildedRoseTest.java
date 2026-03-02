package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void normalItem_BeforeSellDate_DegradesByOne() {
        Item[] items = new Item[]{new Item("Normal Item", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(9, items[0].quality);
    }

    @Test
    public void normalItem_OnSellDate_DegradesByTwo() {
        Item[] items = new Item[]{new Item("Normal Item", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    public void normalItem_AfterSellDate_DegradesByTwo() {
        Item[] items = new Item[]{new Item("Normal Item", -5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-6, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    public void normalItem_QualityNeverNegative() {
        Item[] items = new Item[]{new Item("Normal Item", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void agedBrie_BeforeSellDate_IncreasesQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }

    @Test
    public void agedBrie_AfterSellDate_IncreasesByTwo() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    public void agedBrie_QualityNeverAbove50() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    public void sulfuras_NeverChanges() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    public void backstagePass_MoreThan10Days_IncreasesBy1() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    public void backstagePass_10Days_IncreasesBy2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    public void backstagePass_5Days_IncreasesBy3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    public void backstagePass_AfterConcert_DropsToZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void backstagePass_QualityNeverAbove50() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    public void multipleItems_UpdatedCorrectly() {
        Item[] items = new Item[]{
                new Item("Normal Item", 5, 10),
                new Item("Aged Brie", 3, 10),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(4, items[0].sellIn);
        assertEquals(9, items[0].quality);
        
        assertEquals(2, items[1].sellIn);
        assertEquals(11, items[1].quality);
        
        assertEquals(0, items[2].sellIn);
        assertEquals(80, items[2].quality);
        
        assertEquals(14, items[3].sellIn);
        assertEquals(21, items[3].quality);
    }

    @Test
    public void conjuredItem_BeforeSellDate_DegradesByTwo() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    public void conjuredItem_OnSellDate_DegradesByFour() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    public void conjuredItem_AfterSellDate_DegradesByFour() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    public void conjuredItem_QualityNeverNegative() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }
}
