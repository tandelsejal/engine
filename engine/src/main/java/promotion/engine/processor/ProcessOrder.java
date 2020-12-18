package promotion.engine.processor;

import java.util.ArrayList;
import java.util.HashMap;

import promotion.engine.beans.DataBean;
import promotion.engine.factory.Promotion;

/**
 * This class initialize the calculation process for orders
 */
public class ProcessOrder {
	
	public static double processOrder(HashMap<Character, Integer> order) {
		double amount = 0.0;
		ArrayList<Character> temp = new ArrayList<>(order.keySet());
		for (char item : temp) {
			while (order.containsKey(item) && order.get(item) > 0) {
				amount += calculateAmount(order, item);
			}
		}
		return amount;
	}

	private static double calculateAmount(HashMap<Character, Integer> order, char item) {
		double amount = 0;
		boolean bflag = false;
		
		if (DataBean.promotionTypes.containsKey(item)) {
			for (Promotion prom : DataBean.promotionTypes.get(item)) {
				if (prom.isValid(item, order)) {
					amount = prom.getPrice(item, order);
					bflag = true;
					break;
				}
			}
		}
		
		if (!bflag) {
			amount = DataBean.units.get(item) * order.get(item);
			order.remove(item);
		}
		return amount;
	}
}
