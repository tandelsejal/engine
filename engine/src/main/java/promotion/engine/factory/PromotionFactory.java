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
				new PairPromotions().setPromotionDetail();
				break;
			default:
				System.out.println("Wrong Choice...!!");
				break;
		}
		return promotion;
	}
}
