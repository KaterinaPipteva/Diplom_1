package praktikum;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

public class BunTest {

    private Faker faker;
    private Random random;
    private String name;
    private float price;
    Bun bun;

    @Before
    public void setUp(){
        faker = new Faker();
        random = new Random();
        name = faker.harryPotter().spell();
        price = random.nextFloat();
        bun = new Bun(name, price);
    }

    @Test
    public void getNameOfBunTest(){
        String actualName = bun.getName();
        Assert.assertEquals("There is not right name of bun", name, actualName);
    }

    @Test
    public void getPriceOfBunTest(){
        float actualPrice = bun.getPrice();
        Assert.assertEquals(price, actualPrice, 0.0f);
    }
}
