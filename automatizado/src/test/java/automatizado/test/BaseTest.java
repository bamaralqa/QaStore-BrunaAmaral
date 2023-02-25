package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança paratodas as classes de teste.
 */
public abstract class BaseTest {

    /** Driver navegador da pagina atual. */
    protected static WebDriver driver;

    /** Caminho base da URL do sistema a ser testado. */
    private static final String URL_BASE = "https://qastoredesafio.lojaintegrada.com.br/carrinho/produto/118475040/adicionar";
    /** Caminho relativo do driver ao projeto referente ao */
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v110.0.54.exe";


    /**
     * Metodo para iniciar o driver no navegador antes de qualquer classe de teste.
     */
    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Metodo para finalizar o driver no navegador depois de qualquer classe de teste.
     */
    @AfterClass
    public static void finalizar() {
        driver.quit();
    }
}
