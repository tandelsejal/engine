package promotion.engine.utility;

import java.util.Scanner;

import promotion.engine.beans.PromotionType;
import promotion.engine.factory.Promotion;
import promotion.engine.factory.PromotionFactory;

/**
 * Initialize Promotion types
 */
public class InitializePromotoinsType {
	private InitializePromotoinsType() {
		throw new IllegalStateException("This is a utility class");
	}
	
	public static void addPromotionTypeDetails() {
		System.out.println("Select promotion types from below choice(1 to 3): ");
		System.out.println(PromotionType.N_ITEMS+" N_ITEMS");
		System.out.println(PromotionType.ITEMS_IN_PAIR+" ITEMS_IN_PAIR");
		System.out.println(PromotionType.PERCENT_OF_ITEM+" PERCENT_OF_ITEM");
		int item =  new Scanner(System.in).nextInt();
		PromotionFactory.setPromotionObject(item);
	}
}
