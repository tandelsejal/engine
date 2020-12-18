package promotion.engine.factory;

import java.util.HashMap;

/**
 * This class properties and behaviour of promotion type in the system
 * */
public abstract class Promotion {
	/**
	 * Set Promotion detail Based on the type of it
	 * */
	public abstract void setPromotionDetail();
	
	/**
	 * Apply Promotion type and calculate total price based
	 * */
	public abstract double getPrice(char item, HashMap<Character, Integer> temporder);
	
	/**
	 * Check the validity of Promotion type on given order list
	 * */
	public abstract boolean isValid(char item, HashMap<Character, Integer> temporder);
}
