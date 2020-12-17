package promotion.engine.factory;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import promotion.engine.beans.DataBean;

public class NItemPromotions extends Promotion {
	private char item;
	private int count;

	public NItemPromotions(char item, int count) {
		this.item = item;
		this.count = count;
	}

	public NItemPromotions() {
	}

	@Override
	public double getPrice(Promotion promotion) {

		return 0;
	}

	@Override
	public void setPromotionDetail() {
		System.out.println("Enter SKU ID and Count by space seperation");
		String sTemp = new Scanner(System.in).nextLine();
		char item = sTemp.split(" ")[0].charAt(0);
		int count = Integer.parseInt(sTemp.split(" ")[1]);
		Promotion prom = new NItemPromotions(item, count);
		Set<Promotion> set;
 		if(DataBean.promotionTypes.containsKey(item)) {
 			set = DataBean.promotionTypes.get(item);
 			set.add(prom);
 			DataBean.promotionTypes.put(item, set);
		}
		else {
			set = new HashSet<>();
 			set.add(prom);
 			DataBean.promotionTypes.put(item, set);
		}
	}
}
