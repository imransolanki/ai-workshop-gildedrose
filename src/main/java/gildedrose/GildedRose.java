package gildedrose;

public class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateSellIn(item);
            applyExpiredQualityChange(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSulfuras(item)) return;
        
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePass(item)) {
            updateBackstagePassQuality(item);
        } else {
            decreaseQuality(item);
        }
    }

    private void updateBackstagePassQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) increaseQuality(item);
        if (item.sellIn < 6) increaseQuality(item);
    }

    private void updateSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn--;
        }
    }

    private void applyExpiredQualityChange(Item item) {
        if (item.sellIn >= 0) return;
        
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePass(item)) {
            item.quality = 0;
        } else if (!isSulfuras(item)) {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}