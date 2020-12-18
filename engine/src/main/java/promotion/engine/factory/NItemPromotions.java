package promotion.engine.factory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import promotion.engine.beans.DataBean;
import promotion.engine.utility.InitializePromotoinsType;

public class NItemPromotions extends Promotion {
	private char item;
	private int count;
	private double price;
	
	public NItemPromotions(char item, int count, double price) {
		this.item = item;
		this.count = count;
		this.price = price;
	}

	public NItemPromotions() {
	}

	@Override
	public void setPromotionDetail() {
		System.out.println("Enter SKU ID, Count and price by space seperation");
		String[] sTemp = new Scanner(System.in).nextLine().split(" ");
		if(sTemp.length >= 3) {
			char item = sTemp[0].charAt(0);
			int count = Integer.parseInt(sTemp[1]);
			double price = Double.parseDouble(sTemp[2]);
			Promotion prom = new NItemPromotions(item, count, price);
			InitializePromotoinsType.addDataInDataStructure(item, prom);
		}
		else {
			System.out.println("Wrong input");
			setPromotionDetail();
		}
	}

	@Override
	public boolean isValid(char item, HashMap<Character, Integer> temporder) {
		if(temporder.get(item) >= this.count) {
			return true;
		}
		return false;
	}

	@Override
	public double getPrice(char item, HashMap<Character, Integer> temporder) {
		int total = temporder.get(item);
		double amount = this.price * (total/this.count);
		if(total % this.count != 0) {
			temporder.put(item, total % this.count);
		}
		else {
			temporder.remove(item);
		}
		return amount;
	}
}
