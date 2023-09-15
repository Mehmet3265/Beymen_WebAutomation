package beymen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{
    @FindBy(xpath = "//div[@class=\"m-select -small\"]")
    public WebElement pieceDropdown;

    @FindBy(xpath = "//button[@id=\"removeCartItemBtn0-key-0\"]")
    public WebElement deleteButton;

    @FindBy(xpath = "//strong[@class=\"m-empty__messageTitle\"]")
    public WebElement noProductMessage;
}
