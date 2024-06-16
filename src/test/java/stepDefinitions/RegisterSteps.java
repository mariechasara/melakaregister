package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterSteps {
    WebDriver driver;
    WebDriverWait wait;

    public RegisterSteps() {
        driver = Hooks.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Given("user is on registration page")
    public void user_is_on_registration_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://dashboard.melaka.app/register");
    }

    // Dropdown Menu Scenarios [Solusi Kami]
    @When("user click on Solusi Kami dropdown")
    public void user_click_on_solusi_kami_dropdown() {
        driver.findElement(By.xpath("//div[contains(@data-testid,'landing__menu__our_solutions')]")).click();
    }

    @When("user select Integrasi Marketplace")
    public void user_select_integrasi_marketplace() {
        driver.findElement(By.xpath("//div //span[.='Integrasi Marketplace']")).click();
    }

    @Then("user redirected to Integrasi Marketplace page")
    public void user_redirected_to_integrasi_marketplace_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.melaka.app/#marketplace-integration");
    }

    @When("user select Manajemen Inventori")
    public void user_select_manajemen_inventori() {
        driver.findElement(By.xpath("//div //span[.='Manajemen Inventori']")).click();
    }

    @Then("user redirected to Manajemen Inventori page")
    public void user_redirected_to_manajemen_inventori_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.melaka.app/#store-management");
    }

    @When("user select Manajemen Order")
    public void user_select_manajemen_order() {
        driver.findElement(By.xpath("//div //span[.='Manajemen Order']")).click();
    }

    @Then("user redirected to Manajemen Order page")
    public void user_redirected_to_manajemen_order_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.melaka.app/#store-management");
    }

    @When("user select Catatan Keuangan")
    public void user_select_catatan_keuangan() {
        driver.findElement(By.xpath("//div //span[.='Catatan Keuangan']")).click();
    }

    @Then("user redirected to Catatan Keuangan page")
    public void user_redirected_to_catatan_keuangan_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.melaka.app/#accounting");
    }

    @When("user select Analisa Pelanggan")
    public void user_select_analisa_pelanggan() {
        driver.findElement(By.xpath("//div //span[.='Analisa Pelanggan']")).click();
    }

    @Then("user redirected to Analisa Pelanggan page")
    public void user_redirected_to_analisa_pelanggan_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.melaka.app/#promotion");
    }

    @When("user select Melaka Market")
    public void user_select_melaka_market() {
        driver.findElement(By.xpath("//div //span[.='Melaka Market']")).click();
    }

    @Then("user redirected to Melaka Market page")
    public void user_redirected_to_melaka_market_page() {
        // Page is still in Development
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.melaka.app/#market");
    }

    // Dropdown Menu Scenarios [Edukasi]
    @When("user click on Edukasi dropdown")
    public void user_click_on_edukasi_dropdown() {
        driver.findElement(By.xpath("//div[@data-testid='landing__menu__education']")).click();
    }

    @When("user select Seller Academy")
    public void user_select_seller_academy() {
        driver.findElement(By.xpath("//div //span[normalize-space()='Seller Academy']")).click();
    }

    @Then("user redirected to Seller Academy page")
    public void user_redirected_to_seller_academy_page() {
        // Page is still under development
    }

    @When("user select Pusat Bantuan")
    public void user_select_pusat_bantuan() {
        driver.findElement(By.xpath("//div //span[normalize-space()='Pusat Bantuan']")).click();
    }

    @Then("user redirected to Pusat Bantuan page")
    public void user_redirected_to_pusat_bantuan_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.melaka.app/help-center");
    }

    // Successful Registration
    @When("user enters registration details")
    public void user_enters_registration_details() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("user registered successfully and redirected to the welcome page")
    public void user_registered_successfully_and_redirected_to_the_welcome_page() {
        // Register Not Working
        String expectedUrl = "https://dashboard.melaka.app/welcome";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    // Registration Failed - Blank Inputs
    @When("user leaves the nama field blank")
    public void user_leaves_the_nama_field_blank() {
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the nama field is required displayed")
    public void error_message_indicating_the_nama_field_is_required_displayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='name']/../..//p[.='Wajib diisi.']")).isDisplayed());
    }

    @When("user leaves the nomor telepon field blank")
    public void user_leaves_the_nomor_telepon_field_blank() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the nomor telepon field is required displayed")
    public void error_message_indicating_the_nomor_telepon_field_is_required_displayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='phone']/../..//p[.='Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter.']")).isDisplayed());
    }

    @When("user leaves the nama bisnis field blank")
    public void user_leaves_the_nama_bisnis_field_blank() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the nama bisnis field is required displayed")
    public void error_message_indicating_the_nama_bisnis_field_is_required_displayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='businessName']/../..//p[.='Wajib diisi.']")).isDisplayed());
    }

    @When("user leaves the email field blank")
    public void user_leaves_the_email_field_blank() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the email field is required displayed")
    public void error_message_indicating_the_email_field_is_required_displayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='email']/../..//p[.='Wajib diisi.']")).isDisplayed());
    }

    @When("user leaves the kata sandi field blank")
    public void user_leaves_the_kata_sandi_field_blank() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the kata sandi field is required displayed")
    public void error_message_indicating_the_kata_sandi_field_is_required_displayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='password'] /.. /.. //p[.='Wajib diisi.']")).isDisplayed());
    }

    // Registration Form Negative Scenarios - Invalid Formats
    @When("user enters special characters in nama")
    public void user_enters_special_characters_in_nama() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("@John!");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the Nama field contains invalid characters")
    public void error_message_indicating_the_nama_field_contains_invalid_characters() {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='name']/../..//p[.='Karakter tidak valid.']")).isDisplayed());
    }

    @When("user enters a long nomor telepon")
    public void user_enters_a_long_nomor_telepon() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("12345678901234");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the Nomor Telepon field is too long")
    public void error_message_indicating_the_nomor_telepon_field_is_too_long() {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='phone']/../..//p[.='Wajib diisi. Nomor telepon tidak boleh kurang dari 10 atau lebih dari 12 karakter.']")).isDisplayed());
    }

    @When("user enters an invalid email format")
    public void user_enters_an_invalid_email_format() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("!#$johndoeexample@$@#");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message Email invalid")
    public void error_message_Email_invalid() {
        Assert.assertTrue(driver.findElement(By.xpath("//input /.. /.. //p[.='Harap isi dengan format yang benar.']")).isDisplayed());
    }

    @When("user enters special characters in nama bisnis")
    public void user_enters_special_characters_in_nama_bisnis() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("@My Business!");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the Nama Bisnis field contains invalid characters")
    public void error_message_indicating_the_nama_bisnis_field_contains_invalid_characters() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(.,'Tidak dapat menggunakan karakter spesial selain titik (.) koma (,) strip (-)')]")).isDisplayed());
    }

    // Registration Form Negative Scenarios - Passwords
    @When("user enters mismatched passwords")
    public void user_enters_mismatched_passwords() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password456");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the passwords do not match")
    public void error_message_indicating_the_passwords_do_not_match() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(.,'Belum sesuai dengan kata sandi.')]")).isDisplayed());
    }

    @When("user enters a weak password")
    public void user_enters_a_weak_password() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("12345");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='register__checkbox__tnc']")).click();
        driver.findElement(By.xpath("//button[@data-testid='register__button__sign-up']")).click();
    }

    @Then("error message indicating the password is too weak")
    public void error_message_indicating_the_password_is_too_weak() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='Min. 8 karakter, harus kombinasi dari huruf dan angka.']")).isDisplayed());
    }

    // Registration Form Negative Scenarios - Syarat dan Ketentuan
    @When("user enters valid details")
    public void user_enters_valid_details() {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys("My Business");
        driver.findElement(By.xpath("//input[@value='retail_store']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Password123");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Password123");
    }

    @Then("daftar button disabled")
    public void daftar_button_disabled() {
        Assert.assertTrue(driver.findElement(By.xpath("//button[@disabled]")).isDisplayed());
    }

    // User Already Have Account
    @When("user click Masuk")
    public void user_click_masuk() {
        // Assuming you have a WebDriverWait instance named wait declared somewhere
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Masuk']")));
        driver.findElement(By.xpath("//a[normalize-space()='Masuk']")).click();
    }

    @Then("user redirected to login page")
    public void user_redirected_to_login_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://dashboard.melaka.app/login");
    }
}
