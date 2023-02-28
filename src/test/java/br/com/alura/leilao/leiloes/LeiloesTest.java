package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class LeiloesTest {
    private LeiloesPage paginaDeleiloes;
    private CadastroLeilaoPage paginaDeCadastro;


    @BeforeEach
    public void beforeEach() {
        LoginPage loginPage = new LoginPage();
        loginPage.preencheFormularioDelogin("fulano", "pass");

        this.paginaDeleiloes = loginPage.efetuaLogin();
        this.paginaDeCadastro = this.paginaDeleiloes.carregarFormulario();
    }

    @AfterEach
    public void affeterEach() {
        this.paginaDeleiloes.fechar();
    }

    @Test
    public void deveriaCadastrarLeilao() {
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + hoje;
        String valor = "500.00";

        this.paginaDeleiloes = paginaDeCadastro.CadastroLeilaoPage(nome, valor, hoje);
        Assert.assertTrue(paginaDeleiloes.isLeilaoCadastrado(nome, valor, hoje));

    }

    @Test
    public void deveriaValidarCadastroDeLeilao() throws IOException {
        this.paginaDeleiloes = paginaDeCadastro.CadastroLeilaoPage("", "", "");

        Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
        Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
        Assert.assertTrue(this.paginaDeCadastro.isMEnsagensDevalidacaoVisiveis());

    }

}