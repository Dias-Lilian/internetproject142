//1 - Bibliotecas/ imports
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //biblioteca principal do Selenium
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static java.lang.Thread.sleep;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //biblioteca principal do Selenium
import org.openqa.selenium.chrome.ChromeDriver; //biblioteca principal do ChromeDriver

//2 -Classe 
public class LoginTest {
	//2.1 - Atributos/ atributos
	private WebDriver driver; //objeto do Selenium
	
	//2.2 - Funções e Métodos
	//Antes do Teste
	@BeforeEach
	public void iniciar() {
		driver = new ChromeDriver(); //instanciar o objeto do Selenium como ChromeDriver
		driver.manage().window().maximize(); //maximizar a janela do browser
	}

	//Depois do Teste
	@AfterEach
	public void finalizar() {
		driver.quit(); //destroi o objeto do Selenium
	}

	//Testes
	@Test
	public void Login() {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page
		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys(textField,"tomsmith");
		driver.findElement(By.id("password")).sendKeys(textField,"SuperSecretPassword!");
		driver.findElement(By.cssSelector("input.fa.fa-2x.fa-sign-in")).click();
		Thread.sleep(2000);
	}
		//Transição de Página
		//Login que deu certo
		assertEquals("Welcome to the Secure Area. When you are done click logout below.", driver.findElement(By.cssSelector("h4")).getText());
		driver.findElement(By.cssSelector("icon-2x.icon-signout")).click();


	//3 - Construtores/ construtores

	//4 - Getters e Setters/ getters e setters

	//5 - Metodos/ metodos
}
