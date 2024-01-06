package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReactJSSteps {

	public WebDriver driver;

	@Given("I navigate to React JS site")
    public void iNavigateToReactJSSite() {
	    System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://legacy.reactjs.org/");
	   }

    @When("I click on Docs Tab")
    public void clickOnDocsTab() {
        WebElement docsTab = driver.findElement(By.linkText("Docs"));
        docsTab.click();
    }

    @Then("I extract and save Concepts sub-elements in a file")
    public void extractAndSaveConcepts() throws IOException {
        extractAndSaveSubElements("Concepts");
    }

    @Then("I extract and save Advanced Guides sub-elements in a file")
    public void extractAndSaveAdvancedGuides() throws IOException {
        extractAndSaveSubElements("AdvancedGuides");
    }

    public void extractAndSaveSubElements(String tabName) throws IOException {
        WebElement mainTab = driver.findElement(By.xpath("//a[text()='" + tabName + "']"));
        mainTab.click();

        List<WebElement> subElements = driver.findElements(By.xpath("//a[@class='navListItem_1e5F']"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tabName + "_SubElements.txt"));

        for (WebElement subElement : subElements) {
            String text = subElement.getText();
            writer.write(text + "\n");
        }

        writer.close();
    }
}