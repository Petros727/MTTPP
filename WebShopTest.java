package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class WebShopTest {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demo.goshop.hr/");
    }

    @Test
    @Order(1)
    void testProfileSetup() {

        page.click("text=Moj profil");
        page.click("button:has-text('09')");
        page.click("span.text:has-text('099')");
        page.fill("input[name='mobitel_sufix']", "2233445");
        page.click("button:has-text('Traži PIN')");
        page.fill("input[name='sms_pin']", "1234");
        page.click("i[class*='fa-check']");
        page.fill("input[name='oib']", "12312312312");
        page.fill("input[name='email']", "marko@gmail.com");
        page.fill("input[name='naziv']", "MARKO");
        page.fill("input[name='adresa']", "TESTNA 12");
        page.click("button:has-text('Spremite podatke')");
        page.click(".bootbox-accept");
        page.click("span.white-text");
        page.click("text = Dućan");
    }

    @Test
    @Order(2)
    void testAddToCart() {
        page.click("text=Proizvod 1");
        page.fill("input[name='item_q']", "4");
        page.click("button:has-text('Dodaj u košaricu')");
        page.click("text=Proizvod 2");
        page.fill("input[name='item_q']", "55");
        page.click("button:has-text('Dodaj u košaricu')");
        page.click("a[href='/korpa']");
    }

    @Test
    @Order(3)
    void testCheckoutProcess() {
        page.click("button:has-text('Naruči')");
        page.fill("#address", "123 Test Street");
        page.fill("#city", "Testville");
        page.selectOption("select[name='shipping_method']", "DHL");
        page.selectOption("select[name='payment_method']", "virman");
        page.click("button:has-text('Potvrdi narudžbu')");
        assertTrue(page.locator("text=Vaša narudžba je potvrđena").isVisible());
    }

    @Test
    @Order(4)
    void testAdminLogin() {
        page.click("text=Admin");
        page.fill("input[name='lozinka']", "demo");
        page.fill("input[name='zaporka']", "demo");
        page.click("button:has-text('LOG IN')");
        page.fill("input[name='unlock']", "1234");
        page.click("button:has-text('LOG IN')");
        assertTrue(page.locator("span:text('IZVJEŠTAJI')").isVisible());
    }

    @Test
    @Order(5)
    void testReportsAccess() {
        page.click("span:text('IZVJEŠTAJI')");
        assertTrue(page.locator("text=Izvještaj A").isVisible());
        assertTrue(page.locator("text=Izvještaj B").isVisible());
    }

    @AfterAll
    static void tearDown() {
        browser.close();
        playwright.close();
    }
}
