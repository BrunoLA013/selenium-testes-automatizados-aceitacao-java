package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends PageObject {


    public LoginPage() {
        super(null);
        this.navegador.manage().window().maximize();
        this.navegador.navigate().to(URL_LOGIN);

    }


    public void preencheFormularioDelogin(String username, String password) {
        this.navegador.findElement(By.name("username")).sendKeys(username);
        this.navegador.findElement(By.name("password")).sendKeys(password);
    }

    public LeiloesPage efetuaLogin() {
        navegador.findElement(By.id("login-form")).submit();
        return new LeiloesPage(navegador);
    }

    public boolean isPaginaDeLogin() {
        return navegador.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean isPaginaDeLoginComDadosInvalidos() {
        return navegador.getCurrentUrl().equals(URL_LOGIN + "?error");
    }

    public Object getNomeUsuarioLogado() {
        try {
            return navegador.findElement(By.id("usuario")).getText();
        } catch (NoSuchContextException e) {
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        this.navegador.navigate().to(URL_LEILAO);
    }

    public boolean contemTexto(String texto) {
        return navegador.getPageSource().contains(texto);
    }


}
