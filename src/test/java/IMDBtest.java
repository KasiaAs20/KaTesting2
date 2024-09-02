import com.codeborne.selenide.*;
import org.junit.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class IMDBtest {



    @Test
    public void searchIMDB() throws Exception {

        Configuration.browser = "Edge";

        open("https://google.com/");

        $(byText("Zaakceptuj wszystko")).click();
        $(By.name("q")).setValue("IMDb");
        $(By.name("btnK")).click();

        open("<https://www.imdb.com/search/name/?birth_monthday=  07-15>");
        ElementsCollection celebNames = $$(By.tagName("h3"));

        for (int i = 0; i < 5; i++) {
            String celebSumm = celebNames.get(i).getText();
            System.out.println(celebSumm);

        }


    }
    @Test
    public void findTitanic() throws Exception {
        Configuration.browser = "Edge";

        open("https://www.imdb.com/");

        //$(byText("Zaakceptuj wszystko")).click();
        $(By.name("q")).setValue("Oscars ").setValue("Best Cinematography of 1997 ").setValue("Titanic").pressEnter();

    }
    @Test
    public void checkIfActorsAreTheSame() throws Exception {
        int actorsTheSameCount = 0;
        Configuration.browser = "Edge";

        open("https://www.imdb.com/");
        $(byText("Accept")).pressEnter();

        $(byName("q")).setValue("Titanic").pressEnter();
        String titanicPage = $(By.className("ipc-metadata-list-summary-item__t")).getAttribute("href");
        open(titanicPage);

        ElementsCollection titanicActors = $$(By.className("sc-bfec09a1-1"));
        for (SelenideElement e : titanicActors) {
            System.out.println(e.getText());
        }


        $(byName("q")).setValue("Revolutionary Road").pressEnter();
        String revolutionaryRoadPage = $(By.className("ipc-metadata-list-summary-item__t")).getAttribute("href");
        open(revolutionaryRoadPage);


        ElementsCollection revolutionaryRoadActors = $$(By.className("sc-bfec09a1-1"));


        for (SelenideElement f : revolutionaryRoadActors) {
            System.out.println(f.getText());


        }
        /*         I don't know why this code not work fine:(        */
        for (SelenideElement e : titanicActors) {
            for (SelenideElement f : revolutionaryRoadActors) {
                if (e.getText().equals(f.getText()))
                    actorsTheSameCount++;

            }
        }


        System.out.println("Actors the same in both movies are" + " " + actorsTheSameCount);


    }
}




