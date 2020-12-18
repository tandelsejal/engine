package promotion.engine.factory;

import java.util.HashMap;
import java.util.Scanner;

import promotion.engine.utility.CustomerInputs;
import promotion.engine.utility.InitializePromotoinsType;

/**
 * Promotion Class for provide promotion on Same Type of Items 
 * */
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
		System.out.println("\nEnter space seperated SKU id, Count and Price :");
		String[] sTemp = new Scanner(System.in).nextLine().split(" ");
		if(sTemp.length >= 3) {
			try {
				char item = sTemp[0].charAt(0);
				int count = Integer.parseInt(sTemp[1]);
				double price = Double.parseDouble(sTemp[2]);
				Promotion prom = new NItemPromotions(item, count, price);
				InitializePromotoinsType.addDataInDataStructure(item, prom);
			}
			catch (Exception e) {
				CustomerInputs.notifyForWrongEntry();
				setPromotionDetail();
			}
		}
		else {
			CustomerInputs.notifyForWrongEntry();
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
		removeCalculatedItem(total, temporder);
		return amount;
	}
	
	private void removeCalculatedItem(int total, HashMap<Character, Integer> temporder) {
		if(total % this.count != 0) {
			temporder.put(item, total % this.count);
		}
		else {
			temporder.remove(item);
		}
	}
}
