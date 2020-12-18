package promotion.engine;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import promotion.engine.beans.DataBean;
import promotion.engine.factory.NItemPromotions;
import promotion.engine.factory.PairPromotions;
import promotion.engine.factory.Promotion;
import promotion.engine.processor.ProcessOrder;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static HashMap<Character, Integer> order;

	@BeforeClass
	public static void initalizeSystemDetail() {
		
		/**Test Customer input functions
		InitializeUnits.addSKUPriceDetail();
		InitializePromotoinsType.addPromotionTypeDetails();
		order = CustomerInputs.takeCustomerInputs();
		*/
		
		/**In memory database initialization */
		DataBean.units = new ConcurrentHashMap<Character, Double>();
		DataBean.units.put('A', 50.0);
		DataBean.units.put('B', 30.0);
		DataBean.units.put('C', 20.0);
		DataBean.units.put('D', 15.0);
		
		DataBean.promotionTypes = new ConcurrentHashMap<>();
		Promotion prom = new NItemPromotions('A',3,130.0);
		Set<Promotion> set = new HashSet<>();
		set.add(prom);
		DataBean.promotionTypes.put('A', set);
		prom = new NItemPromotions('B',2,45.0);
		set = new HashSet<>();
		set.add(prom);
		DataBean.promotionTypes.put('B', set);
		prom = new PairPromotions('C','D',30.0);
		set = new HashSet<>();
		set.add(prom);
		DataBean.promotionTypes.put('C', set);
		DataBean.promotionTypes.put('D', set);
	}
	

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void totalOrder1() {
		order = new HashMap<Character, Integer>();
		order.put('A', 1);
		order.put('B', 1);
		order.put('C', 1);
		assertEquals(100.0d, ProcessOrder.processOrder(order),0.0000001);
	}
	
	@Test
	public void totalOrder2() {
		order = new HashMap<Character, Integer>();
		order.put('A', 5);
		order.put('B', 5);
		order.put('C', 1);
		assertEquals(370.0d, ProcessOrder.processOrder(order),0.0000001);
	}
	
	@Test
	public void totalOrder3() {
		order = new HashMap<Character, Integer>();
		order.put('A', 3);
		order.put('B', 5);
		order.put('C', 1);
		order.put('D', 1);
		assertEquals(280.0d, ProcessOrder.processOrder(order),0.0000001);
	}
}
