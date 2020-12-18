package promotion.engine.factory;

import java.util.HashMap;

/**
 * This class properties and behaviour of promotion type in the system
 * */
public abstract class Promotion {
	public abstract void setPromotionDetail();
	public abstract double getPrice(char item, HashMap<Character, Integer> temporder);
	public abstract boolean isValid(char item, HashMap<Character, Integer> temporder);
}
