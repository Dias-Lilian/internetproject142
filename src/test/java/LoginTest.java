//1 - Bibliotecas/ imports
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //biblioteca principal do Selenium
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
	public void Login01() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu certo (usuario e senha corretos)
		assertEquals("Welcome to the Secure Area. When you are done click logout below.", 
		driver.findElement(By.cssSelector("h4")).getText());
		driver.findElement(By.linkText("Logout")).click();
	}

	@Test
	public void Login02() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("Tchau");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu errado (usuario correto e senha incorreta)
		String textoFlash = driver.findElement(By.id("flash")).getText(); 
		assertTrue(textoFlash.contains("Your password is invalid!"));
	}

	@Test
	public void Login03() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("chuchu");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu errado (usuario incorreto e senha correta)
		String textoFlash = driver.findElement(By.id("flash")).getText(); 
		assertTrue(textoFlash.contains("Your username is invalid!"));
	}

	@Test
	public void Login04() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("chuchu");
		driver.findElement(By.id("password")).sendKeys("chuchu");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu errado (usuario e senha incorretos)
		String textoFlash = driver.findElement(By.id("flash")).getText(); 
		assertTrue(textoFlash.contains("Your username is invalid!"));
	}

	@Test
	public void Login05() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu errado (usuario e senha em branco)
		String textoFlash = driver.findElement(By.id("flash")).getText(); 
		assertTrue(textoFlash.contains("Your username is invalid!"));
	}

	@Test
	public void Login06() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu errado (usuario em branco e senha correta)
		String textoFlash = driver.findElement(By.id("flash")).getText(); 
		assertTrue(textoFlash.contains("Your username is invalid!"));
	}

	@Test
	public void Login07() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu errado (usuario correto e senha em branco)
		String textoFlash = driver.findElement(By.id("flash")).getText(); 
		assertTrue(textoFlash.contains("Your password is invalid!"));
	}

	@Test
	public void Login08() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("chuchu");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu errado (usuario em branco e senha incorreta)
		String textoFlash = driver.findElement(By.id("flash")).getText(); 
		assertTrue(textoFlash.contains("Your username is invalid!"));
	}

	@Test
	public void Login09() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/login");// abre o site Login Page

		//informa usuario, senha e aperta o botao de login
		driver.findElement(By.id("username")).sendKeys("chuchu");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(2000);

		//Transição de Página
		//Login que deu errado (usuario incorreto e senha em branco)
		String textoFlash = driver.findElement(By.id("flash")).getText(); 
		assertTrue(textoFlash.contains("Your username is invalid!"));
	}

	//3 - Construtores/ construtores

	//4 - Getters e Setters/ getters e setters

	//5 - Metodos/ metodos
}