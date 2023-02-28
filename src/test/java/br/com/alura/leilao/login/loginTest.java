package br.com.alura.leilao.login;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class loginTest {

    private LoginPage paginaDeLogin;


    @BeforeEach
    public void befoErach() {
        this.paginaDeLogin = new LoginPage();
    }

    @After
    public void affeterEach() {
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        paginaDeLogin.preencheFormularioDelogin("fulano", "pass");
        paginaDeLogin.efetuaLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
        paginaDeLogin.fechar();
    }

    @Test
    public void naoDeveriaLogarCpmDadosInvalidos() {

        paginaDeLogin.preencheFormularioDelogin("invalido", "123");
        paginaDeLogin.efetuaLogin();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
        Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));

        paginaDeLogin.fechar();
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaDeLogin.navegaParaPaginaDeLances();


        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
        paginaDeLogin.fechar();
    }


}