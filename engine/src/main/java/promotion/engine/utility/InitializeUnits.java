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
		System.out.println("Let us add SKU Detail...!!\nEnter total number of SKU :");
		try {
			int item = new Scanner(System.in).nextInt();
	
			System.out.println("Enter space seperated SKU Id and price corresponding to it :");
			for (int iter = 0; iter < item;) {
				System.out.println("SKU " + (iter + 1));
				
				String temp[] = new Scanner(System.in).nextLine().split(" ");
				if (temp.length >= 2) {
					try {
						DataBean.units.put(temp[0].charAt(0), Double.parseDouble(temp[1]));
						iter++;
					} catch (Exception e) {
						CustomerInputs.notifyForWrongEntry();
					}
				} else {
					CustomerInputs.notifyForWrongEntry();
				}
			}
		}
		catch (Exception e) {
			CustomerInputs.notifyForWrongEntry();
			addSKUPriceDetail();
		}
	}

	
}
