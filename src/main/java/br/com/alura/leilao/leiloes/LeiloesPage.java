package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends PageObject {


    public LeiloesPage(WebDriver navegador) {
        super(navegador);
    }

    public boolean isLeilaoCadastrado(String nome, String  valor, String data){
        WebElement linhaDaTabela = this.navegador.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome)
                && colunaDataAbertura.getText().equals(data)
                && colunaValorInicial.getText().equals(valor);
    }

    public CadastroLeilaoPage carregarFormulario(){
        this.navegador.navigate().to(URL_CADASTROLEILAO);
        return new CadastroLeilaoPage(navegador);
    }

    public boolean isPaginaAtual(){
        return navegador.getCurrentUrl().equals(URL_LEILAO);
    }


}
