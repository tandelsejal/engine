package promotion.engine;

import java.util.HashMap;

import promotion.engine.processor.ProcessOrder;
import promotion.engine.utility.CustomerInputs;
import promotion.engine.utility.InitializePromotoinsType;
import promotion.engine.utility.InitializeUnits;

/**
 * Application start from here
 *
 */
public class App {
	public static void main(String[] args) {
		InitializeUnits.addSKUPriceDetail();
		InitializePromotoinsType.addPromotionTypeDetails();
		HashMap<Character, Integer> order = CustomerInputs.takeCustomerInputs();
		System.out.println( "Amount : " + ProcessOrder.processOrder(order) );
	}
}
