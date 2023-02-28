package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class CadastroLeilaoPage extends PageObject {

    public CadastroLeilaoPage(WebDriver navegador){
        super(navegador);
    }


    public LeiloesPage CadastroLeilaoPage(String nome, String valor, String dataAbertura) {
        navegador.findElement(By.id("nome")).sendKeys(nome);
        navegador.findElement(By.id("valorInicial")).sendKeys(valor);
        navegador.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        navegador.findElement(By.id("button-submit")).click();
        return new LeiloesPage(navegador);
    }

    public boolean isPaginaAtual() {
        return navegador.getCurrentUrl().equals(URL_CADASTROLEILAO);
    }


    public boolean isMEnsagensDevalidacaoVisiveis() {
        String pageSource = navegador.getPageSource();
        return pageSource.contains("minimo 3 caracteres")
                && pageSource.contains("não deve estar em branco")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }

    public void tiraPrintDoResultado() throws IOException {
        UUID uuid = UUID.randomUUID();
        String fileName = "screenshot_" + uuid.toString() + ".png";
        File screenshotFile = ((TakesScreenshot) this.navegador).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(screenshotFile, new File("cenariodetesteprint/" + fileName));
    }

}
