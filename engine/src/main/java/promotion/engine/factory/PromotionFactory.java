package promotion.engine.factory;

import promotion.engine.beans.PromotionType;
import promotion.engine.utility.CustomerInputs;

/**
 * This is a Promotion Factory which will provide promotion type object
 * */
public class PromotionFactory {
	public static Promotion setPromotionObject(int promotionType) {
		Promotion promotion = null;
		switch(promotionType) {
			case PromotionType.N_ITEMS:
				new NItemPromotions().setPromotionDetail();
				break;
			case PromotionType.ITEMS_IN_PAIR:
				new PairPromotions().setPromotionDetail();
				break;
			default:
				CustomerInputs.notifyForWrongEntry();
				break;
		}
		return promotion;
	}
}
