package br.com.alura.leilao.login;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class HelloWorldSelenium {

    @Test
    public void hello(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("http://localhost:8080/leiloes");
        navegador.quit();

    }

}