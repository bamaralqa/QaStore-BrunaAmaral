package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarrinhoPO extends BasePO{
    /*campo de inserir cupom no carrinho */
    @FindBy(id = "usarCupom")
    public WebElement inputCupom;

    /*campo de validação do cupom */
    @FindBy(css = "#corpo > div > div.secao-principal.row-fluid > div > div.caixa-sombreada > table > tbody > tr.bg-dark.possui-cupom > td:nth-child(1) > div > span")
    public WebElement spanCupom;

    /*desconto abaixo do Subtotal */
    @FindBy(css = "data-cupom-desconto-codigo")
    public WebElement descontoAplicado;

    /*mensagem de erro */
    @FindBy(xpath = "//div[@id='corpo']/div/div[1]")
    public WebElement mensagem;


    /**
     * Construtor para criação da pagina QaStore
     * @param driver Driver da pagina QaStore
     */
    public CarrinhoPO(WebDriver driver) {
        super(driver);
    }
    
     /**
      * Método que irá escrever o texto do cupom e dar enter.
     * @param textoCupom 
      */
      public void escrever( WebElement inputCupom, String textoCupom){
        inputCupom.sendKeys(textoCupom +Keys.ENTER );
    }
     /**
      * Método irá pegar o texto do span do Cupom inserido 
      * @return
      */
    public String obterSpanCupom(){
        return spanCupom.getText();
    }

     /**
      * Método irá pegar o texto do desconto inserido abaixo do Subtotal
      * @return
      */
      public String obterDescontoAplicado(){
        return descontoAplicado.getText();
    }

    /**
     * Método irá pegar texto da mensagem de erro
     * @return mensagem de erro
     */
    public String obterMensagem(){
        return mensagem.getText();


    }

}
