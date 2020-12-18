package promotion.engine;

import java.util.HashMap;

import promotion.engine.processor.ProcessOrder;
import promotion.engine.utility.CustomerInputs;
import promotion.engine.utility.InitializePromotoinsType;
import promotion.engine.utility.InitializeUnits;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		InitializeUnits.addSKUPriceDetail();
		InitializePromotoinsType.addPromotionTypeDetails();
		HashMap<Character, Integer> order = CustomerInputs.takeCustomerInputs();
		double amount = ProcessOrder.processOrder(order);
	}
	
}
