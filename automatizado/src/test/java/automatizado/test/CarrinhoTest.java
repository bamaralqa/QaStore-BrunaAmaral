package automatizado.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

import automatizado.page.CarrinhoPO;

public class CarrinhoTest extends BaseTest{
    
    private static CarrinhoPO carrinhoPage;
    
   
    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://qastoredesafio.lojaintegrada.com.br/carrinho/produto/118475040/adicionar");
        carrinhoPage = new CarrinhoPO(driver);
    }

    @Test
    public void CT001_deveAplicarCupomFRETEGRATIS(){
        iniciar();
        String textoCupom = "FRETEGRATIS";

        carrinhoPage.escrever(carrinhoPage.inputCupom, textoCupom);

        String spanCupom = carrinhoPage.obterSpanCupom();
        assertEquals(textoCupom, spanCupom);
        finalizar();
    }

    @Test
    public void CT002_deveAplicarCupom10OFF(){
        iniciar();
        String textoCupom = "10OFF";

        carrinhoPage.escrever(carrinhoPage.inputCupom, textoCupom);

        String spanCupom = carrinhoPage.obterSpanCupom();
        assertEquals(textoCupom, spanCupom);
        finalizar();
    }

    @Test
    public void CT003_deveAplicarCupom30REAIS(){
        iniciar();
        String textoCupom = "30REAIS";

        carrinhoPage.escrever(carrinhoPage.inputCupom, textoCupom);

        String spanCupom = carrinhoPage.obterSpanCupom();
        assertEquals(textoCupom, spanCupom);
        finalizar();
    }


    @Test
    public void CT008_naoDeveAplicarDescontoCupomInvalido(){
        iniciar();
        String textoCupom = "20REAIS";
        String textoMensagem = "Cupom não encontrado.";

        carrinhoPage.escrever(carrinhoPage.inputCupom, textoCupom);
        String mensagem = carrinhoPage.obterMensagem();
        
        System.out.println(mensagem);
        
        assertEquals(textoMensagem , mensagem );
        finalizar();

    }

    @Test
    public void CT009_naoDeveAplicarDescontoComCupomVazio(){
        iniciar();
        String textoMensagem = "Cupom não informado.";

        carrinhoPage.inputCupom.click();
        carrinhoPage.inputCupom.sendKeys(Keys.ENTER);

        String mensagem = carrinhoPage.obterMensagem();

        System.out.println(mensagem);

        assertEquals(textoMensagem, mensagem);
        finalizar();

    }

  


}

    
