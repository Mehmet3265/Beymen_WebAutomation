package beymen.pages;

import beymen.utilities.Driver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.crypto.dsig.spec.XPathType;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class BasePage {

    public BasePage(){
     PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "div[aria-haspopup='listbox'] input")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@title=\"Hesabım\"]")
    public WebElement hesabım;

    @FindBy(xpath = "//a[@title=\"Favorilerim\"]")
    public WebElement favorilerim;

    @FindBy(xpath = "//a[@title=\"Sepetim\"]")
    public WebElement sepetim;




   public String cellValue (int rowNum, int cellNum)  {
      try {
           FileInputStream input = new FileInputStream("C:\\Users\\mehme\\IdeaProjects\\Beymen_WebAutomation\\src\\test\\resources\\features\\products.xlsx");
           Workbook workbook = new XSSFWorkbook(input);
           Sheet sheet = workbook.getSheetAt(0);
           Row row = sheet.getRow(rowNum);
           Cell cell = row.getCell(cellNum);
           String value = cell.getStringCellValue();
           return value;
      }catch (Exception e) {
          return e.getMessage();
       }

}

public void keyboardEnter(){
    try {
        Robot robot = new Robot();

        // Enter tuşunu basmak için
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // İşlem bittikten sonra robot nesnesini serbest bırakın
        robot.setAutoDelay(1000); // İstediğiniz gecikmeyi ayarlayabilirsiniz
    } catch (AWTException e) {
        e.printStackTrace();
    }
}


}
