package gildedrose;

public class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";
    
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
            if (isConjured(item)) {
                decreaseQuality(item);
            }
        }
    }

    private void updateBackstagePassQuality(Item item) {
        increaseQuality(item);
        if (item.getSellIn() < 11) increaseQuality(item);
        if (item.getSellIn() < 6) increaseQuality(item);
    }

    private void updateSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private void applyExpiredQualityChange(Item item) {
        if (item.getSellIn() >= 0) return;
        
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePass(item)) {
            item.setQuality(0);
        } else if (!isSulfuras(item)) {
            decreaseQuality(item);
            if (isConjured(item)) {
                decreaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isConjured(Item item) {
        return item.name.startsWith(CONJURED);
    }
}