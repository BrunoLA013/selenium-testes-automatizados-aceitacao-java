package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected static final String URL_CADASTROLEILAO = "http://localhost:8080/leiloes/new";
    public static final String URL_LOGIN = "http://localhost:8080/login";
    public static final String URL_LEILAO = "http://localhost:8080/leiloes/2";

    protected WebDriver navegador;

    public PageObject(WebDriver navegador) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        if (navegador == null) {
            this.navegador = new ChromeDriver();
        } else {
            this.navegador = navegador;
        }
        this.navegador.manage().timeouts()
                .implicitlyWait(8, TimeUnit.SECONDS)
                .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void fechar() {
        this.navegador.quit();
    }
}


