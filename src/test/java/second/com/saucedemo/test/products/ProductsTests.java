package second.com.saucedemo.test.products;

import com.saucedemo.pages.ProductsPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import second.com.saucedemo.base.BaseTest;

public class ProductsTests extends BaseTest {

    @Test
    public void testProductsHeaderIsDisplayed() {
        ProductsPage productsPage = loginPage.logIntoApplication("standard_user", "secret_sauce");

        // Verif
        assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header is not displayed");
    }

}
