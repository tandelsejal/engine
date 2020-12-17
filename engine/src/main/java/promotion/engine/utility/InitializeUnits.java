package promotion.engine.utility;

import java.util.Scanner;

import promotion.engine.beans.DataBean;

/**
 * Initialize Unit price for SKU IDs
 */
public class InitializeUnits {
	private InitializeUnits() {
		throw new IllegalStateException("This is a utility class");
	}

	public static void addSKUPriceDetail() {
		
		System.out.println("Enter No of SKU : ");
		int item =  new Scanner(System.in).nextInt();
		
		System.out.println("Enter unit and price by space seperation");
		for(int iter = 0; iter < item; iter++) {
			
			String temp =  new Scanner(System.in).nextLine();
			DataBean.units.put(temp.split(" ")[0].charAt(0), Double.parseDouble(temp.split(" ")[1]));
		} 
	}
}
