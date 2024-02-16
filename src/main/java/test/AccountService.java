package test;

import org.json.JSONObject;

public class AccountService {
	
	public MyAccount myService(MyAccount myAccount){
		System.out.println(myAccount);
		MyAccount ma = new MyAccount();
		ma.setAmount(myAccount.getAmount() + 200);
		ma.setName(myAccount.getName());
		ma.setNumber(myAccount.getNumber());
		return ma;
		//myAccount.setAmount(myAccount.getAmount() + 200);
		//return myAccount;
	}

	public MyAccount processJson(String json) {
		MyAccount myAccount = new MyAccount();

		// Parse the JSON string into a JSONObject
		JSONObject jsonObj = new JSONObject(json);

		// Extract values from the JSONObject
		String name = jsonObj.optString("name");
		int number = jsonObj.optInt("number");
		int amount = jsonObj.optInt("amount");

		myAccount.setName(name);
		myAccount.setNumber(number);
		myAccount.setAmount(amount);

		return myAccount;
	}
}
