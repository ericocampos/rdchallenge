package br.com.rd;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pages {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseURL;
	private By loginButton = By.xpath(".//*[@id='menu']/div/div[2]/a");
	private By emailField = By.id("user_email");
	private By senhaField = By.id("user_password");
	private By entrarButton = By.xpath(".//*[@id='login-form']/div[3]/div[2]/input");
	private By user = By.cssSelector(".navbar-account-name");
	private By menuRelacionar = By.xpath(".//*[@id='menu']/div/div[2]/ul[1]/li[4]/a");
	private By leads = By.xpath(".//*[@id='menu']/div/div[2]/ul[1]/li[4]/ul/li[5]/a");
	private By leadsH1 = By.xpath(".//*[@id='page-header']/h1");
	private By criarSegmentacaoButton = By.xpath(".//*[@id='page-header']/a");
	private By segmentacaoHeader = By.xpath(".//*[@id='page-header']/h1/a");
	private By segmentacaoNome = By.id("segmentation_list_name");
	private By segmentacaoTermo = By.xpath(".//*[@id='content']/div[1]/form/div[3]/div/div[1]/div[2]/div/div[1]/div[5]/input");
	private By segmentacaoSalvar = By.id("save-segmentation");
	
	public void acessarHomePage() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		baseURL = "https://www.rdstation.com.br/";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public void login(String email, String senha) {
		
		driver.findElement(loginButton).click();
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(senhaField).sendKeys(senha);
		driver.findElement(entrarButton).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(user));
		
	}
	
	public void acessarSegmentacao(){
		driver.findElement(menuRelacionar).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(leads));
		driver.findElement(leads).click();
		assertEquals("Segmentação de Leads", driver.findElement(leadsH1).getText());
		
	}
	
	public void criarSegmentacao(String nome, String termo){
		driver.findElement(criarSegmentacaoButton).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(segmentacaoHeader));
		driver.findElement(segmentacaoNome).clear();
		driver.findElement(segmentacaoNome).sendKeys(nome);
		driver.findElement(segmentacaoTermo).sendKeys(termo);
		driver.findElement(segmentacaoSalvar).click();
		assertEquals(nome, driver.findElement(By.partialLinkText(nome)).getText());
		
	}
	

}
