package promotion.engine;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import promotion.engine.processor.ProcessOrder;
import promotion.engine.utility.CustomerInputs;
import promotion.engine.utility.InitializePromotoinsType;
import promotion.engine.utility.InitializeUnits;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private static HashMap<Character, Integer> order;
	@BeforeClass
	public static void initalizeSystemDetail() {
		InitializeUnits.addSKUPriceDetail();
		InitializePromotoinsType.addPromotionTypeDetails();
		order = CustomerInputs.takeCustomerInputs();
	}
	/**
     * Rigorous Test :-)
     */
    @Test
    public void totalOrder()
    {
        assertEquals(150.0, ProcessOrder.processOrder(order));
    }
}
