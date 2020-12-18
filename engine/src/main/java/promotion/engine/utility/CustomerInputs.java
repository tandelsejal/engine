package promotion.engine.utility;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This class is used for taking order list from the user
 * */
public class CustomerInputs {
	public static HashMap<Character, Integer> takeCustomerInputs() {
		HashMap<Character, Integer> order = new HashMap<>();
		System.out.println("\n\n\nLet us Now Take a Order List...!!\nEnter done once you done with list..!!\nEnter space saperated SKU Id and Quantity :");
		String sTemp = new Scanner(System.in).nextLine();
		while(!sTemp.equalsIgnoreCase("done")) {
			String data[] = sTemp.split(" ");
			if(data.length >= 2) {
				try {
					char item = sTemp.split(" ")[0].charAt(0);
					int quantity = Integer.parseInt(sTemp.split(" ")[1]);
					order.put(item, quantity);
				}
				catch (Exception e) {
					notifyForWrongEntry();
				}
			}
			else {
				notifyForWrongEntry();
			}
			sTemp = new Scanner(System.in).nextLine();
		}
		return order;
	}
	public static void notifyForWrongEntry() {
		System.out.println("Wrong detail...!!Enter It again");
	}
}
