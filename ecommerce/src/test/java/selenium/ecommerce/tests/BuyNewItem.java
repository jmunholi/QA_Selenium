package selenium.ecommerce.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import selenium.ecommerce.commons.Base;

/* Access Ecommerce main page
 * Search an item (delay?)
 * item found : ?
 * Select item ==> product Details
 * Add to bag
 * next step
 * select credit card as payment method
 * fill all fields and finish action
 * close browser
 */
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
}
