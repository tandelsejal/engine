package promotion.engine.utility;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import promotion.engine.beans.DataBean;
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
		giveOptionsOfPromotionTypes();
		String stemp = new Scanner(System.in).nextLine();
		while(!stemp.equalsIgnoreCase("done")) {
			try {
				int item = Integer.parseInt(stemp);
				PromotionFactory.setPromotionObject(item);
			}
			catch (Exception e) {
				CustomerInputs.notifyForWrongEntry();
			}
			stemp = new Scanner(System.in).nextLine();
		}
	}
	
	private static void giveOptionsOfPromotionTypes() {
		System.out.println("\n\n\nLet us add Promotion Types Now..!!\nWe are having below choice here..!");
		System.out.println(PromotionType.N_ITEMS+" - N_ITEMS");
		System.out.println(PromotionType.ITEMS_IN_PAIR+" - ITEMS_IN_PAIR");
		System.out.println("Enter done once you done with addition");
		System.out.println("\nChoose option :");
	}

	public static void addDataInDataStructure(char item, Promotion prom) {
		Set<Promotion> set;
 		if(DataBean.promotionTypes.containsKey(item)) {
 			set = DataBean.promotionTypes.get(item);
 			set.add(prom);
 			DataBean.promotionTypes.put(item, set);
		}
		else {
			set = new HashSet<>();
 			set.add(prom);
 			DataBean.promotionTypes.put(item, set);
		}
	}
}
