package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseARefactoredTest {
	private static final int DEFAULT_QUALITY = 3;
	private static final int NOT_EXP_SELLIN = 15;
	private static final String DEFAULT_ITEM = "DEFAULT_ITEM";

	private static final int EXP_SELLIN = -1;
	private static final int EXP_DEFAULT_QUALITY = 3;

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 1 when the item is not expired
	 * and sell in should decrease by 1.
	 * 
	 */

	private GildedRose createGRitem(String itemType, int sellin, int quality) {
		Item item = new Item(itemType, sellin, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}

	private void asserstion(Item exp, Item act) {
		assertEquals(exp.name, act.name);
		assertEquals(exp.sellIn, act.sellIn);
		assertEquals(exp.quality, act.quality);
	}


	@Test
	public void unexpired_defaultItem_qualityDescBy1() {

		GildedRose app = createGRitem(DEFAULT_ITEM, NOT_EXP_SELLIN, DEFAULT_QUALITY);
		app.updateQuality();

		Item exp =new Item(DEFAULT_ITEM, NOT_EXP_SELLIN-1, DEFAULT_QUALITY-1);

		asserstion(exp, app.items[0]);
	}

	


	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 * 
	 */

	@Test
	public void expired_defaultItem_qualityDescBy1() {

		
		
		GildedRose app = createGRitem(DEFAULT_ITEM, EXP_SELLIN, EXP_DEFAULT_QUALITY);
		app.updateQuality();

		Item exp =new Item(DEFAULT_ITEM, EXP_SELLIN-1, EXP_DEFAULT_QUALITY-2);

		asserstion(exp, app.items[0]);


	}


	}

