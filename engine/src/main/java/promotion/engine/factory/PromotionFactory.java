package promotion.engine.factory;

import promotion.engine.beans.PromotionType;

public class PromotionFactory {
	public static Promotion setPromotionObject(int promotionType) {
		Promotion promotion = null;
		switch(promotionType) {
			case PromotionType.N_ITEMS:
				new NItemPromotions().setPromotionDetail();
				break;
			case PromotionType.ITEMS_IN_PAIR:
				break;
			case PromotionType.PERCENT_OF_ITEM:
				break;
			default:
				break;
		}
		return promotion;
	}
}
