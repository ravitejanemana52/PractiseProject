package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class findMovieName extends baseMethods{
    private final By userRef = By.xpath("//*[@class='account-dropdown-button']");
    private final By movieNameSearch = By.xpath("//*[@class='icon-search']");
    private final By searchText = By.xpath("//*[@id='searchInput']");
    //*[@aria-label='Doctor Stranger']  //a[@aria-label]
    private final By getMovieList = By.xpath("//*[@id='row-0']//a");


    public findMovieName(WebDriver driver) {
        super(driver);
    }

    public void iFindTheMovieName(String name){
        explicitWait(userRef,20);
        try{
            driver.findElement(movieNameSearch).click();
            Thread.sleep(2000);
            driver.findElement(searchText).sendKeys(name);
            explicitWait(getMovieList,10);
            List<WebElement> elements = driver.findElements(getMovieList);

            List<String> namesList = new LinkedList<>();
            for(int i=0;i<elements.size();i++){
                namesList.add(elements.get(i).getAttribute("aria-label"));
//                if((elements.get(i).getAttribute("aria-label")).equalsIgnoreCase(name)){
//                    System.out.println("The movie "+name+" is available in Netflix.Grab your popcorn and enjoy");
//                }
            }
            if(namesList.contains(name)){
                    System.out.println("The movie "+name+" is available in Netflix.Grab your popcorn and enjoy");
            }
            else{
                System.out.println("We regret to tell you that the movie "+name+" is not available in Netflix.");
                System.out.println("Dont worry. Below are the suggestions available. Why dont you choose one and relax");
                System.out.println(namesList);
            }
//            namesList.forEach(lst -> {
//                System.out.println(lst);
//                        System.out.println("We regret to tell you that the movie is not available in Netflix.");
//                        System.out.println("Dont worry. Below are the suggestions available. Why dont you sit and relax");
//                        System.out.println(lst);
//                    });

        }
        catch(Exception e){
            System.out.println("No such movie "+name+" found and we regret we could not read your mind for suggestions");
            driver.quit();
        }
    }
    public void iClickOnTheMovie(String name){

    }
}
