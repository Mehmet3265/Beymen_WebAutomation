package beymen.pages;

import beymen.utilities.BrowserUtils;
import beymen.utilities.Driver;
import com.github.dockerjava.core.exec.WaitContainerCmdExec;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//span[@class=\"o-productDetail__description\"]")
    public WebElement pruductInfo;

    @FindBy(xpath = "//ins[@id=\"priceNew\"]")
    public WebElement productPrice;

    @FindBy(xpath = "//span[contains(@class,\"m-variation__item\")]")
    public List<WebElement> sizes;

    @FindBy(xpath = "//button[@id=\"addBasket\"]")
    public WebElement addButton;

    @FindBy(xpath = "//a[@title=\"Sepetim\"]")
    public WebElement myBasket;

    @FindBy (xpath = "//use[@xlink:href=\"#icon-close\"]")
    public WebElement closeIcon;

    @FindBy(xpath ="//div[@class=\"m-productPrice__content\"]/span")
    public WebElement basketPrice;
    @FindBy(xpath ="//div[@data-page=\"1\"]" )
    public List<WebElement> gömlekler;


}
