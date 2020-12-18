package promotion.engine.utility;

import java.util.HashMap;
import java.util.Scanner;

public class CustomerInputs {
	public static HashMap<Character, Integer> takeCustomerInputs() {
		HashMap<Character, Integer> order = new HashMap<>();
		System.out.println("Enter SKU Id and Quanity Space separted..!! \n Enter done after completing list..!!");
		String sTemp = new Scanner(System.in).nextLine();
		while(!sTemp.equalsIgnoreCase("done")) {
			char item = sTemp.split(" ")[0].charAt(0);
			int quantity = Integer.parseInt(sTemp.split(" ")[1]);
			order.put(item, quantity);
			sTemp = new Scanner(System.in).nextLine();
		}
		return order;
	}
}
