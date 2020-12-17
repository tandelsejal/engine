package promotion.engine.beans;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import promotion.engine.factory.Promotion;

/**
 * This class will work as in memory database
 * */
public class DataBean {
	
	/** Store information regarding single unit price*/
	public static ConcurrentHashMap<Character, Double> units = new ConcurrentHashMap<>();
	
	/** Store current SKU wise promotions*/
	public static ConcurrentHashMap<Character, Set<Promotion>> promotionTypes = new ConcurrentHashMap<>();
}
