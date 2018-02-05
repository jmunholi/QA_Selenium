package selenium.ecommerce.pageobjects;

import org.junit.Assert;

public class BuyNewItemIT extends Pages {

	// Main functions
	public void buyItem(String item, int qtd, String paymentType) throws InterruptedException {
		searchItem(item);
		checkSearchResult(item);
		goToItemDetailsPage(item);
		clickOnAddToBag();
		finishPurchase(qtd, paymentType);
	}

	// supporting functions
	public void searchItem(String item) {

		String searchBar = ".//*[@id='ctl00_TopBar_PaginaSistemaArea1_ctl17_ctl00_txtBusca']";
		String btsSearch = ".//*[@id='ctl00_TopBar_PaginaSistemaArea1_ctl17_ctl00_btnOK']";

		waitForComponentVisible(searchBar);
		clickOn(searchBar);
		sendKeys(searchBar, item);
		clickOn(btsSearch);
	}

	public void checkSearchResult(String item) {
		String ItemResult = findElement(".//h3[contains(text(),'" + item + "')]");

		if (!ItemResult.contains(item)) {
			Assert.assertTrue(false);
		}
	}

	public void checkQuantityUnits(int qtd) {
		String QtdItens = Integer.valueOf(qtd).toString();
		String QtdItensSelected = findElement(".//*[@data-id='qtdeSku']");

		if (!QtdItens.equals(QtdItensSelected)) {
			clearField(QtdItensSelected);
			sendKeys(QtdItensSelected, QtdItens);
			clickOn(".//body");
		}
	}

	public void goToItemDetailsPage(String item) {
		String xpath = ".//h3[contains(text(),'" + item + "')]";
		waitForComponentVisible(xpath);
		clickOn(xpath);
	}

	public void clickOnAddToBag() {
		clickOn(".//*[@id='btnAdicionarCarrinho']");
		waitForComponentVisible(".//*[@data-id='linkNaoObrigado']");
		clickOn(".//*[@data-id='linkNaoObrigado']");
	}

	public void finishPurchase(int qtdItens, String paymentType) throws InterruptedException {
		checkQuantityUnits(qtdItens);

		// Step 1: finish purchase - Indentification
		String identifyPath = ".//div[@data-id='content']//div[@class='concluirCompra'][1]//a[@data-id='btnComprar']";
		waitForComponentVisible(identifyPath);
		Thread.sleep(2000);
		clickOn(identifyPath);

		// Step 2: Confirm Address
		String addressyPath = ".//div[@class='boxResumoTopo']//div[@class='boxResumoBtb'][1]//input[@data-id='endereco_salvar']";
		waitForComponentVisible(addressyPath);
		clickOn(addressyPath);

		// Step 3: Select Payment
		selectPayment(paymentType);
	}

	public void selectPayment(String payment) throws InterruptedException {

		waitForComponentVisible(".//h2[text()='Pagamento']");
		Thread.sleep(2300);
		payment = payment.toUpperCase();
		if (payment.equals("CRÉDITO")) {
			closeStockPopUps();
			waitForComponentToBeClickable(".//a[@title='Cartão de crédito']");
			clickOn(".//a[@title='Cartão de crédito']");
		}
	}

	public void closeStockPopUps() {
		String xpath = ".//*[contains(text(),'Alerta de Estoque')]";
		try {
			if(!getElementText(xpath).equals(null))
				clickOn(".//*[contains(text(),'×')]");
			Thread.sleep(800);
		} catch (Exception e) {

		}
	}
}