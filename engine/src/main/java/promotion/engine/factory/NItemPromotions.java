package promotion.engine.factory;

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
	public double getPrice(Promotion promotion) {

		return 0;
	}

	@Override
	public void setPromotionDetail() {
		System.out.println("Enter SKU ID, Count and price by space seperation");
		String sTemp = new Scanner(System.in).nextLine();
		char item = sTemp.split(" ")[0].charAt(0);
		int count = Integer.parseInt(sTemp.split(" ")[1]);
		double price = Double.parseDouble(sTemp.split(" ")[2]);
		Promotion prom = new NItemPromotions(item, count, price);
		InitializePromotoinsType.addDataInDataStructure(item, prom);
	}
}
