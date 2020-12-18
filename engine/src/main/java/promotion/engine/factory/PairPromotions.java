package promotion.engine.factory;

import java.util.HashMap;
import java.util.Scanner;

import promotion.engine.utility.InitializePromotoinsType;

public class PairPromotions extends Promotion{
	private char item1;
	private char item2;
	private double price;
	
	public PairPromotions(char item1, char item2, double price) {
		this.item1 = item1;
		this.item2 = item2;
		this.price = price;
	}
	
	public PairPromotions() {
	}

	@Override
	public void setPromotionDetail() {
		System.out.println("Enter item1, item2 and price by space seperation");
		String sTemp = new Scanner(System.in).nextLine();
		char item1 = sTemp.split(" ")[0].charAt(0);
		char item2 = sTemp.split(" ")[1].charAt(0);
		double price = Double.parseDouble(sTemp.split(" ")[2]);
		Promotion prom = new PairPromotions(item1, item2, price);
		InitializePromotoinsType.addDataInDataStructure(item1, prom);
		InitializePromotoinsType.addDataInDataStructure(item2, prom);
	}

	@Override
	public double getPrice(char item, HashMap<Character, Integer> order) {
		int min = Math.min(order.get(this.item1), order.get(this.item2));
		double amount = this.price * min;
		if(order.get(this.item1) > min) {
			order.put(this.item1, order.get(this.item1)-min);
		}
		else {
			order.remove(this.item1);
		}
		if(order.get(this.item2) > min) {
			order.put(this.item2, order.get(this.item2)-min);
		}
		else {
			order.remove(this.item2);
		}
		return amount;
	}

	@Override
	public boolean isValid(char item, HashMap<Character, Integer> order) {
		if( (item == this.item1 && order.containsKey(this.item2)) || 
				(item == this.item2 && order.containsKey(this.item1))) {
			return true;
		}
		return false;
	}
}
