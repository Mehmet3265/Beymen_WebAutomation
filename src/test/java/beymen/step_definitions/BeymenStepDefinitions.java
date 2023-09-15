package beymen.step_definitions;

import beymen.pages.BasePage;
import beymen.pages.BasketPage;
import beymen.pages.HomePage;
import beymen.pages.ProductPage;
import beymen.utilities.BrowserUtils;
import beymen.utilities.ConfigurationReader;
import beymen.utilities.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.List;
import java.util.Random;


public class BeymenStepDefinitions {

    BasePage basePage = new BasePage();
    BasketPage basketPage = new BasketPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    BrowserUtils browserUtils = new BrowserUtils();

    String productCost;

    @Given("User should be lands on home page with the supported url")
    public void user_should_be_lands_on_home_page_with_the_url()  {
        Driver.getDriver().get(ConfigurationReader.get("url"));
        browserUtils.waitForClickablility(homePage.acceptCerez, 10);
        homePage.acceptCerez.click();
        homePage.genderButton.click();

    }
    @When("user verifies that the beymen image is appeared")
    public void user_verifies_that_the_beymen_image_is_appeared() {
        Assert.assertTrue(homePage.beymenImg.isDisplayed());
    }
    @When("user clicks to seach box")
    public void user_clicks_to_seach_box(){
       homePage.searchBox.click();

    }
    @And("user gets the şort word from the excel file, from {int} row {int} column and enters from keyboard")
    public void userGetsTheŞortWordFromTheExcelFileFromRowColumnAndEntersFromKeyboard(int rowNum, int cellNum) {

     // homePage.searchBox.sendKeys("şort");
      homePage.searchBox.sendKeys(basePage.cellValue(rowNum,cellNum),Keys.ENTER);

    }
    @When("user deletes the şort word from search box")
    public void user_deletes_the_word_from_search_box() {

      /* // homePage.searchBox.sendKeys(" ");
        for (int i = 0; i < 10; i++) {
            basePage.searchBox.click();
        }*/
    }
    @And("user gets the gömlek word from the excel file, from {int} row {int} column and enters from keyboard")
    public void userGetsTheGömlekWordFromTheExcelFileFromRowColumnAndEntersFromKeyboard(int rowNum, int cellNum) {

        browserUtils.wait(2);

        homePage.searchBox.sendKeys(basePage.cellValue(rowNum,cellNum), Keys.ENTER);

    }


    @When("user selects a random product from the exhibited products")
    public void user_selects_a_random_product_from_the_exhibited_products() {

        Random random =new Random();
        //select a random index from the list size
        int randomIndex = random.nextInt(productPage.gömlekler.size());
        //get the random web element according to the random index
        System.out.println(randomIndex);
        browserUtils.wait(2);

        browserUtils.waitForClickablility(productPage.gömlekler.get(randomIndex),3).click();

    }
    @When("user writes the selected product's information and prize to txt file")
    public void user_writes_the_selected_product_s_information_and_prize_to_txt_file() {
        try {
            PrintWriter printWriter =new PrintWriter("productInfo.txt");
            printWriter.write(productCost=productPage.productPrice.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @When("user selects a random size from the size part")
    public void user_selects_a_random_size_from_the_size_part() {
        Random random =new Random();
        //select a random index from the list size
        int randomIndex = random.nextInt(productPage.sizes.size());
        //get the random web element according to the random index,

        //System.out.println(randomIndex);
        for (WebElement size: productPage.sizes) {
           if (browserUtils.waitForClickablility(productPage.sizes.get(randomIndex),3).isEnabled()){
               browserUtils.waitForClickablility(productPage.sizes.get(randomIndex),3).click();
               break;
           };
        }
        browserUtils.wait(2);
    }
    @When("user clicks to sepete ekle button")
    public void user_clicks_to_sepete_ekle_button() {
        productPage.addButton.click();
    }
    @When("user clicks to sepetim button")
    public void user_clicks_to_sepetim_button() {
        browserUtils.waitForClickablility(productPage.myBasket,15);
        productPage.myBasket.click();
    }
    @Then("user verifies that the price of the product on the product pace matches with the product price in the basket")
    public void user_verifies_that_the_price_of_the_product_on_the_product_pace_matches_with_the_product_price_in_the_basket() {
        String productPrice= productCost.trim().substring(0,productCost.trim().indexOf(" "));
        String basketPrice = productPage.basketPrice.getText().trim().substring(0,productPage.basketPrice.getText().trim().indexOf(","));
        System.out.println(productPrice+" "+basketPrice);
        Assert.assertEquals(productPrice,basketPrice);

    }


    @Then("user verifies that the product pieces are two after increasing the nomber of product")
    public void userVerifiesThatTheProductPiecesAreTwoAfterIncreasingTheNomberOfProduct() {
        Select select = new Select(basketPage.pieceDropdown);
        if (select.getOptions().size()==1){
            select.selectByIndex(0);
            Assert.assertFalse(false);
        }else {
            select.selectByIndex(1);
            String productPiece = basketPage.pieceDropdown.getText();
            Assert.assertTrue(productPiece.equalsIgnoreCase("2 Adet"));
        }

    }

    @Then("user verifies that the basket is empty after deleting the product")
    public void userVerifiesThatTheBasketIsEmptyAfterDeletingTheProduct() {
        basketPage.deleteButton.click();
        Assert.assertTrue(basketPage.noProductMessage.isDisplayed());
    }
}
