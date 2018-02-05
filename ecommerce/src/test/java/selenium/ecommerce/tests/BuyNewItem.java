package selenium.ecommerce.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import selenium.ecommerce.commons.Base;

@FixMethodOrder(MethodSorters.JVM)
public class BuyNewItem extends Base {

	String item = "Inspiron I11-3168-A10";
	String paymentType = "Crédito";
	int quantity = 1;
	String email = null;
	String pass = null;

	@Test
	public void buyItem() throws InterruptedException {

		buyNewItem.login(email, pass);
		buyNewItem.buyItem(item, quantity, paymentType);
	}

	@Test
	public void buyMoreThanOneItem() throws InterruptedException {

		buyNewItem.login(email, pass);
		buyNewItem.buyItem(item, 2, paymentType);
	}

	@Test
	public void removeItemFromBag() throws InterruptedException {
		// The value 0 will remove item from bag, otherwise it will just decrease qtd
		 // of itens for the selected here
//		
		buyNewItem.login(email, pass);
		buyNewItem.buyItem(item, quantity, paymentType);
		buyNewItem.removeItemFromBag(0); 

	}
}
